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


package org.apache.geronimo.j2ee.corba_css_config;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for associationOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="associationOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="NoProtection"/>
 *     &lt;enumeration value="Integrity"/>
 *     &lt;enumeration value="Confidentiality"/>
 *     &lt;enumeration value="DetectReplay"/>
 *     &lt;enumeration value="DetectMisordering"/>
 *     &lt;enumeration value="EstablishTrustInTarget"/>
 *     &lt;enumeration value="EstablishTrustInClient"/>
 *     &lt;enumeration value="NoDelegation"/>
 *     &lt;enumeration value="SimpleDelegation"/>
 *     &lt;enumeration value="CompositeDelegation"/>
 *     &lt;enumeration value="IdentityAssertion"/>
 *     &lt;enumeration value="DelegationByClient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum AssociationOption {

    @XmlEnumValue("NoProtection")
    NO_PROTECTION("NoProtection"),
    @XmlEnumValue("Integrity")
    INTEGRITY("Integrity"),
    @XmlEnumValue("Confidentiality")
    CONFIDENTIALITY("Confidentiality"),
    @XmlEnumValue("DetectReplay")
    DETECT_REPLAY("DetectReplay"),
    @XmlEnumValue("DetectMisordering")
    DETECT_MISORDERING("DetectMisordering"),
    @XmlEnumValue("EstablishTrustInTarget")
    ESTABLISH_TRUST_IN_TARGET("EstablishTrustInTarget"),
    @XmlEnumValue("EstablishTrustInClient")
    ESTABLISH_TRUST_IN_CLIENT("EstablishTrustInClient"),
    @XmlEnumValue("NoDelegation")
    NO_DELEGATION("NoDelegation"),
    @XmlEnumValue("SimpleDelegation")
    SIMPLE_DELEGATION("SimpleDelegation"),
    @XmlEnumValue("CompositeDelegation")
    COMPOSITE_DELEGATION("CompositeDelegation"),
    @XmlEnumValue("IdentityAssertion")
    IDENTITY_ASSERTION("IdentityAssertion"),
    @XmlEnumValue("DelegationByClient")
    DELEGATION_BY_CLIENT("DelegationByClient");
    private final String value;

    AssociationOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssociationOption fromValue(String v) {
        for (AssociationOption c: AssociationOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
