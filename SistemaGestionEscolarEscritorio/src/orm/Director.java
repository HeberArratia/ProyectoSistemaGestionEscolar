/**
 * Director.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package orm;

public class Director  implements java.io.Serializable {
    private int ORMID;

    private int id;

    private orm.Persona persona;

    public Director() {
    }

    public Director(
           int ORMID,
           int id,
           orm.Persona persona) {
           this.ORMID = ORMID;
           this.id = id;
           this.persona = persona;
    }


    /**
     * Gets the ORMID value for this Director.
     * 
     * @return ORMID
     */
    public int getORMID() {
        return ORMID;
    }


    /**
     * Sets the ORMID value for this Director.
     * 
     * @param ORMID
     */
    public void setORMID(int ORMID) {
        this.ORMID = ORMID;
    }


    /**
     * Gets the id value for this Director.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Director.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the persona value for this Director.
     * 
     * @return persona
     */
    public orm.Persona getPersona() {
        return persona;
    }


    /**
     * Sets the persona value for this Director.
     * 
     * @param persona
     */
    public void setPersona(orm.Persona persona) {
        this.persona = persona;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Director)) return false;
        Director other = (Director) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ORMID == other.getORMID() &&
            this.id == other.getId() &&
            ((this.persona==null && other.getPersona()==null) || 
             (this.persona!=null &&
              this.persona.equals(other.getPersona())));
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
        _hashCode += getORMID();
        _hashCode += getId();
        if (getPersona() != null) {
            _hashCode += getPersona().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Director.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://orm", "Director"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ORMID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "ORMID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("persona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "persona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Persona"));
        elemField.setNillable(true);
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
