/**
 * GetGroupMembers.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nwa.adsvmp;

public class GetGroupMembers  implements java.io.Serializable {
    private java.lang.String groupName;

    private java.lang.String filter;

    private java.lang.String nestedGroups;

    private java.lang.String ADEnv;

    public GetGroupMembers() {
    }

    public GetGroupMembers(
           java.lang.String groupName,
           java.lang.String filter,
           java.lang.String nestedGroups,
           java.lang.String ADEnv) {
           this.groupName = groupName;
           this.filter = filter;
           this.nestedGroups = nestedGroups;
           this.ADEnv = ADEnv;
    }


    /**
     * Gets the groupName value for this GetGroupMembers.
     * 
     * @return groupName
     */
    public java.lang.String getGroupName() {
        return groupName;
    }


    /**
     * Sets the groupName value for this GetGroupMembers.
     * 
     * @param groupName
     */
    public void setGroupName(java.lang.String groupName) {
        this.groupName = groupName;
    }


    /**
     * Gets the filter value for this GetGroupMembers.
     * 
     * @return filter
     */
    public java.lang.String getFilter() {
        return filter;
    }


    /**
     * Sets the filter value for this GetGroupMembers.
     * 
     * @param filter
     */
    public void setFilter(java.lang.String filter) {
        this.filter = filter;
    }


    /**
     * Gets the nestedGroups value for this GetGroupMembers.
     * 
     * @return nestedGroups
     */
    public java.lang.String getNestedGroups() {
        return nestedGroups;
    }


    /**
     * Sets the nestedGroups value for this GetGroupMembers.
     * 
     * @param nestedGroups
     */
    public void setNestedGroups(java.lang.String nestedGroups) {
        this.nestedGroups = nestedGroups;
    }


    /**
     * Gets the ADEnv value for this GetGroupMembers.
     * 
     * @return ADEnv
     */
    public java.lang.String getADEnv() {
        return ADEnv;
    }


    /**
     * Sets the ADEnv value for this GetGroupMembers.
     * 
     * @param ADEnv
     */
    public void setADEnv(java.lang.String ADEnv) {
        this.ADEnv = ADEnv;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGroupMembers)) return false;
        GetGroupMembers other = (GetGroupMembers) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.groupName==null && other.getGroupName()==null) || 
             (this.groupName!=null &&
              this.groupName.equals(other.getGroupName()))) &&
            ((this.filter==null && other.getFilter()==null) || 
             (this.filter!=null &&
              this.filter.equals(other.getFilter()))) &&
            ((this.nestedGroups==null && other.getNestedGroups()==null) || 
             (this.nestedGroups!=null &&
              this.nestedGroups.equals(other.getNestedGroups()))) &&
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
        if (getGroupName() != null) {
            _hashCode += getGroupName().hashCode();
        }
        if (getFilter() != null) {
            _hashCode += getFilter().hashCode();
        }
        if (getNestedGroups() != null) {
            _hashCode += getNestedGroups().hashCode();
        }
        if (getADEnv() != null) {
            _hashCode += getADEnv().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetGroupMembers.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", ">GetGroupMembers"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "GroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "Filter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nestedGroups");
        elemField.setXmlName(new javax.xml.namespace.QName("http://adsvmp.nwa.com/", "NestedGroups"));
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
