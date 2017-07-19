package com.delta.soa.pci.soagov.v1;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

public class PciTokenMgr_EPProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private com.delta.soa.pci.soagov.v1.PciTokenMgr_Service _service = null;
        private com.delta.soa.pci.soagov.v1.PciTokenMgr _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            _service = new com.delta.soa.pci.soagov.v1.PciTokenMgr_Service();
            initCommon();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new com.delta.soa.pci.soagov.v1.PciTokenMgr_Service(wsdlLocation, serviceName);
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getPciTokenMgrEP();
        }

        public com.delta.soa.pci.soagov.v1.PciTokenMgr getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://soa.delta.com/pci/soagov/v1", "PciTokenMgr_EP");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) _proxy;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

            if (_dispatch != null ) {
                bp = (BindingProvider) _dispatch;
                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
            }
        }
    }

    public PciTokenMgr_EPProxy() {
        _descriptor = new Descriptor();
    }

    public PciTokenMgr_EPProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public DecodeArrayOfTokensResponse decodeArrayOfTokens(DecodeArrayOfTokensRequest parameters) {
        return _getDescriptor().getProxy().decodeArrayOfTokens(parameters);
    }

    public LookupArrayOfTokensResponse lookupArrayOfTokens(LookupArrayOfTokensRequest parameters) {
        return _getDescriptor().getProxy().lookupArrayOfTokens(parameters);
    }

}