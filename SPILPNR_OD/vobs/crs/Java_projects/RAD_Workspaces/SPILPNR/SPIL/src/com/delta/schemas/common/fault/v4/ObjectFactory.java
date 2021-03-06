//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package com.delta.schemas.common.fault.v4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.delta.schemas.common.fault.v4 package. 
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

    private final static QName _FaultDetailedInfo_QNAME = new QName("http://schemas.delta.com/common/fault/v4", "FaultDetailedInfo");
    private final static QName _SystemFault_QNAME = new QName("http://schemas.delta.com/common/fault/v4", "SystemFault");
    private final static QName _BusinessFault_QNAME = new QName("http://schemas.delta.com/common/fault/v4", "BusinessFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.delta.schemas.common.fault.v4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SystemFaultType }
     * 
     */
    public SystemFaultType createSystemFaultType() {
        return new SystemFaultType();
    }

    /**
     * Create an instance of {@link FaultDetailsType }
     * 
     */
    public FaultDetailsType createFaultDetailsType() {
        return new FaultDetailsType();
    }

    /**
     * Create an instance of {@link BusinessFaultType }
     * 
     */
    public BusinessFaultType createBusinessFaultType() {
        return new BusinessFaultType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultDetailsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.delta.com/common/fault/v4", name = "FaultDetailedInfo")
    public JAXBElement<FaultDetailsType> createFaultDetailedInfo(FaultDetailsType value) {
        return new JAXBElement<FaultDetailsType>(_FaultDetailedInfo_QNAME, FaultDetailsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.delta.com/common/fault/v4", name = "SystemFault")
    public JAXBElement<SystemFaultType> createSystemFault(SystemFaultType value) {
        return new JAXBElement<SystemFaultType>(_SystemFault_QNAME, SystemFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.delta.com/common/fault/v4", name = "BusinessFault")
    public JAXBElement<BusinessFaultType> createBusinessFault(BusinessFaultType value) {
        return new JAXBElement<BusinessFaultType>(_BusinessFault_QNAME, BusinessFaultType.class, null, value);
    }

}
