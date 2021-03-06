//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-07/05/2013 05:25 AM(foreman)-)
//


package com.delta.soa.specialpassengerinfolist.ST;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "SpecialPassengerInfoList", targetNamespace = "http://soa.delta.com/specialpassengerinfolist", wsdlLocation = "WEB-INF/wsdl/specialpassengerinfolist.wsdl")
public class SpecialPassengerInfoList_Service
    extends Service
{

    private final static URL SPECIALPASSENGERINFOLIST_WSDL_LOCATION;
    private final static WebServiceException SPECIALPASSENGERINFOLIST_EXCEPTION;
    private final static QName SPECIALPASSENGERINFOLIST_QNAME = new QName("http://soa.delta.com/specialpassengerinfolist", "SpecialPassengerInfoList");

    static {
            SPECIALPASSENGERINFOLIST_WSDL_LOCATION = com.delta.soa.specialpassengerinfolist.ST.SpecialPassengerInfoList_Service.class.getResource("/WEB-INF/wsdl/specialpassengerinfolist.wsdl");
        WebServiceException e = null;
        if (SPECIALPASSENGERINFOLIST_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'WEB-INF/wsdl/specialpassengerinfolist.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        SPECIALPASSENGERINFOLIST_EXCEPTION = e;
    }

    public SpecialPassengerInfoList_Service() {
        super(__getWsdlLocation(), SPECIALPASSENGERINFOLIST_QNAME);
    }

    public SpecialPassengerInfoList_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SPECIALPASSENGERINFOLIST_QNAME, features);
    }

    public SpecialPassengerInfoList_Service(URL wsdlLocation) {
        super(wsdlLocation, SPECIALPASSENGERINFOLIST_QNAME);
    }

    public SpecialPassengerInfoList_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SPECIALPASSENGERINFOLIST_QNAME, features);
    }

    public SpecialPassengerInfoList_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SpecialPassengerInfoList_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SpecialPassengerInfoList
     */
    @WebEndpoint(name = "SpecialPassengerInfoList_EP")
    public SpecialPassengerInfoList getSpecialPassengerInfoListEP() {
        return super.getPort(new QName("http://soa.delta.com/specialpassengerinfolist", "SpecialPassengerInfoList_EP"), SpecialPassengerInfoList.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SpecialPassengerInfoList
     */
    @WebEndpoint(name = "SpecialPassengerInfoList_EP")
    public SpecialPassengerInfoList getSpecialPassengerInfoListEP(WebServiceFeature... features) {
        return super.getPort(new QName("http://soa.delta.com/specialpassengerinfolist", "SpecialPassengerInfoList_EP"), SpecialPassengerInfoList.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SPECIALPASSENGERINFOLIST_EXCEPTION!= null) {
            throw SPECIALPASSENGERINFOLIST_EXCEPTION;
        }
        return SPECIALPASSENGERINFOLIST_WSDL_LOCATION;
    }

}
