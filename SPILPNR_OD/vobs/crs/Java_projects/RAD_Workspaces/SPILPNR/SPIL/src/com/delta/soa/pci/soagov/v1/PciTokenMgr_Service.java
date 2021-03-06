//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package com.delta.soa.pci.soagov.v1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "PciTokenMgr", targetNamespace = "http://soa.delta.com/pci/soagov/v1", wsdlLocation = "WEB-INF/wsdl/PciTokenMgrConcrete.wsdl")
public class PciTokenMgr_Service
    extends Service
{

    private final static URL PCITOKENMGR_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = com.delta.soa.pci.soagov.v1.PciTokenMgr_Service.class.getResource("/WEB-INF/wsdl/PciTokenMgrConcrete.wsdl");
            if (url == null) throw new MalformedURLException("/WEB-INF/wsdl/PciTokenMgrConcrete.wsdl does not exist in the module.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        PCITOKENMGR_WSDL_LOCATION = url;
    }

    public PciTokenMgr_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PciTokenMgr_Service() {
        super(PCITOKENMGR_WSDL_LOCATION, new QName("http://soa.delta.com/pci/soagov/v1", "PciTokenMgr"));
    }

    /**
     * 
     * @return
     *     returns PciTokenMgr
     */
    @WebEndpoint(name = "PciTokenMgr_EP")
    public PciTokenMgr getPciTokenMgrEP() {
        return (PciTokenMgr)super.getPort(new QName("http://soa.delta.com/pci/soagov/v1", "PciTokenMgr_EP"), PciTokenMgr.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PciTokenMgr
     */
    @WebEndpoint(name = "PciTokenMgr_EP")
    public PciTokenMgr getPciTokenMgrEP(WebServiceFeature... features) {
        return (PciTokenMgr)super.getPort(new QName("http://soa.delta.com/pci/soagov/v1", "PciTokenMgr_EP"), PciTokenMgr.class, features);
    }

}
