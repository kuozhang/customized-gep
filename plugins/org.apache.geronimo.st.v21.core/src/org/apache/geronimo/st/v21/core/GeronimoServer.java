/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.geronimo.st.v21.core;

import java.io.File;
import javax.enterprise.deploy.spi.DeploymentManager;
import javax.enterprise.deploy.spi.factories.DeploymentFactory;

import org.apache.geronimo.deployment.plugin.factories.DeploymentFactoryImpl;
import org.apache.geronimo.deployment.plugin.jmx.JMXDeploymentManager;
import org.apache.geronimo.st.core.GeronimoRuntimeDelegate;
import org.apache.geronimo.st.core.GeronimoServerDelegate;
import org.apache.geronimo.st.core.IGeronimoVersionHandler;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.util.SocketUtil;

/**
 * @version $Rev: 554980 $ $Date: 2007-07-10 11:35:58 -0400 (Tue, 10 Jul 2007) $
 */
public class GeronimoServer extends GeronimoServerDelegate {

    public static final String PROPERTY_IN_PLACE_SHARED_LIB = "inPlaceSharedLib";
    public static final String PROPERTY_RUN_FROM_WORKSPACE = "runFromWorkspace";

    private static IGeronimoVersionHandler versionHandler = null;

    private static DeploymentFactory deploymentFactory;

    static {
        deploymentFactory = new DeploymentFactoryImpl();
    }

    /* (non-Javadoc)
     * @see org.apache.geronimo.st.core.GenericGeronimoServer#getContextRoot(org.eclipse.wst.server.core.IModule)
     */
    public String getContextRoot(IModule module) {
        return GeronimoV21Utils.getContextRoot(module);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.geronimo.st.core.IGeronimoServer#getDeployerURL()
     */
    public String getDeployerURL() {
        return "deployer:geronimo:jmx://" + getServer().getHost() + ":" + getRMINamingPort();
    }

    @Override
    public String getVMArgs() {
        String runtimeLocation = getServer().getRuntime().getLocation().toString();
        GeronimoRuntimeDelegate geronimoRuntimeDelegate = (GeronimoRuntimeDelegate) getServer().getRuntime().getAdapter(GeronimoRuntimeDelegate.class);
        if (geronimoRuntimeDelegate == null) {
            geronimoRuntimeDelegate = (GeronimoRuntimeDelegate) getServer().getRuntime().loadAdapter(GeronimoRuntimeDelegate.class,new NullProgressMonitor());
        }
        IVMInstall vmInstall = geronimoRuntimeDelegate.getVMInstall();
        String vmInstallLocation = vmInstall.getInstallLocation().getAbsolutePath() + "/jre";

        LibraryLocation[] libLocations = JavaRuntime.getLibraryLocations(vmInstall);
        IPath vmLibDir = null;
        for(int i = 0; i < libLocations.length; i++) {
            LibraryLocation loc = libLocations[i];
            IPath libDir = loc.getSystemLibraryPath().removeLastSegments(2);
            if(libDir.toOSString().endsWith("lib")) {
                vmLibDir = libDir;
                break;
            }
        }

        String cp = System.getProperty("path.separator");

        //-javaagent:"GERONIMO_BASE/bin/jpa.jar"
        String javaagent = "";
        File jpaJar = new File(runtimeLocation + "/bin/jpa.jar");
        if (jpaJar.exists()) {
            javaagent = "-javaagent:\"" + runtimeLocation + "/bin/jpa.jar\"";
        }

        //-Djava.ext.dirs="GERONIMO_BASE/lib/ext;JRE_HOME/lib/ext"
        String javaExtDirs = "-Djava.ext.dirs=\"" + runtimeLocation + "/lib/ext" + cp + vmLibDir.append("ext").toOSString() + "\"";

        //-Djava.endorsed.dirs="GERONIMO_BASE/lib/endorsed;JRE_HOME/lib/endorsed"
        String javaEndorsedDirs = "-Djava.endorsed.dirs=\"" + runtimeLocation + "/lib/endorsed" + cp + vmLibDir.append("endorsed").toOSString() + "\"";

        //-Dorg.apache.geronimo.base.dir="GERONIMO_BASE"
        String baseDir = "-Dorg.apache.geronimo.base.dir=" + runtimeLocation;

        String vmArgs = javaagent + " " + javaExtDirs + " " + javaEndorsedDirs;

        String superVMArgs = super.getVMArgs();
        if (superVMArgs != null) {
            vmArgs += " " + superVMArgs;
        }

        return vmArgs;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.geronimo.st.core.IGeronimoServer#getJMXServiceURL()
     */
    public String getJMXServiceURL() {
        String host = getServer().getHost();
        return "service:jmx:rmi://" + host + "/jndi/rmi://" + host + ":" + getRMINamingPort() + "/JMXConnector";
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.geronimo.st.core.IGeronimoServer#getJSR88DeployerJar()
     */
    public IPath getJSR88DeployerJar() {
        return getServer().getRuntime().getLocation().append("/lib/jsr88-deploymentfactory.jar");
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.geronimo.st.core.IGeronimoServer#getDeploymentFactory()
     */
    public DeploymentFactory getDeploymentFactory() {
        return deploymentFactory;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.geronimo.st.core.IGeronimoServer#configureDeploymentManager(javax.enterprise.deploy.spi.DeploymentManager)
     */
    public void configureDeploymentManager(DeploymentManager dm) {
        ((JMXDeploymentManager) dm).setLogConfiguration(true, true);
        boolean enableInPlace = SocketUtil.isLocalhost(getServer().getHost()) && isRunFromWorkspace();
        setInPlaceDeployment(dm, enableInPlace);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.geronimo.st.core.IGeronimoServer#getVersionHandler()
     */
    public IGeronimoVersionHandler getVersionHandler() {
        if (versionHandler == null)
            versionHandler = new GeronimoV21VersionHandler();
        return versionHandler;
    }

    public void setInPlaceDeployment(DeploymentManager dm, boolean enable) {
        ((JMXDeploymentManager) dm).setInPlace(enable);
    }

    /* (non-Javadoc)
     * @see org.apache.geronimo.st.core.IGeronimoServer#isInPlace()
     */
    public boolean isInPlaceSharedLib() {
        return getAttribute(PROPERTY_IN_PLACE_SHARED_LIB, false);
    }

    /* (non-Javadoc)
     * @see org.apache.geronimo.st.core.IGeronimoServer#isRunFromWorkspace()
     */
    public boolean isRunFromWorkspace() {
        return getAttribute(PROPERTY_RUN_FROM_WORKSPACE, false);
    }

    public void setInPlaceSharedLib(boolean enable) {
        setAttribute(PROPERTY_IN_PLACE_SHARED_LIB, enable);
    }

    public void setRunFromWorkspace(boolean enable) {
        setAttribute(PROPERTY_RUN_FROM_WORKSPACE, enable);
    }

    /* (non-Javadoc)
     * @see org.apache.geronimo.st.core.GeronimoServerDelegate#setDefaults(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void setDefaults(IProgressMonitor monitor) {
        super.setDefaults(monitor);
        setInPlaceSharedLib(false);
        setRunFromWorkspace(false);
    }

}