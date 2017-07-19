/**
 * FindGroupsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nwa.adsvmp;

public class FindGroupsResponse  implements java.io.Serializable {
    private java.lang.String findGroupsResult;

    public FindGroupsResponse() {
    }

    public FindGroupsResponse(
           java.lang.String findGroupsResult) {
           this.findGroupsResult = findGroupsResult;
    }


    /**
     * Gets the findGroupsResult value for this FindGroupsResponse.
     * 
     * @return findGroupsResult
     */
    public java.lang.String getFindGroupsResult() {
        return findGroupsResult;
    }


    /**
     * Sets the findGroupsResult value for this FindGroupsResponse.
     * 
     * @param findGroupsResult
     */
    public void setFindGroupsResult(java.lang.String findGroupsResult) {
        this.findGroupsResult = findGroupsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindGroupsResponse)) return false;
        FindGroupsResponse other = (FindGroupsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.findGroupsResult==null && other.getFindGroupsResult()==null) || 
             (this.findGroupsResult!=null &&
              this.findGroupsResult.equals(other.getFindGroupsResult())));
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
        if (getFindGroupsResult() != null) {
            _hashCode += getFindGroupsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FindGroupsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">FindGroupsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("findGroupsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "FindGroupsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
