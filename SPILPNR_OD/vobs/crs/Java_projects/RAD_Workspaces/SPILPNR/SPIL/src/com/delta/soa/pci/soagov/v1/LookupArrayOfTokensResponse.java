//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package com.delta.soa.pci.soagov.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.delta.schemas.pci.v1.pcitokenmgrresp.PciTokMgrResponse;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LookupArrayOfTokensResult" type="{http://schemas.delta.com/pci/v1/pcitokenmgrresp}PciTokMgrResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lookupArrayOfTokensResult"
})
@XmlRootElement(name = "LookupArrayOfTokensResponse")
public class LookupArrayOfTokensResponse {

    @XmlElement(name = "LookupArrayOfTokensResult", required = true)
    protected PciTokMgrResponse lookupArrayOfTokensResult;

    /**
     * Gets the value of the lookupArrayOfTokensResult property.
     * 
     * @return
     *     possible object is
     *     {@link PciTokMgrResponse }
     *     
     */
    public PciTokMgrResponse getLookupArrayOfTokensResult() {
        return lookupArrayOfTokensResult;
    }

    /**
     * Sets the value of the lookupArrayOfTokensResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PciTokMgrResponse }
     *     
     */
    public void setLookupArrayOfTokensResult(PciTokMgrResponse value) {
        this.lookupArrayOfTokensResult = value;
    }

}
