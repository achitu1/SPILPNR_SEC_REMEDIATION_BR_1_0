/**
 * SearchADSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nwa.adsvmp;

public interface SearchADSoap extends java.rmi.Remote {

    /**
     * employee attributes by ppr id or corp login
     */
    public com.nwa.adsvmp.FindByIdResponseFindByIdResult findById(java.lang.String deltaNumber, java.lang.String nestedGroups, java.lang.String ADEnv) throws java.rmi.RemoteException;

    /**
     * groups by keyword (* wild character)
     */
    public java.lang.String findGroups(java.lang.String searchString, java.lang.String ADEnv) throws java.rmi.RemoteException;

    /**
     * employee attributes by person id or number
     */
    public com.nwa.adsvmp.FindByNwIdResponseFindByNwIdResult findByNwId(java.lang.String nwaNumber, java.lang.String nestedGroups, java.lang.String ADEnv) throws java.rmi.RemoteException;

    /**
     * employees by displayname (* wild character; 100 max records)
     */
    public com.nwa.adsvmp.FindByDisplayNameResponseFindByDisplayNameResult findByDisplayName(java.lang.String displayName, java.lang.String ADEnv) throws java.rmi.RemoteException;

    /**
     * employee by objectGUID (\7F\2A\F1\7F\7D\2C\40...)
     */
    public com.nwa.adsvmp.FindByGuidResponseFindByGuidResult findByGuid(java.lang.String objectGUID, java.lang.String ADEnv) throws java.rmi.RemoteException;

    /**
     * group properites
     */
    public com.nwa.adsvmp.GetGroupPropertiesResponseGetGroupPropertiesResult getGroupProperties(java.lang.String groupName, java.lang.String ADEnv) throws java.rmi.RemoteException;

    /**
     * group members (100 max records)
     */
    public com.nwa.adsvmp.GetGroupMembersResponseGetGroupMembersResult getGroupMembers(java.lang.String groupName, java.lang.String filter, java.lang.String nestedGroups, java.lang.String ADEnv) throws java.rmi.RemoteException;
}
