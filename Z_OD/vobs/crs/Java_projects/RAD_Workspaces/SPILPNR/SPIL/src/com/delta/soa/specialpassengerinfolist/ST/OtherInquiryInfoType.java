//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.soa.specialpassengerinfolist.ST;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OtherInquiryInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OtherInquiryInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="GovernmentId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PnrLocatorNum" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TicketNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherInquiryInfoType")
public class OtherInquiryInfoType {

    @XmlAttribute(name = "GovernmentId")
    protected String governmentId;
    @XmlAttribute(name = "PnrLocatorNum")
    protected String pnrLocatorNum;
    @XmlAttribute(name = "TicketNumber")
    protected String ticketNumber;

    /**
     * Gets the value of the governmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovernmentId() {
        return governmentId;
    }

    /**
     * Sets the value of the governmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovernmentId(String value) {
        this.governmentId = value;
    }

    /**
     * Gets the value of the pnrLocatorNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPnrLocatorNum() {
        return pnrLocatorNum;
    }

    /**
     * Sets the value of the pnrLocatorNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPnrLocatorNum(String value) {
        this.pnrLocatorNum = value;
    }

    /**
     * Gets the value of the ticketNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Sets the value of the ticketNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNumber(String value) {
        this.ticketNumber = value;
    }

}
