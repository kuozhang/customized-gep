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
package org.apache.geronimo.st.v30.ui.editors;

import javax.xml.bind.JAXBElement;

import org.apache.geronimo.st.ui.editors.AbstractGeronimoJAXBBasedEditor;
import org.apache.geronimo.st.v30.core.GeronimoServerInfo;
import org.apache.geronimo.st.v30.core.GeronimoUtils;
import org.apache.geronimo.st.v30.core.jaxb.JAXBUtils;
import org.apache.geronimo.st.v30.ui.CommonMessages;
import org.apache.geronimo.st.v30.ui.pages.AppClientGeneralPage;
import org.apache.geronimo.st.v30.ui.pages.AppClientSecurityPage;
import org.apache.geronimo.st.v30.ui.pages.AppGeneralPage;
import org.apache.geronimo.st.v30.ui.pages.ConnectorOverviewPage;
import org.apache.geronimo.st.v30.ui.pages.ConnectorPage;
import org.apache.geronimo.st.v30.ui.pages.DeploymentPage;
import org.apache.geronimo.st.v30.ui.pages.EjbOverviewPage;
import org.apache.geronimo.st.v30.ui.pages.NamingFormPage;
import org.apache.geronimo.st.v30.ui.pages.SecurityPage;
import org.apache.geronimo.st.v30.ui.pages.WebGeneralPage;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

/**
 * @version $Rev$ $Date$
 */
public class GeronimoFormContentLoader extends AbstractGeronimoFormContentLoader {

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.geronimo.st.v30.ui.editors.AbstractGeronimoFormContentLoader#addApplicationPlanPages(org.eclipse.ui.forms.editor.FormEditor)
     */
    public void addApplicationPlanPages(FormEditor editor) throws PartInitException {
        editor.addPage(new AppGeneralPage(editor, "appgeneralpage", CommonMessages.editorTabGeneral));
        editor.addPage(new SecurityPage(editor, "securitypage", CommonMessages.editorTabSecurity));
        editor.addPage(new ConnectorPage(editor,"connectorpage",CommonMessages.editorTabConnector));
        editor.addPage(createDeploymentFormPage(editor));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.geronimo.st.v30.ui.editors.AbstractGeronimoFormContentLoader#addConnectorPlanPages(org.eclipse.ui.forms.editor.FormEditor)
     */
    public void addConnectorPlanPages(FormEditor editor) throws PartInitException {
        editor.addPage(new ConnectorOverviewPage(editor, "connectoroverview", CommonMessages.editorTabGeneral));
        editor.addPage(createDeploymentFormPage(editor));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.geronimo.st.v30.ui.editors.AbstractGeronimoFormContentLoader#addApplicationPlanPages(org.eclipse.ui.forms.editor.FormEditor)
     */
    public void addApplicationClientPlanPages(FormEditor editor) throws PartInitException {
        editor.addPage(new AppClientGeneralPage(editor, "appclientgeneralpage", CommonMessages.editorTabGeneral));
        editor.addPage(createNamingFormPage(editor));
        editor.addPage(new AppClientSecurityPage(editor, "securitypage", CommonMessages.editorTabSecurity));
        editor.addPage(createDeploymentFormPage(editor));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.geronimo.st.v30.ui.editors.AbstractGeronimoFormContentLoader#addOpenEjbPlanPages()
     */
    public void addOpenEjbPlanPages(FormEditor editor) throws PartInitException {
        editor.addPage(new EjbOverviewPage(editor, "ejboverview", CommonMessages.editorTabGeneral));
        editor.addPage(createNamingFormPage(editor));
        editor.addPage(new SecurityPage(editor, "securitypage", CommonMessages.editorTabSecurity));
        editor.addPage(createDeploymentFormPage(editor));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.geronimo.st.v30.ui.editors.AbstractGeronimoFormContentLoader#addWebPlanPages()
     */
    public void addWebPlanPages(FormEditor editor) throws PartInitException {
        AbstractGeronimoJAXBBasedEditor geronimoEditor = (AbstractGeronimoJAXBBasedEditor)editor;
        JAXBElement plan = geronimoEditor.getRootElement();
        editor.addPage(new WebGeneralPage(editor, "generalpage", CommonMessages.editorTabGeneral));
        editor.addPage(createNamingFormPage(editor));
        editor.addPage(new SecurityPage(editor, "securitypage", CommonMessages.editorTabSecurity));
        editor.addPage(createDeploymentFormPage(editor));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.geronimo.st.v30.ui.editors.IGeronimoFormContentLoader#loadDeploymentPlan(org.eclipse.core.resources.IFile)
     */
    public JAXBElement loadDeploymentPlan(IFile file) throws Exception {
        return GeronimoUtils.getDeploymentPlan(file);
    }
    
    public void saveDeploymentPlan(JAXBElement deploymentPlan, IFile file) throws Exception {
        JAXBUtils.marshalDeploymentPlan(deploymentPlan, file);
    }

    private NamingFormPage createNamingFormPage(FormEditor editor) {
        return new NamingFormPage(editor, "namingpage", CommonMessages.editorTabNaming);
    }

    private DeploymentPage createDeploymentFormPage(FormEditor editor) {
        return new DeploymentPage(editor, "deploymentpage", CommonMessages.editorTabDeployment);
    }

    public void triggerGeronimoServerInfoUpdate() {
        GeronimoServerInfo.getInstance().updateInfo();
    }
}
