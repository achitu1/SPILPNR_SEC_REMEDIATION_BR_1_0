/**
 * FindByNwIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nwa.adsvmp;

public class FindByNwIdResponse  implements java.io.Serializable {
    private com.nwa.adsvmp.FindByNwIdResponseFindByNwIdResult findByNwIdResult;

    public FindByNwIdResponse() {
    }

    public FindByNwIdResponse(
           com.nwa.adsvmp.FindByNwIdResponseFindByNwIdResult findByNwIdResult) {
           this.findByNwIdResult = findByNwIdResult;
    }


    /**
     * Gets the findByNwIdResult value for this FindByNwIdResponse.
     * 
     * @return findByNwIdResult
     */
    public com.nwa.adsvmp.FindByNwIdResponseFindByNwIdResult getFindByNwIdResult() {
        return findByNwIdResult;
    }


    /**
     * Sets the findByNwIdResult value for this FindByNwIdResponse.
     * 
     * @param findByNwIdResult
     */
    public void setFindByNwIdResult(com.nwa.adsvmp.FindByNwIdResponseFindByNwIdResult findByNwIdResult) {
        this.findByNwIdResult = findByNwIdResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindByNwIdResponse)) return false;
        FindByNwIdResponse other = (FindByNwIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.findByNwIdResult==null && other.getFindByNwIdResult()==null) || 
             (this.findByNwIdResult!=null &&
              this.findByNwIdResult.equals(other.getFindByNwIdResult())));
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
        if (getFindByNwIdResult() != null) {
            _hashCode += getFindByNwIdResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FindByNwIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">FindByNwIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("findByNwIdResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "FindByNwIdResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">>FindByNwIdResponse>FindByNwIdResult"));
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
