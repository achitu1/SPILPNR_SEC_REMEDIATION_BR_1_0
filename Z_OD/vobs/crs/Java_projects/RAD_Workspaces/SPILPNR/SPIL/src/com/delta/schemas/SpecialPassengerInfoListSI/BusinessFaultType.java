//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.schemas.SpecialPassengerInfoListSI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusinessFaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessFaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.delta.com/common/fault/v4}FaultDetailedInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessFaultType", namespace = "http://schemas.delta.com/common/fault/v4", propOrder = {
    "faultDetailedInfo"
})
public class BusinessFaultType {

    @XmlElement(name = "FaultDetailedInfo", required = true)
    protected FaultDetailsType faultDetailedInfo;

    /**
     * Gets the value of the faultDetailedInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FaultDetailsType }
     *     
     */
    public FaultDetailsType getFaultDetailedInfo() {
        return faultDetailedInfo;
    }

    /**
     * Sets the value of the faultDetailedInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaultDetailsType }
     *     
     */
    public void setFaultDetailedInfo(FaultDetailsType value) {
        this.faultDetailedInfo = value;
    }

}
