//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package com.delta.schemas.pci.v1.pcipan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.delta.schemas.pci.v1.countryinfo.ISO3166CountryInfo;


/**
 * A representation of a credit card number that includes various pieces of metadata derived from the number.
 * 
 * <p>Java class for PciPan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PciPan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ISO3166CountryInfo" type="{http://schemas.delta.com/pci/v1/countryinfo}ISO3166CountryInfo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CheckDigit">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="FullCardNumber">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="(\d{5}[A-Z][A-Z0-9]{3,6}[A-Z]{0,3}\d{4}|\d{12,19})"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="IssuerAlphaIdentifier">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[A-Z]{2}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="IssuerName">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value=".{1,60}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="IssuerNumIdentifier">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{6}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="MajorIndustryIdentifierCode">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="MajorIndustryIdentifierName">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value=".{1,60}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="PersonalAccountNumber">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="\d{6,12}"/>
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
@XmlType(name = "PciPan", namespace = "http://schemas.delta.com/pci/v1/pcipan", propOrder = {
    "iso3166CountryInfo"
})
public class PciPan {

    @XmlElement(name = "ISO3166CountryInfo", required = true, nillable = true)
    protected ISO3166CountryInfo iso3166CountryInfo;
    @XmlAttribute(name = "CheckDigit")
    protected String checkDigit;
    @XmlAttribute(name = "FullCardNumber")
    protected String fullCardNumber;
    @XmlAttribute(name = "IssuerAlphaIdentifier")
    protected String issuerAlphaIdentifier;
    @XmlAttribute(name = "IssuerName")
    protected String issuerName;
    @XmlAttribute(name = "IssuerNumIdentifier")
    protected String issuerNumIdentifier;
    @XmlAttribute(name = "MajorIndustryIdentifierCode")
    protected String majorIndustryIdentifierCode;
    @XmlAttribute(name = "MajorIndustryIdentifierName")
    protected String majorIndustryIdentifierName;
    @XmlAttribute(name = "PersonalAccountNumber")
    protected String personalAccountNumber;

    /**
     * Gets the value of the iso3166CountryInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ISO3166CountryInfo }
     *     
     */
    public ISO3166CountryInfo getISO3166CountryInfo() {
        return iso3166CountryInfo;
    }

    /**
     * Sets the value of the iso3166CountryInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ISO3166CountryInfo }
     *     
     */
    public void setISO3166CountryInfo(ISO3166CountryInfo value) {
        this.iso3166CountryInfo = value;
    }

    /**
     * Gets the value of the checkDigit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckDigit() {
        return checkDigit;
    }

    /**
     * Sets the value of the checkDigit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckDigit(String value) {
        this.checkDigit = value;
    }

    /**
     * Gets the value of the fullCardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullCardNumber() {
        return fullCardNumber;
    }

    /**
     * Sets the value of the fullCardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullCardNumber(String value) {
        this.fullCardNumber = value;
    }

    /**
     * Gets the value of the issuerAlphaIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerAlphaIdentifier() {
        return issuerAlphaIdentifier;
    }

    /**
     * Sets the value of the issuerAlphaIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerAlphaIdentifier(String value) {
        this.issuerAlphaIdentifier = value;
    }

    /**
     * Gets the value of the issuerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerName() {
        return issuerName;
    }

    /**
     * Sets the value of the issuerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerName(String value) {
        this.issuerName = value;
    }

    /**
     * Gets the value of the issuerNumIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerNumIdentifier() {
        return issuerNumIdentifier;
    }

    /**
     * Sets the value of the issuerNumIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerNumIdentifier(String value) {
        this.issuerNumIdentifier = value;
    }

    /**
     * Gets the value of the majorIndustryIdentifierCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajorIndustryIdentifierCode() {
        return majorIndustryIdentifierCode;
    }

    /**
     * Sets the value of the majorIndustryIdentifierCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajorIndustryIdentifierCode(String value) {
        this.majorIndustryIdentifierCode = value;
    }

    /**
     * Gets the value of the majorIndustryIdentifierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajorIndustryIdentifierName() {
        return majorIndustryIdentifierName;
    }

    /**
     * Sets the value of the majorIndustryIdentifierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajorIndustryIdentifierName(String value) {
        this.majorIndustryIdentifierName = value;
    }

    /**
     * Gets the value of the personalAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalAccountNumber() {
        return personalAccountNumber;
    }

    /**
     * Sets the value of the personalAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalAccountNumber(String value) {
        this.personalAccountNumber = value;
    }

}
