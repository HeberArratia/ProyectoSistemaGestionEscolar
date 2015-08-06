/**
 * Matricula.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package orm;

public class Matricula  implements java.io.Serializable {
    private int ORMID;

    private orm.Secretaria ORM_Secretaria;

    private java.lang.Integer estadoMatricula;

    private orm.Estudiante estudiante;

    private int id;

    private java.lang.Integer monto;

    private orm.Secretaria secretaria;

    public Matricula() {
    }

    public Matricula(
           int ORMID,
           orm.Secretaria ORM_Secretaria,
           java.lang.Integer estadoMatricula,
           orm.Estudiante estudiante,
           int id,
           java.lang.Integer monto,
           orm.Secretaria secretaria) {
           this.ORMID = ORMID;
           this.ORM_Secretaria = ORM_Secretaria;
           this.estadoMatricula = estadoMatricula;
           this.estudiante = estudiante;
           this.id = id;
           this.monto = monto;
           this.secretaria = secretaria;
    }


    /**
     * Gets the ORMID value for this Matricula.
     * 
     * @return ORMID
     */
    public int getORMID() {
        return ORMID;
    }


    /**
     * Sets the ORMID value for this Matricula.
     * 
     * @param ORMID
     */
    public void setORMID(int ORMID) {
        this.ORMID = ORMID;
    }


    /**
     * Gets the ORM_Secretaria value for this Matricula.
     * 
     * @return ORM_Secretaria
     */
    public orm.Secretaria getORM_Secretaria() {
        return ORM_Secretaria;
    }


    /**
     * Sets the ORM_Secretaria value for this Matricula.
     * 
     * @param ORM_Secretaria
     */
    public void setORM_Secretaria(orm.Secretaria ORM_Secretaria) {
        this.ORM_Secretaria = ORM_Secretaria;
    }


    /**
     * Gets the estadoMatricula value for this Matricula.
     * 
     * @return estadoMatricula
     */
    public java.lang.Integer getEstadoMatricula() {
        return estadoMatricula;
    }


    /**
     * Sets the estadoMatricula value for this Matricula.
     * 
     * @param estadoMatricula
     */
    public void setEstadoMatricula(java.lang.Integer estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }


    /**
     * Gets the estudiante value for this Matricula.
     * 
     * @return estudiante
     */
    public orm.Estudiante getEstudiante() {
        return estudiante;
    }


    /**
     * Sets the estudiante value for this Matricula.
     * 
     * @param estudiante
     */
    public void setEstudiante(orm.Estudiante estudiante) {
        this.estudiante = estudiante;
    }


    /**
     * Gets the id value for this Matricula.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Matricula.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the monto value for this Matricula.
     * 
     * @return monto
     */
    public java.lang.Integer getMonto() {
        return monto;
    }


    /**
     * Sets the monto value for this Matricula.
     * 
     * @param monto
     */
    public void setMonto(java.lang.Integer monto) {
        this.monto = monto;
    }


    /**
     * Gets the secretaria value for this Matricula.
     * 
     * @return secretaria
     */
    public orm.Secretaria getSecretaria() {
        return secretaria;
    }


    /**
     * Sets the secretaria value for this Matricula.
     * 
     * @param secretaria
     */
    public void setSecretaria(orm.Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Matricula)) return false;
        Matricula other = (Matricula) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ORMID == other.getORMID() &&
            ((this.ORM_Secretaria==null && other.getORM_Secretaria()==null) || 
             (this.ORM_Secretaria!=null &&
              this.ORM_Secretaria.equals(other.getORM_Secretaria()))) &&
            ((this.estadoMatricula==null && other.getEstadoMatricula()==null) || 
             (this.estadoMatricula!=null &&
              this.estadoMatricula.equals(other.getEstadoMatricula()))) &&
            ((this.estudiante==null && other.getEstudiante()==null) || 
             (this.estudiante!=null &&
              this.estudiante.equals(other.getEstudiante()))) &&
            this.id == other.getId() &&
            ((this.monto==null && other.getMonto()==null) || 
             (this.monto!=null &&
              this.monto.equals(other.getMonto()))) &&
            ((this.secretaria==null && other.getSecretaria()==null) || 
             (this.secretaria!=null &&
              this.secretaria.equals(other.getSecretaria())));
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
        if (getORM_Secretaria() != null) {
            _hashCode += getORM_Secretaria().hashCode();
        }
        if (getEstadoMatricula() != null) {
            _hashCode += getEstadoMatricula().hashCode();
        }
        if (getEstudiante() != null) {
            _hashCode += getEstudiante().hashCode();
        }
        _hashCode += getId();
        if (getMonto() != null) {
            _hashCode += getMonto().hashCode();
        }
        if (getSecretaria() != null) {
            _hashCode += getSecretaria().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Matricula.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://orm", "Matricula"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ORMID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "ORMID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ORM_Secretaria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "ORM_Secretaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Secretaria"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoMatricula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "estadoMatricula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estudiante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "estudiante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Estudiante"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "monto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secretaria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "secretaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Secretaria"));
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
