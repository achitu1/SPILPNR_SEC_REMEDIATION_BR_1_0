//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.schemas.SpecialPassengerInfoListSI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveSSRRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveSSRRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.delta.com/common/requestinfo/v4}RequestInfo"/>
 *         &lt;element ref="{http://schemas.delta.com/specialpassengerinfolisttypes/v1}SSRInquiryInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveSSRRequestType", propOrder = {
    "requestInfo",
    "ssrInquiryInfo"
})
public class RetrieveSSRRequestType {

    @XmlElement(name = "RequestInfo", namespace = "http://schemas.delta.com/common/requestinfo/v4", required = true)
    protected RequestInfoType requestInfo;
    @XmlElement(name = "SSRInquiryInfo", required = true)
    protected SSRInquiryInfoType ssrInquiryInfo;

    /**
     * Gets the value of the requestInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RequestInfoType }
     *     
     */
    public RequestInfoType getRequestInfo() {
        return requestInfo;
    }

    /**
     * Sets the value of the requestInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestInfoType }
     *     
     */
    public void setRequestInfo(RequestInfoType value) {
        this.requestInfo = value;
    }

    /**
     * Gets the value of the ssrInquiryInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SSRInquiryInfoType }
     *     
     */
    public SSRInquiryInfoType getSSRInquiryInfo() {
        return ssrInquiryInfo;
    }

    /**
     * Sets the value of the ssrInquiryInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SSRInquiryInfoType }
     *     
     */
    public void setSSRInquiryInfo(SSRInquiryInfoType value) {
        this.ssrInquiryInfo = value;
    }

}
