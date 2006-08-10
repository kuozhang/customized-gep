/**
 *  Copyright 2006 The Apache Software Foundation
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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.wst.server.core.IModuleArtifact;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.model.LaunchableAdapterDelegate;

public class GeronimoLaunchableAdapterDelegate extends LaunchableAdapterDelegate {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.server.core.model.LaunchableAdapterDelegate#getLaunchable(org.eclipse.wst.server.core.IServer,
	 *      org.eclipse.wst.server.core.IModuleArtifact)
	 */
	public Object getLaunchable(IServer server, IModuleArtifact moduleArtifact) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

}