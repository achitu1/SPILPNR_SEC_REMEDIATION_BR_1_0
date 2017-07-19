/**
 * FindByDisplayNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nwa.adsvmp;

public class FindByDisplayNameResponse  implements java.io.Serializable {
    private com.nwa.adsvmp.FindByDisplayNameResponseFindByDisplayNameResult findByDisplayNameResult;

    public FindByDisplayNameResponse() {
    }

    public FindByDisplayNameResponse(
           com.nwa.adsvmp.FindByDisplayNameResponseFindByDisplayNameResult findByDisplayNameResult) {
           this.findByDisplayNameResult = findByDisplayNameResult;
    }


    /**
     * Gets the findByDisplayNameResult value for this FindByDisplayNameResponse.
     * 
     * @return findByDisplayNameResult
     */
    public com.nwa.adsvmp.FindByDisplayNameResponseFindByDisplayNameResult getFindByDisplayNameResult() {
        return findByDisplayNameResult;
    }


    /**
     * Sets the findByDisplayNameResult value for this FindByDisplayNameResponse.
     * 
     * @param findByDisplayNameResult
     */
    public void setFindByDisplayNameResult(com.nwa.adsvmp.FindByDisplayNameResponseFindByDisplayNameResult findByDisplayNameResult) {
        this.findByDisplayNameResult = findByDisplayNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindByDisplayNameResponse)) return false;
        FindByDisplayNameResponse other = (FindByDisplayNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.findByDisplayNameResult==null && other.getFindByDisplayNameResult()==null) || 
             (this.findByDisplayNameResult!=null &&
              this.findByDisplayNameResult.equals(other.getFindByDisplayNameResult())));
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
        if (getFindByDisplayNameResult() != null) {
            _hashCode += getFindByDisplayNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FindByDisplayNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">FindByDisplayNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("findByDisplayNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "FindByDisplayNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">>FindByDisplayNameResponse>FindByDisplayNameResult"));
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
