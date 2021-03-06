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

package org.apache.geronimo.jee.connector;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resourceadapterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resourceadapterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resourceadapter-instance" type="{http://geronimo.apache.org/xml/ns/j2ee/connector-1.2}resourceadapter-instanceType" minOccurs="0"/>
 *         &lt;element name="outbound-resourceadapter" type="{http://geronimo.apache.org/xml/ns/j2ee/connector-1.2}outbound-resourceadapterType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev$ $Date$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resourceadapterType", propOrder = {
    "resourceadapterInstance",
    "outboundResourceadapter"
})
public class Resourceadapter
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(name = "resourceadapter-instance")
    protected ResourceadapterInstance resourceadapterInstance;
    @XmlElement(name = "outbound-resourceadapter")
    protected OutboundResourceadapter outboundResourceadapter;

    /**
     * Gets the value of the resourceadapterInstance property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceadapterInstance }
     *     
     */
    public ResourceadapterInstance getResourceadapterInstance() {
        return resourceadapterInstance;
    }

    /**
     * Sets the value of the resourceadapterInstance property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceadapterInstance }
     *     
     */
    public void setResourceadapterInstance(ResourceadapterInstance value) {
        this.resourceadapterInstance = value;
    }

    /**
     * Gets the value of the outboundResourceadapter property.
     * 
     * @return
     *     possible object is
     *     {@link OutboundResourceadapter }
     *     
     */
    public OutboundResourceadapter getOutboundResourceadapter() {
        return outboundResourceadapter;
    }

    /**
     * Sets the value of the outboundResourceadapter property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutboundResourceadapter }
     *     
     */
    public void setOutboundResourceadapter(OutboundResourceadapter value) {
        this.outboundResourceadapter = value;
    }

}
