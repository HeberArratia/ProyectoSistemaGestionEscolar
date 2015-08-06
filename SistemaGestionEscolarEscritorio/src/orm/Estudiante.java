/**
 * Estudiante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package orm;

public class Estudiante  implements java.io.Serializable {
    private int ORMID;

    private orm.Apoderado ORM_Apoderado;

    private orm.Apoderado apoderado;

    private int id;

    private orm.Matricula matricula;

    private orm.Persona persona;

    public Estudiante() {
    }

    public Estudiante(
           int ORMID,
           orm.Apoderado ORM_Apoderado,
           orm.Apoderado apoderado,
           int id,
           orm.Matricula matricula,
           orm.Persona persona) {
           this.ORMID = ORMID;
           this.ORM_Apoderado = ORM_Apoderado;
           this.apoderado = apoderado;
           this.id = id;
           this.matricula = matricula;
           this.persona = persona;
    }


    /**
     * Gets the ORMID value for this Estudiante.
     * 
     * @return ORMID
     */
    public int getORMID() {
        return ORMID;
    }


    /**
     * Sets the ORMID value for this Estudiante.
     * 
     * @param ORMID
     */
    public void setORMID(int ORMID) {
        this.ORMID = ORMID;
    }


    /**
     * Gets the ORM_Apoderado value for this Estudiante.
     * 
     * @return ORM_Apoderado
     */
    public orm.Apoderado getORM_Apoderado() {
        return ORM_Apoderado;
    }


    /**
     * Sets the ORM_Apoderado value for this Estudiante.
     * 
     * @param ORM_Apoderado
     */
    public void setORM_Apoderado(orm.Apoderado ORM_Apoderado) {
        this.ORM_Apoderado = ORM_Apoderado;
    }


    /**
     * Gets the apoderado value for this Estudiante.
     * 
     * @return apoderado
     */
    public orm.Apoderado getApoderado() {
        return apoderado;
    }


    /**
     * Sets the apoderado value for this Estudiante.
     * 
     * @param apoderado
     */
    public void setApoderado(orm.Apoderado apoderado) {
        this.apoderado = apoderado;
    }


    /**
     * Gets the id value for this Estudiante.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Estudiante.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the matricula value for this Estudiante.
     * 
     * @return matricula
     */
    public orm.Matricula getMatricula() {
        return matricula;
    }


    /**
     * Sets the matricula value for this Estudiante.
     * 
     * @param matricula
     */
    public void setMatricula(orm.Matricula matricula) {
        this.matricula = matricula;
    }


    /**
     * Gets the persona value for this Estudiante.
     * 
     * @return persona
     */
    public orm.Persona getPersona() {
        return persona;
    }


    /**
     * Sets the persona value for this Estudiante.
     * 
     * @param persona
     */
    public void setPersona(orm.Persona persona) {
        this.persona = persona;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Estudiante)) return false;
        Estudiante other = (Estudiante) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ORMID == other.getORMID() &&
            ((this.ORM_Apoderado==null && other.getORM_Apoderado()==null) || 
             (this.ORM_Apoderado!=null &&
              this.ORM_Apoderado.equals(other.getORM_Apoderado()))) &&
            ((this.apoderado==null && other.getApoderado()==null) || 
             (this.apoderado!=null &&
              this.apoderado.equals(other.getApoderado()))) &&
            this.id == other.getId() &&
            ((this.matricula==null && other.getMatricula()==null) || 
             (this.matricula!=null &&
              this.matricula.equals(other.getMatricula()))) &&
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
        if (getORM_Apoderado() != null) {
            _hashCode += getORM_Apoderado().hashCode();
        }
        if (getApoderado() != null) {
            _hashCode += getApoderado().hashCode();
        }
        _hashCode += getId();
        if (getMatricula() != null) {
            _hashCode += getMatricula().hashCode();
        }
        if (getPersona() != null) {
            _hashCode += getPersona().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Estudiante.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://orm", "Estudiante"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ORMID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "ORMID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ORM_Apoderado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "ORM_Apoderado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Apoderado"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apoderado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "apoderado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Apoderado"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matricula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "matricula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Matricula"));
        elemField.setNillable(true);
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
