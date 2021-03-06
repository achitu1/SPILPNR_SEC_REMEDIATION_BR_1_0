//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.schemas.SpecialPassengerInfoList;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				ResponseType represents the status of the entire service
 * 				as well as information on the dependencies of the
 * 				service. For example, if a service retrieves information
 * 				from the database, the response will contain an status
 * 				entry for the service as well as the database.
 * 			
 * 
 * <p>Java class for CheckHealthResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckHealthResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceHealthStatus" type="{http://schemas.delta.com/common/checkhealth/v3}HealthStatusType"/>
 *         &lt;element name="HealthMessage" type="{http://schemas.delta.com/common/checkhealth/v3}HealthMessageType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckHealthResponseType", namespace = "http://schemas.delta.com/common/checkhealth/v3", propOrder = {
    "serviceHealthStatus",
    "healthMessage"
})
public class CheckHealthResponseType {

    @XmlElement(name = "ServiceHealthStatus", required = true)
    protected HealthStatusType serviceHealthStatus;
    @XmlElement(name = "HealthMessage")
    protected List<HealthMessageType> healthMessage;

    /**
     * Gets the value of the serviceHealthStatus property.
     * 
     * @return
     *     possible object is
     *     {@link HealthStatusType }
     *     
     */
    public HealthStatusType getServiceHealthStatus() {
        return serviceHealthStatus;
    }

    /**
     * Sets the value of the serviceHealthStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthStatusType }
     *     
     */
    public void setServiceHealthStatus(HealthStatusType value) {
        this.serviceHealthStatus = value;
    }

    /**
     * Gets the value of the healthMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the healthMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHealthMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HealthMessageType }
     * 
     * 
     */
    public List<HealthMessageType> getHealthMessage() {
        if (healthMessage == null) {
            healthMessage = new ArrayList<HealthMessageType>();
        }
        return this.healthMessage;
    }

}
