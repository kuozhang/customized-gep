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
package org.apache.geronimo.st.v20.core;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.geronimo.st.core.GeronimoUtils;
import org.apache.geronimo.st.core.jaxb.JAXBUtils;
import org.apache.geronimo.xml.ns.deployment_1.ArtifactType;
import org.apache.geronimo.xml.ns.deployment_1.EnvironmentType;
import org.apache.geronimo.xml.ns.j2ee.application_2.ApplicationType;
import org.apache.geronimo.xml.ns.j2ee.connector_1.ConnectorType;
import org.apache.geronimo.xml.ns.j2ee.ejb.openejb_2.OpenejbJarType;
import org.apache.geronimo.xml.ns.j2ee.web_2_0.WebAppType;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
import org.eclipse.wst.server.core.IModule;

/**
 * @version $Rev$ $Date$
 */
public class GeronimoV20Utils extends GeronimoUtils {
	
	public static JAXBElement getDeploymentPlan(IFile file) {
		if (!file.exists())
			return null;

		if (file.getName().equals(GeronimoUtils.APP_PLAN_NAME))
			return getApplicationDeploymentPlan(file);
		else if (file.getName().equals(GeronimoUtils.OPENEJB_PLAN_NAME))
			return getOpenEjbDeploymentPlan(file);
		else if (file.getName().equals(GeronimoUtils.WEB_PLAN_NAME))
			return getWebDeploymentPlan(file);
		else if (file.getName().equals(GeronimoUtils.CONNECTOR_PLAN_NAME))
			return getConnectorDeploymentPlan(file);

		return null;
	}
	
	//public static String getConfigId2(IModule module) {
	//	
	//	IFile planFile = null;
	//	IVirtualComponent comp = ComponentCore.createComponent(module.getProject());
	//	if (isWebModule(module)) {
	//		planFile = GeronimoUtils.getWebDeploymentPlanFile(comp);
	//	} else if (isEjbJarModule(module)) {
	//		planFile = GeronimoUtils.getOpenEjbDeploymentPlanFile(comp);
	//	} else if (isEarModule(module)) {
	//		planFile = GeronimoUtils.getApplicationDeploymentPlanFile(comp);
	//	} else if (isRARModule(module)) {
	//		planFile = GeronimoUtils.getConnectorDeploymentPlanFile(comp);
	//	}
	//	
	//	if(planFile != null) {
	//		try {
	//			XmlObject xmlObject = XmlBeansUtil.parse(planFile.getLocation().toFile());
	//			XmlCursor cursor = xmlObject.newCursor();
	//			cursor.toFirstChild();
	//			xmlObject = cursor.getObject();
	//			XmlObject result[] = xmlObject.selectChildren(QNameSet.singleton(EnvironmentDocument.type.getDocumentElementName()));
	//			if(result != null && result.length > 0) {
	//				org.apache.geronimo.deployment.xbeans.EnvironmentType env = (org.apache.geronimo.deployment.xbeans.EnvironmentType) result[0].changeType(org.apache.geronimo.deployment.xbeans.EnvironmentType.type);
	//				org.apache.geronimo.deployment.xbeans.ArtifactType moduleId = env.getModuleId();
	//				return getQualifiedConfigID(moduleId);
	//			}
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		} catch (XmlException e) {
	//			e.printStackTrace();
	//		}
	//	}
	//	
	//	return null;
	//}

	public static String getConfigId(IModule module) {

		EnvironmentType environment = null;
		if (isWebModule(module)) {
			WebAppType plan = getWebDeploymentPlan(module).getValue();
			if (plan != null)
				environment = plan.getEnvironment();
		} else if (isEjbJarModule(module)) {
			OpenejbJarType plan = getOpenEjbDeploymentPlan(module).getValue();
//			if (plan != null)
//				environment = plan.getEnvironment();
		} else if (isEarModule(module)) {
			ApplicationType plan = getApplicationDeploymentPlan(module).getValue();
			if (plan != null)
				environment = plan.getEnvironment();
		} else if (isRARModule(module)) {
			ConnectorType plan = getConnectorDeploymentPlan(module).getValue();
			if (plan != null)
				environment = plan.getEnvironment();
		}

		if (environment != null
				&& environment.getModuleId() != null) {
			return getQualifiedConfigID(environment.getModuleId());
		}

		return getId(module);
	}

	public static String getQualifiedConfigID(ArtifactType artifact) {
		return getQualifiedConfigID(artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion(), artifact.getType());
	}
	
	//public static String getQualifiedConfigID(org.apache.geronimo.deployment.xbeans.ArtifactType artifact) {
	//	return getQualifiedConfigID(artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion(), artifact.getType());
	//}

	public static String getContextRoot(IModule module) {
		String contextRoot = null;

		WebAppType deploymentPlan = getWebDeploymentPlan(module).getValue();
		if (deploymentPlan != null)
			contextRoot = deploymentPlan.getContextRoot();

		if (contextRoot == null)
			contextRoot = GeronimoUtils.getContextRoot(module);

		return contextRoot;
	}

	public static JAXBElement<WebAppType> getWebDeploymentPlan(IModule module) {
		return getWebDeploymentPlan(getVirtualComponent(module));
	}

	public static JAXBElement<ApplicationType> getApplicationDeploymentPlan(IModule module) {
		return getApplicationDeploymentPlan(getVirtualComponent(module));
	}

	public static JAXBElement<OpenejbJarType> getOpenEjbDeploymentPlan(IModule module) {
		return getOpenEjbDeploymentPlan(getVirtualComponent(module));
	}

	public static JAXBElement<ConnectorType> getConnectorDeploymentPlan(IModule module) {
		return getConnectorDeploymentPlan(getVirtualComponent(module));
	}

	public static JAXBElement<ApplicationType> getApplicationDeploymentPlan(IVirtualComponent comp) {
		return getApplicationDeploymentPlan(getApplicationDeploymentPlanFile(comp));
	}

	public static JAXBElement<WebAppType> getWebDeploymentPlan(IVirtualComponent comp) {
		return getWebDeploymentPlan(getWebDeploymentPlanFile(comp));
	}

	public static JAXBElement<OpenejbJarType> getOpenEjbDeploymentPlan(IVirtualComponent comp) {
		return getOpenEjbDeploymentPlan(getOpenEjbDeploymentPlanFile(comp));
	}

	public static JAXBElement<ConnectorType> getConnectorDeploymentPlan(IVirtualComponent comp) {
		return getConnectorDeploymentPlan(getConnectorDeploymentPlanFile(comp));
	}

	public static JAXBElement<ApplicationType> getApplicationDeploymentPlan(IFile file) {
		if (file.getName().equals(APP_PLAN_NAME) && file.exists()) {
//			ResourceSet resourceSet = new ResourceSetImpl();
//			register(resourceSet, new ApplicationResourceFactoryImpl(), ApplicationPackage.eINSTANCE, ApplicationPackage.eNS_URI);
//			Resource resource = load(file, resourceSet);
//			if (resource != null) {
//				return ((org.apache.geronimo.xml.ns.j2ee.application.DocumentRoot) resource.getContents().get(0)).getApplication();
//			}
			return JAXBUtils.unmarshalDeploymentPlan(file);
		}
		return null;
	}

	public static JAXBElement<WebAppType> getWebDeploymentPlan(IFile file) {
		if (file.getName().equals(WEB_PLAN_NAME) && file.exists()) {
//			ResourceSet resourceSet = new ResourceSetImpl();
//			register(resourceSet, new WebResourceFactoryImpl(), WebPackage.eINSTANCE, WebPackage.eNS_URI);
//			Resource resource = load(file, resourceSet);
//			if (resource != null) {
//				return ((DocumentRoot) resource.getContents().get(0)).getWebApp();
//			}
			return JAXBUtils.unmarshalDeploymentPlan(file);
		}
		return null;
	}

	public static JAXBElement<OpenejbJarType> getOpenEjbDeploymentPlan(IFile file) {
		if (file.getName().equals(OPENEJB_PLAN_NAME) && file.exists()) {
//			ResourceSet resourceSet = new ResourceSetImpl();
//			register(resourceSet, new JarResourceFactoryImpl(), JarPackage.eINSTANCE, JarPackage.eNS_URI);
//			Resource resource = load(file, resourceSet);
//			if (resource != null) {
//				return ((org.openejb.xml.ns.openejb.jar.DocumentRoot) resource.getContents().get(0)).getOpenejbJar();
//			}
			return JAXBUtils.unmarshalDeploymentPlan(file);
		}
		return null;
	}

	public static JAXBElement<ConnectorType> getConnectorDeploymentPlan(IFile file) {
		if (file.getName().equals(CONNECTOR_PLAN_NAME) && file.exists()) {
//			ResourceSet resourceSet = new ResourceSetImpl();
//			register(resourceSet, new ConnectorResourceFactoryImpl(), ConnectorPackage.eINSTANCE, ConnectorPackage.eNS_URI);
//			Resource resource = load(file, resourceSet);
//			if (resource != null) {
//				return ((org.apache.geronimo.xml.ns.j2ee.connector.DocumentRoot) resource.getContents().get(0)).getConnector();
//			}
			return JAXBUtils.unmarshalDeploymentPlan(file);
		}
		return null;
	}
}