//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.soa.updated.PCiTokenManager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * A response from the PCI Tokenization Token Manager service.
 * 
 * <p>Java class for PciTokMgrResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PciTokMgrResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="StatusList" type="{http://schemas.delta.com/pci/v1/pciitemstat}ArrayOfPciTokItemStatus"/>
 *         &lt;element name="AdditionalProviderInfo" type="{http://schemas.delta.com/pci/v1/dictionary}DictionaryType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="GeneratedBy">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\w+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="OperationName">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\w+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="RawTraceText">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value=".*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ReasonCode" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{3}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ReasonText">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value=".*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ServiceName">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\w+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="StatusCode" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{3}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="StatusText">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value=".*"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SvcTrackingId" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value=".+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="UserCorrelationId">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value=".+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PciTokMgrResponse", namespace = "http://schemas.delta.com/pci/v1/pcitokenmgrresp", propOrder = {
    "operationTimestamp",
    "statusList",
    "additionalProviderInfo"
})
public class PciTokMgrResponse {

    @XmlElement(name = "OperationTimestamp", namespace = "http://schemas.delta.com/pci/v1/pcitokenmgrresp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operationTimestamp;
    @XmlElement(name = "StatusList", namespace = "http://schemas.delta.com/pci/v1/pcitokenmgrresp", required = true)
    protected ArrayOfPciTokItemStatus statusList;
    @XmlElement(name = "AdditionalProviderInfo", namespace = "http://schemas.delta.com/pci/v1/pcitokenmgrresp", required = true)
    protected DictionaryType additionalProviderInfo;
    @XmlAttribute(name = "GeneratedBy")
    protected String generatedBy;
    @XmlAttribute(name = "OperationName")
    protected String operationName;
    @XmlAttribute(name = "RawTraceText")
    protected String rawTraceText;
    @XmlAttribute(name = "ReasonCode", required = true)
    protected String reasonCode;
    @XmlAttribute(name = "ReasonText")
    protected String reasonText;
    @XmlAttribute(name = "ServiceName")
    protected String serviceName;
    @XmlAttribute(name = "StatusCode", required = true)
    protected String statusCode;
    @XmlAttribute(name = "StatusText")
    protected String statusText;
    @XmlAttribute(name = "SvcTrackingId", required = true)
    protected String svcTrackingId;
    @XmlAttribute(name = "UserCorrelationId")
    protected String userCorrelationId;

    /**
     * Gets the value of the operationTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOperationTimestamp() {
        return operationTimestamp;
    }

    /**
     * Sets the value of the operationTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOperationTimestamp(XMLGregorianCalendar value) {
        this.operationTimestamp = value;
    }

    /**
     * Gets the value of the statusList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPciTokItemStatus }
     *     
     */
    public ArrayOfPciTokItemStatus getStatusList() {
        return statusList;
    }

    /**
     * Sets the value of the statusList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPciTokItemStatus }
     *     
     */
    public void setStatusList(ArrayOfPciTokItemStatus value) {
        this.statusList = value;
    }

    /**
     * Gets the value of the additionalProviderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DictionaryType }
     *     
     */
    public DictionaryType getAdditionalProviderInfo() {
        return additionalProviderInfo;
    }

    /**
     * Sets the value of the additionalProviderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DictionaryType }
     *     
     */
    public void setAdditionalProviderInfo(DictionaryType value) {
        this.additionalProviderInfo = value;
    }

    /**
     * Gets the value of the generatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneratedBy() {
        return generatedBy;
    }

    /**
     * Sets the value of the generatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneratedBy(String value) {
        this.generatedBy = value;
    }

    /**
     * Gets the value of the operationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * Sets the value of the operationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationName(String value) {
        this.operationName = value;
    }

    /**
     * Gets the value of the rawTraceText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRawTraceText() {
        return rawTraceText;
    }

    /**
     * Sets the value of the rawTraceText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRawTraceText(String value) {
        this.rawTraceText = value;
    }

    /**
     * Gets the value of the reasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCode(String value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the reasonText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonText() {
        return reasonText;
    }

    /**
     * Sets the value of the reasonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonText(String value) {
        this.reasonText = value;
    }

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the statusText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusText() {
        return statusText;
    }

    /**
     * Sets the value of the statusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusText(String value) {
        this.statusText = value;
    }

    /**
     * Gets the value of the svcTrackingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvcTrackingId() {
        return svcTrackingId;
    }

    /**
     * Sets the value of the svcTrackingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvcTrackingId(String value) {
        this.svcTrackingId = value;
    }

    /**
     * Gets the value of the userCorrelationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserCorrelationId() {
        return userCorrelationId;
    }

    /**
     * Sets the value of the userCorrelationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserCorrelationId(String value) {
        this.userCorrelationId = value;
    }

}
