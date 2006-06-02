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
package org.apache.geronimo.st.ui.editors;

import org.apache.geronimo.st.core.GeronimoUtils;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

public abstract class AbstractGeronimoFormContentLoader implements IGeronimoFormContentLoader {

	/* (non-Javadoc)
	 * @see org.apache.geronimo.st.ui.editors.IGeronimoFormContentLoader#doAddPages(org.eclipse.ui.forms.editor.FormEditor)
	 */
	public void doAddPages(FormEditor editor) throws PartInitException{
		IEditorInput input = editor.getEditorInput();
		if(input instanceof IFileEditorInput) {
			String planFileName = ((IFileEditorInput) input).getFile().getName();
			if(GeronimoUtils.WEB_PLAN_NAME.equals(planFileName)) {
				addWebPlanPages(editor);
			} else if(GeronimoUtils.OPENEJB_PLAN_NAME.equals(planFileName)) {
				addOpenEjbPlanPages(editor);
			} else if(GeronimoUtils.CONNECTOR_PLAN_NAME.equals(planFileName)) {
				addConnectorPlanPages(editor);
			} else if(GeronimoUtils.APP_PLAN_NAME.equals(planFileName)) {
				addApplicationPlanPages(editor);
			}
		}
	}
	
	abstract public void addWebPlanPages(FormEditor editor) throws PartInitException;
	
	abstract public void addOpenEjbPlanPages(FormEditor editor) throws PartInitException;
	
	abstract public void addConnectorPlanPages(FormEditor editor) throws PartInitException;
	
	abstract public void addApplicationPlanPages(FormEditor editor) throws PartInitException;
}