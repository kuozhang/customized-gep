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
package org.apache.geronimo.st.v21.ui.sections;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.geronimo.jee.naming.GbeanRef;
import org.apache.geronimo.st.ui.CommonMessages;
import org.apache.geronimo.st.ui.sections.AbstractTableSection;
import org.apache.geronimo.st.v21.ui.wizards.GBeanRefWizard;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @version $Rev$ $Date$
 */
public class GBeanRefSection extends AbstractTableSection {

	public GBeanRefSection(JAXBElement plan, Composite parent, FormToolkit toolkit, int style, List gbeanRef) {
		super(plan, parent, toolkit, style);
		this.objectContainer = gbeanRef;
		COLUMN_NAMES = new String[] {
		        CommonMessages.editorGBeanRefName, CommonMessages.editorGBeanRefType};
		createClient();
	}

	public String getTitle() {
		return CommonMessages.editorGBeanRefTitle;
	}

	public String getDescription() {
		return CommonMessages.editorGBeanRefDescription;
	}

	public Wizard getWizard() {
		return new GBeanRefWizard(this);
	}

	public Class getTableEntryObjectType() {
		return GbeanRef.class;
	}

    @Override
    public ITableLabelProvider getLabelProvider() {
        return new LabelProvider() {
            @Override
            public String getColumnText(Object element, int columnIndex) {
                if (GbeanRef.class.isInstance(element)) {
                    GbeanRef gbeanRef = (GbeanRef) element;
                    switch (columnIndex) {
                    case 0:
                        return gbeanRef.getRefName();
                    case 1:
                        return gbeanRef.getRefType().get(0);
                    }
                }
                return null;
            }
        };
    }
}
