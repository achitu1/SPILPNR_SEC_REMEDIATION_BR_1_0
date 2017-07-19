//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.schemas.SpecialPassengerInfoListSI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrievePassengerResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrievePassengerResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.delta.com/common/advisorymessage/v2}AdvisoryMessage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.delta.com/common/responseinfo/v1}ResponseInfo" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.delta.com/common/debuginfo/v4}DebugInfo" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.delta.com/specialpassengerinfolisttypes/v1}PassengerResponseInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrievePassengerResponseType", propOrder = {
    "advisoryMessage",
    "responseInfo",
    "debugInfo",
    "passengerResponseInfo"
})
public class RetrievePassengerResponseType {

    @XmlElement(name = "AdvisoryMessage", namespace = "http://schemas.delta.com/common/advisorymessage/v2")
    protected List<AdvisoryMessageType> advisoryMessage;
    @XmlElement(name = "ResponseInfo", namespace = "http://schemas.delta.com/common/responseinfo/v1")
    protected ResponseInfoType responseInfo;
    @XmlElement(name = "DebugInfo", namespace = "http://schemas.delta.com/common/debuginfo/v4")
    protected DebugInfoType debugInfo;
    @XmlElement(name = "PassengerResponseInfo")
    protected PassengerResponseInfoType passengerResponseInfo;

    /**
     * Gets the value of the advisoryMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the advisoryMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdvisoryMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdvisoryMessageType }
     * 
     * 
     */
    public List<AdvisoryMessageType> getAdvisoryMessage() {
        if (advisoryMessage == null) {
            advisoryMessage = new ArrayList<AdvisoryMessageType>();
        }
        return this.advisoryMessage;
    }

    /**
     * Gets the value of the responseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseInfoType }
     *     
     */
    public ResponseInfoType getResponseInfo() {
        return responseInfo;
    }

    /**
     * Sets the value of the responseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseInfoType }
     *     
     */
    public void setResponseInfo(ResponseInfoType value) {
        this.responseInfo = value;
    }

    /**
     * Gets the value of the debugInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DebugInfoType }
     *     
     */
    public DebugInfoType getDebugInfo() {
        return debugInfo;
    }

    /**
     * Sets the value of the debugInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebugInfoType }
     *     
     */
    public void setDebugInfo(DebugInfoType value) {
        this.debugInfo = value;
    }

    /**
     * Gets the value of the passengerResponseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PassengerResponseInfoType }
     *     
     */
    public PassengerResponseInfoType getPassengerResponseInfo() {
        return passengerResponseInfo;
    }

    /**
     * Sets the value of the passengerResponseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PassengerResponseInfoType }
     *     
     */
    public void setPassengerResponseInfo(PassengerResponseInfoType value) {
        this.passengerResponseInfo = value;
    }

}
