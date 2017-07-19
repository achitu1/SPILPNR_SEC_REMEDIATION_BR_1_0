//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package com.delta.schemas.common.advisorymessage.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdvisoryMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdvisoryMessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="FreeformText" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MessageNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Process" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Spare" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SscRequest" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdvisoryMessageType", namespace = "http://schemas.delta.com/common/advisorymessage/v2")
public class AdvisoryMessageType {

    @XmlAttribute(name = "FreeformText")
    protected String freeformText;
    @XmlAttribute(name = "MessageNumber")
    protected String messageNumber;
    @XmlAttribute(name = "Process")
    protected String process;
    @XmlAttribute(name = "Spare")
    protected String spare;
    @XmlAttribute(name = "SscRequest")
    protected String sscRequest;

    /**
     * Gets the value of the freeformText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeformText() {
        return freeformText;
    }

    /**
     * Sets the value of the freeformText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeformText(String value) {
        this.freeformText = value;
    }

    /**
     * Gets the value of the messageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageNumber() {
        return messageNumber;
    }

    /**
     * Sets the value of the messageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageNumber(String value) {
        this.messageNumber = value;
    }

    /**
     * Gets the value of the process property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcess() {
        return process;
    }

    /**
     * Sets the value of the process property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcess(String value) {
        this.process = value;
    }

    /**
     * Gets the value of the spare property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpare() {
        return spare;
    }

    /**
     * Sets the value of the spare property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpare(String value) {
        this.spare = value;
    }

    /**
     * Gets the value of the sscRequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSscRequest() {
        return sscRequest;
    }

    /**
     * Sets the value of the sscRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSscRequest(String value) {
        this.sscRequest = value;
    }

}
