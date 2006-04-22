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
package org.apache.geronimo.st.v11.core.internal;

import org.eclipse.osgi.util.NLS;

/**
 * Translated messages.
 */
public class Messages extends NLS {

	static {
		NLS.initializeMessages("org.apache.geronimo.core.internal.Messages", Messages.class);
	}

	public static String DISTRIBUTE_FAIL;
	public static String START_FAIL;
	public static String STOP_FAIL;
	public static String UNDEPLOY_FAIL;
	public static String REDEPLOY_FAIL;
	public static String DM_CONNECTION_FAIL;

}