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
 * <p>Java class for WaitListResponseInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WaitListResponseInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.delta.com/specialpassengerinfolisttypes/v1}WaitListPassengerInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaitListResponseInfoType", propOrder = {
    "waitListPassengerInfo"
})
public class WaitListResponseInfoType {

    @XmlElement(name = "WaitListPassengerInfo")
    protected List<WaitListPassengerInfoType> waitListPassengerInfo;

    /**
     * Gets the value of the waitListPassengerInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the waitListPassengerInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWaitListPassengerInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WaitListPassengerInfoType }
     * 
     * 
     */
    public List<WaitListPassengerInfoType> getWaitListPassengerInfo() {
        if (waitListPassengerInfo == null) {
            waitListPassengerInfo = new ArrayList<WaitListPassengerInfoType>();
        }
        return this.waitListPassengerInfo;
    }

}
