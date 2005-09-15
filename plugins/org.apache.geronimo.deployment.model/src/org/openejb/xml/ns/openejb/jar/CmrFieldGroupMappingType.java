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
package org.openejb.xml.ns.openejb.jar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cmr Field Group Mapping Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openejb.xml.ns.openejb.jar.CmrFieldGroupMappingType#getGroupName <em>Group Name</em>}</li>
 *   <li>{@link org.openejb.xml.ns.openejb.jar.CmrFieldGroupMappingType#getCmrFieldName <em>Cmr Field Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openejb.xml.ns.openejb.jar.JarPackage#getCmrFieldGroupMappingType()
 * @model extendedMetaData="name='cmr-field-group-mappingType' kind='elementOnly'"
 * @generated
 */
public interface CmrFieldGroupMappingType extends EObject {
    /**
     * Returns the value of the '<em><b>Group Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Group Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Group Name</em>' attribute.
     * @see #setGroupName(String)
     * @see org.openejb.xml.ns.openejb.jar.JarPackage#getCmrFieldGroupMappingType_GroupName()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='group-name' namespace='##targetNamespace'"
     * @generated
     */
    String getGroupName();

    /**
     * Sets the value of the '{@link org.openejb.xml.ns.openejb.jar.CmrFieldGroupMappingType#getGroupName <em>Group Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Group Name</em>' attribute.
     * @see #getGroupName()
     * @generated
     */
    void setGroupName(String value);

    /**
     * Returns the value of the '<em><b>Cmr Field Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cmr Field Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cmr Field Name</em>' attribute.
     * @see #setCmrFieldName(String)
     * @see org.openejb.xml.ns.openejb.jar.JarPackage#getCmrFieldGroupMappingType_CmrFieldName()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='cmr-field-name' namespace='##targetNamespace'"
     * @generated
     */
    String getCmrFieldName();

    /**
     * Sets the value of the '{@link org.openejb.xml.ns.openejb.jar.CmrFieldGroupMappingType#getCmrFieldName <em>Cmr Field Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cmr Field Name</em>' attribute.
     * @see #getCmrFieldName()
     * @generated
     */
    void setCmrFieldName(String value);

} // CmrFieldGroupMappingType