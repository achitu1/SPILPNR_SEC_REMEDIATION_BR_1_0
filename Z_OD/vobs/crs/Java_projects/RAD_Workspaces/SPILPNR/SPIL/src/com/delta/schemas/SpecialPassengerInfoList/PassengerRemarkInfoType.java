//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.schemas.SpecialPassengerInfoList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PassengerRemarkInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PassengerRemarkInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="FileReceivedLocalDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FileReceivedLocalTimeStamp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LegLocalDepartureDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LegLocalDepartureYearMonth" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MultiDepartureSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OperationalAirlineCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OperationalFlightNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OriginAirportCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RecordProcessDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RemarkSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RemarkText" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RemarkTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RowSeatNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PassengerRemarkInfoType")
public class PassengerRemarkInfoType {

    @XmlAttribute(name = "FileReceivedLocalDate")
    protected String fileReceivedLocalDate;
    @XmlAttribute(name = "FileReceivedLocalTimeStamp")
    protected String fileReceivedLocalTimeStamp;
    @XmlAttribute(name = "LegLocalDepartureDate")
    protected String legLocalDepartureDate;
    @XmlAttribute(name = "LegLocalDepartureYearMonth")
    protected String legLocalDepartureYearMonth;
    @XmlAttribute(name = "MultiDepartureSequenceNumber")
    protected String multiDepartureSequenceNumber;
    @XmlAttribute(name = "OperationalAirlineCode")
    protected String operationalAirlineCode;
    @XmlAttribute(name = "OperationalFlightNumber")
    protected String operationalFlightNumber;
    @XmlAttribute(name = "OriginAirportCode")
    protected String originAirportCode;
    @XmlAttribute(name = "RecordProcessDate")
    protected String recordProcessDate;
    @XmlAttribute(name = "RemarkSequenceNumber")
    protected String remarkSequenceNumber;
    @XmlAttribute(name = "RemarkText")
    protected String remarkText;
    @XmlAttribute(name = "RemarkTypeCode")
    protected String remarkTypeCode;
    @XmlAttribute(name = "RowSeatNumber")
    protected String rowSeatNumber;

    /**
     * Gets the value of the fileReceivedLocalDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileReceivedLocalDate() {
        return fileReceivedLocalDate;
    }

    /**
     * Sets the value of the fileReceivedLocalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileReceivedLocalDate(String value) {
        this.fileReceivedLocalDate = value;
    }

    /**
     * Gets the value of the fileReceivedLocalTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileReceivedLocalTimeStamp() {
        return fileReceivedLocalTimeStamp;
    }

    /**
     * Sets the value of the fileReceivedLocalTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileReceivedLocalTimeStamp(String value) {
        this.fileReceivedLocalTimeStamp = value;
    }

    /**
     * Gets the value of the legLocalDepartureDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegLocalDepartureDate() {
        return legLocalDepartureDate;
    }

    /**
     * Sets the value of the legLocalDepartureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegLocalDepartureDate(String value) {
        this.legLocalDepartureDate = value;
    }

    /**
     * Gets the value of the legLocalDepartureYearMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegLocalDepartureYearMonth() {
        return legLocalDepartureYearMonth;
    }

    /**
     * Sets the value of the legLocalDepartureYearMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegLocalDepartureYearMonth(String value) {
        this.legLocalDepartureYearMonth = value;
    }

    /**
     * Gets the value of the multiDepartureSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMultiDepartureSequenceNumber() {
        return multiDepartureSequenceNumber;
    }

    /**
     * Sets the value of the multiDepartureSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMultiDepartureSequenceNumber(String value) {
        this.multiDepartureSequenceNumber = value;
    }

    /**
     * Gets the value of the operationalAirlineCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationalAirlineCode() {
        return operationalAirlineCode;
    }

    /**
     * Sets the value of the operationalAirlineCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationalAirlineCode(String value) {
        this.operationalAirlineCode = value;
    }

    /**
     * Gets the value of the operationalFlightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationalFlightNumber() {
        return operationalFlightNumber;
    }

    /**
     * Sets the value of the operationalFlightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationalFlightNumber(String value) {
        this.operationalFlightNumber = value;
    }

    /**
     * Gets the value of the originAirportCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginAirportCode() {
        return originAirportCode;
    }

    /**
     * Sets the value of the originAirportCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginAirportCode(String value) {
        this.originAirportCode = value;
    }

    /**
     * Gets the value of the recordProcessDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordProcessDate() {
        return recordProcessDate;
    }

    /**
     * Sets the value of the recordProcessDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordProcessDate(String value) {
        this.recordProcessDate = value;
    }

    /**
     * Gets the value of the remarkSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarkSequenceNumber() {
        return remarkSequenceNumber;
    }

    /**
     * Sets the value of the remarkSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarkSequenceNumber(String value) {
        this.remarkSequenceNumber = value;
    }

    /**
     * Gets the value of the remarkText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarkText() {
        return remarkText;
    }

    /**
     * Sets the value of the remarkText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarkText(String value) {
        this.remarkText = value;
    }

    /**
     * Gets the value of the remarkTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarkTypeCode() {
        return remarkTypeCode;
    }

    /**
     * Sets the value of the remarkTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarkTypeCode(String value) {
        this.remarkTypeCode = value;
    }

    /**
     * Gets the value of the rowSeatNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRowSeatNumber() {
        return rowSeatNumber;
    }

    /**
     * Sets the value of the rowSeatNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRowSeatNumber(String value) {
        this.rowSeatNumber = value;
    }

}
