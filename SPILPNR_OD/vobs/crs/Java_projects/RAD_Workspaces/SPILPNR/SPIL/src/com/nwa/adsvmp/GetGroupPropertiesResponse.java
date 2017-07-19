/**
 * GetGroupPropertiesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nwa.adsvmp;

public class GetGroupPropertiesResponse  implements java.io.Serializable {
    private com.nwa.adsvmp.GetGroupPropertiesResponseGetGroupPropertiesResult getGroupPropertiesResult;

    public GetGroupPropertiesResponse() {
    }

    public GetGroupPropertiesResponse(
           com.nwa.adsvmp.GetGroupPropertiesResponseGetGroupPropertiesResult getGroupPropertiesResult) {
           this.getGroupPropertiesResult = getGroupPropertiesResult;
    }


    /**
     * Gets the getGroupPropertiesResult value for this GetGroupPropertiesResponse.
     * 
     * @return getGroupPropertiesResult
     */
    public com.nwa.adsvmp.GetGroupPropertiesResponseGetGroupPropertiesResult getGetGroupPropertiesResult() {
        return getGroupPropertiesResult;
    }


    /**
     * Sets the getGroupPropertiesResult value for this GetGroupPropertiesResponse.
     * 
     * @param getGroupPropertiesResult
     */
    public void setGetGroupPropertiesResult(com.nwa.adsvmp.GetGroupPropertiesResponseGetGroupPropertiesResult getGroupPropertiesResult) {
        this.getGroupPropertiesResult = getGroupPropertiesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGroupPropertiesResponse)) return false;
        GetGroupPropertiesResponse other = (GetGroupPropertiesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getGroupPropertiesResult==null && other.getGetGroupPropertiesResult()==null) || 
             (this.getGroupPropertiesResult!=null &&
              this.getGroupPropertiesResult.equals(other.getGetGroupPropertiesResult())));
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
        if (getGetGroupPropertiesResult() != null) {
            _hashCode += getGetGroupPropertiesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetGroupPropertiesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">GetGroupPropertiesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getGroupPropertiesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "GetGroupPropertiesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">>GetGroupPropertiesResponse>GetGroupPropertiesResult"));
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
