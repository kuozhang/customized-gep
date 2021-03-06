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
package org.apache.geronimo.st.v22.core;

import javax.enterprise.deploy.spi.TargetModuleID;

import org.apache.geronimo.deployment.plugin.TargetModuleIDImpl;
import org.apache.geronimo.st.v21.core.GeronimoV21Utils;
import org.apache.geronimo.st.core.IGeronimoVersionHandler;
import org.eclipse.wst.server.core.IModule;

/**
 * @version $Rev$ $Date$
 */
public class GeronimoV22VersionHandler implements IGeronimoVersionHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.geronimo.st.core.IGeronimoVersionHandler#getConfigID(org.eclipse.wst.server.core.IModule)
	 */
	public String getConfigID(IModule module) throws Exception {
		return GeronimoV21Utils.getConfigId(module);
	}
	
	/* (non-Javadoc)
	 * @see org.apache.geronimo.st.core.IGeronimoVersionHandler#createTargetModuleId(java.lang.String)
	 */
	public TargetModuleID createTargetModuleId(String configId) {
		return new TargetModuleIDImpl(null, configId);
	}
}
