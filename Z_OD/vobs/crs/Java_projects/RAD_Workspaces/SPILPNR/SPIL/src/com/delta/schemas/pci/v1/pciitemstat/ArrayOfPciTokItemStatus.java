//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package com.delta.schemas.pci.v1.pciitemstat;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPciTokItemStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPciTokItemStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatusItem" type="{http://schemas.delta.com/pci/v1/pciitemstat}PciTokItemStatus" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPciTokItemStatus", namespace = "http://schemas.delta.com/pci/v1/pciitemstat", propOrder = {
    "statusItem"
})
public class ArrayOfPciTokItemStatus {

    @XmlElement(name = "StatusItem", nillable = true)
    protected List<PciTokItemStatus> statusItem;

    /**
     * Gets the value of the statusItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statusItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatusItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PciTokItemStatus }
     * 
     * 
     */
    public List<PciTokItemStatus> getStatusItem() {
        if (statusItem == null) {
            statusItem = new ArrayList<PciTokItemStatus>();
        }
        return this.statusItem;
    }

}
