package com.nwa.adsvmp;

public class SearchADSoapProxy implements com.nwa.adsvmp.SearchADSoap {
  private String _endpoint = null;
  private com.nwa.adsvmp.SearchADSoap searchADSoap = null;
  
  public SearchADSoapProxy() {
    _initSearchADSoapProxy();
  }
  
  public SearchADSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSearchADSoapProxy();
  }
  
  private void _initSearchADSoapProxy() {
    try {
      searchADSoap = (new com.nwa.adsvmp.SearchADLocator()).getsearchADSoap();
      if (searchADSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)searchADSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)searchADSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (searchADSoap != null)
      ((javax.xml.rpc.Stub)searchADSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.nwa.adsvmp.SearchADSoap getSearchADSoap() {
    if (searchADSoap == null)
      _initSearchADSoapProxy();
    return searchADSoap;
  }
  
  public com.nwa.adsvmp.FindByIdResponseFindByIdResult findById(java.lang.String deltaNumber, java.lang.String nestedGroups, java.lang.String ADEnv) throws java.rmi.RemoteException{
    if (searchADSoap == null)
      _initSearchADSoapProxy();
    return searchADSoap.findById(deltaNumber, nestedGroups, ADEnv);
  }
  
  public java.lang.String findGroups(java.lang.String searchString, java.lang.String ADEnv) throws java.rmi.RemoteException{
    if (searchADSoap == null)
      _initSearchADSoapProxy();
    return searchADSoap.findGroups(searchString, ADEnv);
  }
  
  public com.nwa.adsvmp.FindByNwIdResponseFindByNwIdResult findByNwId(java.lang.String nwaNumber, java.lang.String nestedGroups, java.lang.String ADEnv) throws java.rmi.RemoteException{
    if (searchADSoap == null)
      _initSearchADSoapProxy();
    return searchADSoap.findByNwId(nwaNumber, nestedGroups, ADEnv);
  }
  
  public com.nwa.adsvmp.FindByDisplayNameResponseFindByDisplayNameResult findByDisplayName(java.lang.String displayName, java.lang.String ADEnv) throws java.rmi.RemoteException{
    if (searchADSoap == null)
      _initSearchADSoapProxy();
    return searchADSoap.findByDisplayName(displayName, ADEnv);
  }
  
  public com.nwa.adsvmp.FindByGuidResponseFindByGuidResult findByGuid(java.lang.String objectGUID, java.lang.String ADEnv) throws java.rmi.RemoteException{
    if (searchADSoap == null)
      _initSearchADSoapProxy();
    return searchADSoap.findByGuid(objectGUID, ADEnv);
  }
  
  public com.nwa.adsvmp.GetGroupPropertiesResponseGetGroupPropertiesResult getGroupProperties(java.lang.String groupName, java.lang.String ADEnv) throws java.rmi.RemoteException{
    if (searchADSoap == null)
      _initSearchADSoapProxy();
    return searchADSoap.getGroupProperties(groupName, ADEnv);
  }
  
  public com.nwa.adsvmp.GetGroupMembersResponseGetGroupMembersResult getGroupMembers(java.lang.String groupName, java.lang.String filter, java.lang.String nestedGroups, java.lang.String ADEnv) throws java.rmi.RemoteException{
    if (searchADSoap == null)
      _initSearchADSoapProxy();
    return searchADSoap.getGroupMembers(groupName, filter, nestedGroups, ADEnv);
  }
  
  
}