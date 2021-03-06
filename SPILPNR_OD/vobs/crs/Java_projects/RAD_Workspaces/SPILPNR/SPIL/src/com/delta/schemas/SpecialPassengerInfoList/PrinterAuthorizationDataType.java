//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.schemas.SpecialPassengerInfoList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrinterAuthorizationDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrinterAuthorizationDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ATBPrinterAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AdminPrinterAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BagPrinterAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BoardingCardPrinterAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrinterAuthorizationDataType", namespace = "http://schemas.delta.com/common/ptrauthdata/v2")
public class PrinterAuthorizationDataType {

    @XmlAttribute(name = "ATBPrinterAddress")
    protected String atbPrinterAddress;
    @XmlAttribute(name = "AdminPrinterAddress")
    protected String adminPrinterAddress;
    @XmlAttribute(name = "BagPrinterAddress")
    protected String bagPrinterAddress;
    @XmlAttribute(name = "BoardingCardPrinterAddress")
    protected String boardingCardPrinterAddress;

    /**
     * Gets the value of the atbPrinterAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getATBPrinterAddress() {
        return atbPrinterAddress;
    }

    /**
     * Sets the value of the atbPrinterAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setATBPrinterAddress(String value) {
        this.atbPrinterAddress = value;
    }

    /**
     * Gets the value of the adminPrinterAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminPrinterAddress() {
        return adminPrinterAddress;
    }

    /**
     * Sets the value of the adminPrinterAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminPrinterAddress(String value) {
        this.adminPrinterAddress = value;
    }

    /**
     * Gets the value of the bagPrinterAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBagPrinterAddress() {
        return bagPrinterAddress;
    }

    /**
     * Sets the value of the bagPrinterAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBagPrinterAddress(String value) {
        this.bagPrinterAddress = value;
    }

    /**
     * Gets the value of the boardingCardPrinterAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoardingCardPrinterAddress() {
        return boardingCardPrinterAddress;
    }

    /**
     * Sets the value of the boardingCardPrinterAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoardingCardPrinterAddress(String value) {
        this.boardingCardPrinterAddress = value;
    }

}
