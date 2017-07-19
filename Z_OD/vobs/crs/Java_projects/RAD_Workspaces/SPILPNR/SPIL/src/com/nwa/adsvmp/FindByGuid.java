/**
 * FindByGuid.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nwa.adsvmp;

public class FindByGuid  implements java.io.Serializable {
    private java.lang.String objectGUID;

    private java.lang.String ADEnv;

    public FindByGuid() {
    }

    public FindByGuid(
           java.lang.String objectGUID,
           java.lang.String ADEnv) {
           this.objectGUID = objectGUID;
           this.ADEnv = ADEnv;
    }


    /**
     * Gets the objectGUID value for this FindByGuid.
     * 
     * @return objectGUID
     */
    public java.lang.String getObjectGUID() {
        return objectGUID;
    }


    /**
     * Sets the objectGUID value for this FindByGuid.
     * 
     * @param objectGUID
     */
    public void setObjectGUID(java.lang.String objectGUID) {
        this.objectGUID = objectGUID;
    }


    /**
     * Gets the ADEnv value for this FindByGuid.
     * 
     * @return ADEnv
     */
    public java.lang.String getADEnv() {
        return ADEnv;
    }


    /**
     * Sets the ADEnv value for this FindByGuid.
     * 
     * @param ADEnv
     */
    public void setADEnv(java.lang.String ADEnv) {
        this.ADEnv = ADEnv;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindByGuid)) return false;
        FindByGuid other = (FindByGuid) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objectGUID==null && other.getObjectGUID()==null) || 
             (this.objectGUID!=null &&
              this.objectGUID.equals(other.getObjectGUID()))) &&
            ((this.ADEnv==null && other.getADEnv()==null) || 
             (this.ADEnv!=null &&
              this.ADEnv.equals(other.getADEnv())));
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
        if (getObjectGUID() != null) {
            _hashCode += getObjectGUID().hashCode();
        }
        if (getADEnv() != null) {
            _hashCode += getADEnv().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FindByGuid.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">FindByGuid"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectGUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "objectGUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ADEnv");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "ADEnv"));
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
