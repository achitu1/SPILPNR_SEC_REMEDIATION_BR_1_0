//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.soa.updated.PCiTokenManager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.delta.soa.updated.PCiTokenManager package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Dictionary_QNAME = new QName("http://schemas.delta.com/pci/v1/dictionary", "dictionary");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.delta.soa.updated.PCiTokenManager
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LookupArrayOfTokensResponse }
     * 
     */
    public LookupArrayOfTokensResponse createLookupArrayOfTokensResponse() {
        return new LookupArrayOfTokensResponse();
    }

    /**
     * Create an instance of {@link PciTokMgrResponse }
     * 
     */
    public PciTokMgrResponse createPciTokMgrResponse() {
        return new PciTokMgrResponse();
    }

    /**
     * Create an instance of {@link DecodeArrayOfTokensRequest }
     * 
     */
    public DecodeArrayOfTokensRequest createDecodeArrayOfTokensRequest() {
        return new DecodeArrayOfTokensRequest();
    }

    /**
     * Create an instance of {@link PciRequestInfo }
     * 
     */
    public PciRequestInfo createPciRequestInfo() {
        return new PciRequestInfo();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link DecodeArrayOfTokensResponse }
     * 
     */
    public DecodeArrayOfTokensResponse createDecodeArrayOfTokensResponse() {
        return new DecodeArrayOfTokensResponse();
    }

    /**
     * Create an instance of {@link LookupArrayOfTokensRequest }
     * 
     */
    public LookupArrayOfTokensRequest createLookupArrayOfTokensRequest() {
        return new LookupArrayOfTokensRequest();
    }

    /**
     * Create an instance of {@link PciToken }
     * 
     */
    public PciToken createPciToken() {
        return new PciToken();
    }

    /**
     * Create an instance of {@link DictionaryType }
     * 
     */
    public DictionaryType createDictionaryType() {
        return new DictionaryType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link ISO3166CountryInfo }
     * 
     */
    public ISO3166CountryInfo createISO3166CountryInfo() {
        return new ISO3166CountryInfo();
    }

    /**
     * Create an instance of {@link PciTokItemStatus }
     * 
     */
    public PciTokItemStatus createPciTokItemStatus() {
        return new PciTokItemStatus();
    }

    /**
     * Create an instance of {@link ArrayOfPciTokItemStatus }
     * 
     */
    public ArrayOfPciTokItemStatus createArrayOfPciTokItemStatus() {
        return new ArrayOfPciTokItemStatus();
    }

    /**
     * Create an instance of {@link PciPan }
     * 
     */
    public PciPan createPciPan() {
        return new PciPan();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.delta.com/pci/v1/dictionary", name = "dictionary")
    public JAXBElement<DictionaryType> createDictionary(DictionaryType value) {
        return new JAXBElement<DictionaryType>(_Dictionary_QNAME, DictionaryType.class, null, value);
    }

}
