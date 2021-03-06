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
package org.apache.geronimo.st.v30.core.descriptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jst.j2ee.common.SecurityRole;
import org.eclipse.jst.j2ee.ejb.AssemblyDescriptor;
import org.eclipse.jst.j2ee.ejb.EJBJar;

/**
 * @version $Rev$ $Date$
 */
public class EjbJ2EEDeploymentDescriptor extends AbstractDeploymentDescriptor implements
        EjbDeploymentDescriptor {

    HashMap<String, String> requiredInfo;

    public EjbJ2EEDeploymentDescriptor(EJBJar ejb) {
        super(ejb);
        requiredInfo = new HashMap<String, String>();
        requiredInfo.put("class", "org.eclipse.jst.j2ee.ejb.EJBJar");
        requiredInfo.put("nameGetter", "getName");
    }

    public List<String> getSecurityRoles() {
        EJBJar ejb = (EJBJar)this.obj;
        AssemblyDescriptor ad = ejb.getAssemblyDescriptor();
        
        if (ad != null) {
            List<SecurityRole> roles = ad.getSecurityRoles();
            ArrayList<String> result = new ArrayList<String>();
            for (SecurityRole role: roles) {
                result.add(role.getRoleName());
            }
            return result;
        }
        return null;
    }
}
