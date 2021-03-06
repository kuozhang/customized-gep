//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.2-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.07.29 at 06:48:36 PM IST 
//


package org.apache.geronimo.jee.loginconfig;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.apache.geronimo.xml.ns.loginconfig_2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginConfig_QNAME = new QName("http://geronimo.apache.org/xml/ns/loginconfig-2.0", "login-config");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.apache.geronimo.xml.ns.loginconfig_2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginConfig }
     * 
     */
    public LoginConfig createLoginConfigType() {
        return new LoginConfig();
    }

    /**
     * Create an instance of {@link LoginModule }
     * 
     */
    public LoginModule createLoginModuleType() {
        return new LoginModule();
    }

    /**
     * Create an instance of {@link LoginModuleRef }
     * 
     */
    public LoginModuleRef createLoginModuleRefType() {
        return new LoginModuleRef();
    }

    /**
     * Create an instance of {@link Option }
     * 
     */
    public Option createOptionType() {
        return new Option();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginConfig }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://geronimo.apache.org/xml/ns/loginconfig-2.0", name = "login-config")
    public JAXBElement<LoginConfig> createLoginConfig(LoginConfig value) {
        return new JAXBElement<LoginConfig>(_LoginConfig_QNAME, LoginConfig.class, null, value);
    }

}
