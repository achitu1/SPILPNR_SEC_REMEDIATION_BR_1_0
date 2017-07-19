package com.delta.soa.specialpassengerinfolist.ST;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class SpecialPassengerInfoList_EPProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private com.delta.soa.specialpassengerinfolist.ST.SpecialPassengerInfoList_Service _service = null;
        private com.delta.soa.specialpassengerinfolist.ST.SpecialPassengerInfoList _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new com.delta.soa.specialpassengerinfolist.ST.SpecialPassengerInfoList_Service(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new com.delta.soa.specialpassengerinfolist.ST.SpecialPassengerInfoList_Service();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getSpecialPassengerInfoListEP();
        }

        public com.delta.soa.specialpassengerinfolist.ST.SpecialPassengerInfoList getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://soa.delta.com/specialpassengerinfolist", "SpecialPassengerInfoList_EP");
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

        public void setMTOMEnabled(boolean enable) {
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
            binding.setMTOMEnabled(enable);
        }
    }

    public SpecialPassengerInfoList_EPProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public SpecialPassengerInfoList_EPProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public CheckHealthResponseType checkHealth(CheckHealthGenericRequestType params) {
        return _getDescriptor().getProxy().checkHealth(params);
    }

    public RetrieveSSRResponseType retrieveSSR(RetrieveSSRRequestType params) throws BusinessFault, SystemFault {
        return _getDescriptor().getProxy().retrieveSSR(params);
    }

    public OnDemandResponseType onDemand(OnDemandRequestType params) throws BusinessFault, SystemFault {
        return _getDescriptor().getProxy().onDemand(params);
    }

    public RetrievePassengerResponseType retrievePassenger(RetrievePassengerRequestType params) throws BusinessFault, SystemFault {
        return _getDescriptor().getProxy().retrievePassenger(params);
    }

    public RetrieveWaitListResponseType retrieveWaitList(RetrieveWaitListRequestType params) throws BusinessFault, SystemFault {
        return _getDescriptor().getProxy().retrieveWaitList(params);
    }

}