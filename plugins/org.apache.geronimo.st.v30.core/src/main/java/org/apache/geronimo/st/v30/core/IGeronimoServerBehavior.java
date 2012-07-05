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
package org.apache.geronimo.st.v30.core;

import java.io.File;

import javax.enterprise.deploy.spi.Target;

import org.eclipse.core.runtime.IPath;

/**
 * @version $Rev$ $Date$
 */
public interface IGeronimoServerBehavior {
    public static String VAR_CATALINA_DIR = "var" + File.separator + "catalina" + File.separator;
    
    public static String REPOSITORY_DIR = "repository" + File.separator;

    public boolean isFullyStarted();

    public boolean isKernelAlive();

    public void setServerStarted();

    public void setServerStopped();
    
    public Target[] getTargets();
    
    /**
     * Return the Resource under server installation directory
     * 
     * @param path the relative file path under the server installation directory
     * @return
     */
    public IPath getServerResource(String path);

}
