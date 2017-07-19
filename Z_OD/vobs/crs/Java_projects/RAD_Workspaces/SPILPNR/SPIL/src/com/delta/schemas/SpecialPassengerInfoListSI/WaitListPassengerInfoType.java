//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.schemas.SpecialPassengerInfoListSI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WaitListPassengerInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WaitListPassengerInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="BoardedTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DestinationAirportCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="EmployeeSeniorityDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FileReceivedLocalDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FileReceivedLocalTimeStamp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LegLocalDepartureDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LegLocalDepartureYearMonth" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MultiDepartureSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OperationalAirlineCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OperationalFlightNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OriginAirportCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PassengerName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PnrLocatorNum" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RecordProcessDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ReservationTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TravelClassCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VerifiedTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="WaitlistPassengerListingNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="WaitlistSvcTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="WaitlistTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="WaitlistUTCCreationTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaitListPassengerInfoType")
public class WaitListPassengerInfoType {

    @XmlAttribute(name = "BoardedTypeCode")
    protected String boardedTypeCode;
    @XmlAttribute(name = "DestinationAirportCode")
    protected String destinationAirportCode;
    @XmlAttribute(name = "EmployeeSeniorityDate")
    protected String employeeSeniorityDate;
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
    @XmlAttribute(name = "PassengerName")
    protected String passengerName;
    @XmlAttribute(name = "PnrLocatorNum")
    protected String pnrLocatorNum;
    @XmlAttribute(name = "RecordProcessDate")
    protected String recordProcessDate;
    @XmlAttribute(name = "ReservationTypeCode")
    protected String reservationTypeCode;
    @XmlAttribute(name = "TravelClassCode")
    protected String travelClassCode;
    @XmlAttribute(name = "VerifiedTypeCode")
    protected String verifiedTypeCode;
    @XmlAttribute(name = "WaitlistPassengerListingNumber")
    protected String waitlistPassengerListingNumber;
    @XmlAttribute(name = "WaitlistSvcTypeCode")
    protected String waitlistSvcTypeCode;
    @XmlAttribute(name = "WaitlistTypeCode")
    protected String waitlistTypeCode;
    @XmlAttribute(name = "WaitlistUTCCreationTime")
    protected String waitlistUTCCreationTime;

    /**
     * Gets the value of the boardedTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoardedTypeCode() {
        return boardedTypeCode;
    }

    /**
     * Sets the value of the boardedTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoardedTypeCode(String value) {
        this.boardedTypeCode = value;
    }

    /**
     * Gets the value of the destinationAirportCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    /**
     * Sets the value of the destinationAirportCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationAirportCode(String value) {
        this.destinationAirportCode = value;
    }

    /**
     * Gets the value of the employeeSeniorityDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeSeniorityDate() {
        return employeeSeniorityDate;
    }

    /**
     * Sets the value of the employeeSeniorityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeSeniorityDate(String value) {
        this.employeeSeniorityDate = value;
    }

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
     * Gets the value of the passengerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * Sets the value of the passengerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerName(String value) {
        this.passengerName = value;
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
     * Gets the value of the reservationTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationTypeCode() {
        return reservationTypeCode;
    }

    /**
     * Sets the value of the reservationTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationTypeCode(String value) {
        this.reservationTypeCode = value;
    }

    /**
     * Gets the value of the travelClassCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelClassCode() {
        return travelClassCode;
    }

    /**
     * Sets the value of the travelClassCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelClassCode(String value) {
        this.travelClassCode = value;
    }

    /**
     * Gets the value of the verifiedTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerifiedTypeCode() {
        return verifiedTypeCode;
    }

    /**
     * Sets the value of the verifiedTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerifiedTypeCode(String value) {
        this.verifiedTypeCode = value;
    }

    /**
     * Gets the value of the waitlistPassengerListingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitlistPassengerListingNumber() {
        return waitlistPassengerListingNumber;
    }

    /**
     * Sets the value of the waitlistPassengerListingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitlistPassengerListingNumber(String value) {
        this.waitlistPassengerListingNumber = value;
    }

    /**
     * Gets the value of the waitlistSvcTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitlistSvcTypeCode() {
        return waitlistSvcTypeCode;
    }

    /**
     * Sets the value of the waitlistSvcTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitlistSvcTypeCode(String value) {
        this.waitlistSvcTypeCode = value;
    }

    /**
     * Gets the value of the waitlistTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitlistTypeCode() {
        return waitlistTypeCode;
    }

    /**
     * Sets the value of the waitlistTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitlistTypeCode(String value) {
        this.waitlistTypeCode = value;
    }

    /**
     * Gets the value of the waitlistUTCCreationTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitlistUTCCreationTime() {
        return waitlistUTCCreationTime;
    }

    /**
     * Sets the value of the waitlistUTCCreationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitlistUTCCreationTime(String value) {
        this.waitlistUTCCreationTime = value;
    }

}
