/**
 * GetGroupMembersResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nwa.adsvmp;

public class GetGroupMembersResponse  implements java.io.Serializable {
    private com.nwa.adsvmp.GetGroupMembersResponseGetGroupMembersResult getGroupMembersResult;

    public GetGroupMembersResponse() {
    }

    public GetGroupMembersResponse(
           com.nwa.adsvmp.GetGroupMembersResponseGetGroupMembersResult getGroupMembersResult) {
           this.getGroupMembersResult = getGroupMembersResult;
    }


    /**
     * Gets the getGroupMembersResult value for this GetGroupMembersResponse.
     * 
     * @return getGroupMembersResult
     */
    public com.nwa.adsvmp.GetGroupMembersResponseGetGroupMembersResult getGetGroupMembersResult() {
        return getGroupMembersResult;
    }


    /**
     * Sets the getGroupMembersResult value for this GetGroupMembersResponse.
     * 
     * @param getGroupMembersResult
     */
    public void setGetGroupMembersResult(com.nwa.adsvmp.GetGroupMembersResponseGetGroupMembersResult getGroupMembersResult) {
        this.getGroupMembersResult = getGroupMembersResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGroupMembersResponse)) return false;
        GetGroupMembersResponse other = (GetGroupMembersResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getGroupMembersResult==null && other.getGetGroupMembersResult()==null) || 
             (this.getGroupMembersResult!=null &&
              this.getGroupMembersResult.equals(other.getGetGroupMembersResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getGetGroupMembersResult() != null) {
            _hashCode += getGetGroupMembersResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetGroupMembersResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">GetGroupMembersResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getGroupMembersResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "GetGroupMembersResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">>GetGroupMembersResponse>GetGroupMembersResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
