/**
 * Copyright 2004, 2005 The Apache Software Foundation or its licensors, as applicable
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.geronimo.st.core;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.apache.geronimo.st.core.internal.Messages;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMInstallType;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.server.core.model.RuntimeDelegate;

abstract public class GeronimoRuntimeDelegate extends RuntimeDelegate implements IGeronimoRuntime {

	private static final String PROP_VM_INSTALL_TYPE_ID = "vm-install-type-id";

	private static final String PROP_VM_INSTALL_ID = "vm-install-id";

	public static final String SERVER_INSTANCE_PROPERTIES = "geronimo_server_instance_properties";

	public static final int NO_IMAGE = 0;

	public static final int INCORRECT_VERSION = 1;

	public static final int PARTIAL_IMAGE = 2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jst.server.core.IJavaRuntime#getVMInstall()
	 */
	public IVMInstall getVMInstall() {
		if (getVMInstallTypeId() == null)
			return JavaRuntime.getDefaultVMInstall();
		try {
			IVMInstallType vmInstallType = JavaRuntime.getVMInstallType(getVMInstallTypeId());
			IVMInstall[] vmInstalls = vmInstallType.getVMInstalls();
			int size = vmInstalls.length;
			String id = getVMInstallId();
			for (int i = 0; i < size; i++) {
				if (id.equals(vmInstalls[i].getId()))
					return vmInstalls[i];
			}
		} catch (Exception e) {
			// ignore
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.server.core.model.RuntimeDelegate#validate()
	 */
	public IStatus validate() {
		IStatus status = super.validate();

		if (!status.isOK()) {
			return status;
		}

		if (getVMInstall() == null)
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.errorJRE, null);

		IPath runtimeLoc = getRuntime().getLocation();

		// check for server file structure
		int count = 0;
		count = runtimeLoc.append("bin/server.jar").toFile().exists() ? ++count
				: count;
		count = runtimeLoc.append("bin/deployer.jar").toFile().exists() ? ++count
				: count;
		count = runtimeLoc.append("lib").toFile().exists() ? ++count : ++count;
		count = runtimeLoc.append("repository").toFile().exists() ? ++count
				: count;

		if (count == 0)
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, NO_IMAGE, null, null);

		if (count < 4) {
			// part of a server image was found, don't let install happen
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, PARTIAL_IMAGE, Messages.missingContent, null);
		}

		String detectedVersion = detectVersion();
		if (detectedVersion == null)
			return new Status(IStatus.WARNING, Activator.PLUGIN_ID, INCORRECT_VERSION, Messages.noVersion, null);

		if (!detectedVersion.startsWith(getRuntime().getRuntimeType().getVersion())) {
			String message = NLS.bind(Messages.incorrectVersion, new String[] {
					getRuntime().getRuntimeType().getVersion(), detectedVersion });
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, INCORRECT_VERSION, message, null);
		}

		return Status.OK_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.server.core.model.RuntimeDelegate#setDefaults(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void setDefaults(IProgressMonitor monitor) {
		IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
		setVMInstall(vmInstall.getVMInstallType().getId(), vmInstall.getId());
	}

	/**
	 * @return
	 */
	public String detectVersion() {

		File libDir = getRuntime().getLocation().append("lib").toFile();
		if (libDir.exists()) {
			File[] libs = libDir.listFiles();
			URL systemjarURL = null;
			for (int i = 0; i < libs.length; i++) {
				if (libs[i].getName().startsWith("geronimo-system")) {
					try {
						systemjarURL = libs[i].toURL();
						break;
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
			}
			if (systemjarURL != null) {
				URLClassLoader cl = new URLClassLoader(new URL[] { systemjarURL });
				try {
					Class clazz = cl.loadClass("org.apache.geronimo.system.serverinfo.ServerConstants");
					Method method = clazz.getMethod("getVersion", new Class[] {});
					return (String) method.invoke(null, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public String getInstallableTomcatRuntimeId() {
		String version = getRuntime().getRuntimeType().getVersion();
		if ("1.0".equals(version)) {
			return "org.apache.geronimo.runtime.tomcat.10";
		} else if ("1.1".equals(version)) {
			return "org.apache.geronimo.runtime.tomcat.11";
		}
		return null;
	}

	/**
	 * @return
	 */
	public String getInstallableJettyRuntimeId() {
		String version = getRuntime().getRuntimeType().getVersion();
		if ("1.0".equals(version)) {
			return "org.apache.geronimo.runtime.jetty.10";
		} else if ("1.1".equals(version)) {
			return "org.apache.geronimo.runtime.jetty.11";
		}
		return null;
	}

	/**
	 * @return
	 */
	public Map getServerInstanceProperties() {
		return getAttribute(SERVER_INSTANCE_PROPERTIES, new HashMap());
	}

	/**
	 * @param map
	 */
	public void setServerInstanceProperties(Map map) {
		setAttribute(SERVER_INSTANCE_PROPERTIES, map);
	}

	/**
	 * @param vmInstall
	 */
	public void setVMInstall(IVMInstall vmInstall) {
		if (vmInstall == null) {
			setVMInstall(null, null);
		} else
			setVMInstall(vmInstall.getVMInstallType().getId(), vmInstall.getId());
	}

	/**
	 * @param typeId
	 * @param id
	 */
	public void setVMInstall(String typeId, String id) {
		if (typeId == null)
			setAttribute(PROP_VM_INSTALL_TYPE_ID, (String) null);
		else
			setAttribute(PROP_VM_INSTALL_TYPE_ID, typeId);

		if (id == null)
			setAttribute(PROP_VM_INSTALL_ID, (String) null);
		else
			setAttribute(PROP_VM_INSTALL_ID, id);
	}

	/**
	 * @return
	 */
	public String getVMInstallTypeId() {
		return getAttribute(PROP_VM_INSTALL_TYPE_ID, (String) null);
	}

	/**
	 * @return
	 */
	public String getVMInstallId() {
		return getAttribute(PROP_VM_INSTALL_ID, (String) null);
	}

	/**
	 * @return
	 */
	public boolean isUsingDefaultJRE() {
		return getVMInstallTypeId() == null;
	}
}