/**

 * SearchADLocator.java

 *

 * This file was auto-generated from WSDL

 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.

 */



package com.nwa.adsvmp;

import com.delta.common.SPILPropertyManager;



public class SearchADLocator extends org.apache.axis.client.Service implements com.nwa.adsvmp.SearchAD {



    public SearchADLocator() {

    }





    public SearchADLocator(org.apache.axis.EngineConfiguration config) {

        super(config);

    }



    public SearchADLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {

        super(wsdlLoc, sName);

    }



    // Use to get a proxy class for searchADSoap
//SearchAD Webservice Update code change
    
/*	String Url = SPILPropertyManager.getProperty("SEARCHADURL");
    private java.lang.String searchADSoap_address = Url+"/searchad.asmx";*/
    
  // private java.lang.String searchADSoap_address = "http://searchad-int.delta.com/searchad.asmx";
    private java.lang.String searchADSoap_address = "http://searchad.delta.com/searchad.asmx";


///////////////////// code change end
    public java.lang.String getsearchADSoapAddress() {

        return searchADSoap_address;

    }



    // The WSDD service name defaults to the port name.

    private java.lang.String searchADSoapWSDDServiceName = "searchADSoap";



    public java.lang.String getsearchADSoapWSDDServiceName() {

        return searchADSoapWSDDServiceName;

    }



    public void setsearchADSoapWSDDServiceName(java.lang.String name) {

        searchADSoapWSDDServiceName = name;

    }



    public com.nwa.adsvmp.SearchADSoap getsearchADSoap() throws javax.xml.rpc.ServiceException {

       java.net.URL endpoint;

        try {

            endpoint = new java.net.URL(searchADSoap_address);

        }

        catch (java.net.MalformedURLException e) {

            throw new javax.xml.rpc.ServiceException(e);

        }

        return getsearchADSoap(endpoint);

    }



    public com.nwa.adsvmp.SearchADSoap getsearchADSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {

        try {

            com.nwa.adsvmp.SearchADSoapStub _stub = new com.nwa.adsvmp.SearchADSoapStub(portAddress, this);

            _stub.setPortName(getsearchADSoapWSDDServiceName());

            return _stub;

        }

        catch (org.apache.axis.AxisFault e) {

            return null;

        }

    }



    public void setsearchADSoapEndpointAddress(java.lang.String address) {

        searchADSoap_address = address;

    }





    // Use to get a proxy class for searchADSoap12
/////////SearchAD Webservice Update code change
 //   private java.lang.String searchADSoap12_address = "http://searchad-int.delta.com/searchad.asmx";
    private java.lang.String searchADSoap12_address = "http://searchad.delta.com/searchad.asmx";
    
  //  private java.lang.String searchADSoap12_address = Url + "/searchad.asmx";

    
    ////////////// code change end


    public java.lang.String getsearchADSoap12Address() {

        return searchADSoap12_address;

    }



    // The WSDD service name defaults to the port name.

    private java.lang.String searchADSoap12WSDDServiceName = "searchADSoap12";



    public java.lang.String getsearchADSoap12WSDDServiceName() {

        return searchADSoap12WSDDServiceName;

    }



    public void setsearchADSoap12WSDDServiceName(java.lang.String name) {

        searchADSoap12WSDDServiceName = name;

    }



    public com.nwa.adsvmp.SearchADSoap getsearchADSoap12() throws javax.xml.rpc.ServiceException {

       java.net.URL endpoint;

        try {

            endpoint = new java.net.URL(searchADSoap12_address);

        }

        catch (java.net.MalformedURLException e) {

            throw new javax.xml.rpc.ServiceException(e);

        }

        return getsearchADSoap12(endpoint);

    }



    public com.nwa.adsvmp.SearchADSoap getsearchADSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {

        try {

            com.nwa.adsvmp.SearchADSoap12Stub _stub = new com.nwa.adsvmp.SearchADSoap12Stub(portAddress, this);

            _stub.setPortName(getsearchADSoap12WSDDServiceName());

            return _stub;

        }

        catch (org.apache.axis.AxisFault e) {

            return null;

        }

    }



    public void setsearchADSoap12EndpointAddress(java.lang.String address) {

        searchADSoap12_address = address;

    }



    /**

     * For the given interface, get the stub implementation.

     * If this service has no port for the given interface,

     * then ServiceException is thrown.

     * This service has multiple ports for a given interface;

     * the proxy implementation returned may be indeterminate.

     */

    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {

        try {

            if (com.nwa.adsvmp.SearchADSoap.class.isAssignableFrom(serviceEndpointInterface)) {

                com.nwa.adsvmp.SearchADSoapStub _stub = new com.nwa.adsvmp.SearchADSoapStub(new java.net.URL(searchADSoap_address), this);

                _stub.setPortName(getsearchADSoapWSDDServiceName());

                return _stub;

            }

            if (com.nwa.adsvmp.SearchADSoap.class.isAssignableFrom(serviceEndpointInterface)) {

                com.nwa.adsvmp.SearchADSoap12Stub _stub = new com.nwa.adsvmp.SearchADSoap12Stub(new java.net.URL(searchADSoap12_address), this);

                _stub.setPortName(getsearchADSoap12WSDDServiceName());

                return _stub;

            }

        }

        catch (java.lang.Throwable t) {

            throw new javax.xml.rpc.ServiceException(t);

        }

        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));

    }



    /**

     * For the given interface, get the stub implementation.

     * If this service has no port for the given interface,

     * then ServiceException is thrown.

     */

    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {

        if (portName == null) {

            return getPort(serviceEndpointInterface);

        }

        java.lang.String inputPortName = portName.getLocalPart();

        if ("searchADSoap".equals(inputPortName)) {

            return getsearchADSoap();

        }

        else if ("searchADSoap12".equals(inputPortName)) {

            return getsearchADSoap12();

        }

        else  {

            java.rmi.Remote _stub = getPort(serviceEndpointInterface);

            ((org.apache.axis.client.Stub) _stub).setPortName(portName);

            return _stub;

        }

    }



    public javax.xml.namespace.QName getServiceName() {

        return new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "searchAD");

    }



    private java.util.HashSet ports = null;



    public java.util.Iterator getPorts() {

        if (ports == null) {

            ports = new java.util.HashSet();

            ports.add(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "searchADSoap"));

            ports.add(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "searchADSoap12"));

        }

        return ports.iterator();

    }



    /**

    * Set the endpoint address for the specified port name.

    */

    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

        

if ("searchADSoap".equals(portName)) {

            setsearchADSoapEndpointAddress(address);

        }

        else 

if ("searchADSoap12".equals(portName)) {

            setsearchADSoap12EndpointAddress(address);

        }

        else 

{ // Unknown Port Name

            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);

        }

    }



    /**

    * Set the endpoint address for the specified port name.

    */

    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

        setEndpointAddress(portName.getLocalPart(), address);

    }



}

