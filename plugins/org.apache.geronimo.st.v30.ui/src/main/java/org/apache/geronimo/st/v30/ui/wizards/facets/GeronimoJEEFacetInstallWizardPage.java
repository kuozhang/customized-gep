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
package org.apache.geronimo.st.v30.ui.wizards.facets;

import org.apache.geronimo.st.ui.internal.Messages;
import org.apache.geronimo.st.v30.core.facets.DeploymentPlanInstallConfig;
import org.apache.geronimo.st.v30.ui.Activator;
import org.apache.geronimo.st.v30.ui.CommonMessages;
import org.apache.geronimo.st.v30.ui.internal.Trace;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.common.project.facet.ui.AbstractFacetWizardPage;

/**
 * <b>GeroniomoJEEFacetInstallWizardPage</b> gathers user input to create the Geronmio deployment plan. It
 *    is invoked just prior to the installation of the corresponding facet. 
 * 
 * @version $Rev$ $Date$
 */
public class GeronimoJEEFacetInstallWizardPage extends AbstractFacetWizardPage {

    private DeploymentPlanInstallConfig config;

    private Text groupText;
    private Text artifactText;
    private Text versionText;
    private Text typeText;
    private Button sharedLib;

    public GeronimoJEEFacetInstallWizardPage() {
        super("geronimo.plan.install");
        Trace.tracePoint("Constructor Entry", Activator.logWizards, "GeroniomoJEEFacetInstallWizardPage");
        
        setTitle(Messages.geronimoDeploymentPlan);
        setDescription(Messages.configGeronimoDeploymentPlan);
        
        Trace.tracePoint("Constructor Exit", Activator.logWizards, "GeronimoJEEFacetInstallWizardPage");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.wst.common.project.facet.ui.IFacetWizardPage#setConfig(java.lang.Object)
     */
    public void setConfig(Object config) {
        Trace.tracePoint("Entry", Activator.logWizards, "GeronimoJEEFacetInstallWizardPage.setConfig", config);

        this.config = (DeploymentPlanInstallConfig) config;
        
        Trace.tracePoint("Exit", Activator.logWizards, "GeronimoJEEFacetInstallWizardPage.setConfig");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent) {
        Trace.tracePoint("Entry", Activator.logWizards, "GeronimoJEEFacetInstallWizardPage.createControl", parent);
        
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout(2, false));

        Label groupLabel = new Label(composite, SWT.NONE);
        groupLabel.setText(CommonMessages.groupId);

        groupText = new Text(composite, SWT.BORDER);
        groupText.setLayoutData(createGridData());
        groupText.setText("default");
        
        Label artifactLabel = new Label(composite, SWT.NONE);
        artifactLabel.setText(CommonMessages.artifactId);

        artifactText = new Text(composite, SWT.BORDER);
        artifactText.setLayoutData(createGridData());
        
        Label versionLabel = new Label(composite, SWT.NONE);
        versionLabel.setText(CommonMessages.version);

        versionText = new Text(composite, SWT.BORDER);
        versionText.setLayoutData(createGridData());
        versionText.setText("1.0");
        
        Label typeLabel = new Label(composite, SWT.NONE);
        typeLabel.setText(CommonMessages.artifactType);

        typeText = new Text(composite, SWT.BORDER);
        typeText.setLayoutData(createGridData());
        typeText.setText("car");
        
        sharedLib = new Button(composite, SWT.CHECK);
        GridData data = createGridData();
        data.horizontalSpan = 2;
        data.verticalIndent = 5;
        sharedLib.setLayoutData(data);
        sharedLib.setText(CommonMessages.addSharedLib);
        
        setControl(composite);
        
        Trace.tracePoint("Exit", Activator.logWizards, "GeronimoJEEFacetInstallWizardPage.createControl");      
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.wst.common.project.facet.ui.AbstractFacetWizardPage#transferStateToConfig()
     */
    public void transferStateToConfig() {
        Trace.tracePoint("Entry", Activator.logWizards, "GeronimoJEEFacetInstallWizardPage.transferStateToConfig");     
    
        config.setGroupId(groupText.getText());
        config.setArtifactId(artifactText.getText());
        config.setVersion(versionText.getText());
        config.setType(typeText.getText());
        config.setSharedLib(sharedLib.getSelection());
        
        Trace.tracePoint("Exit", Activator.logWizards, "GeronimoJEEFacetInstallWizardPage.transferStateToConfig");      
    }

    private static GridData createGridData() {
        return new GridData(GridData.FILL_HORIZONTAL);
    }
}
