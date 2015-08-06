/**
 * Persona.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package orm;

public class Persona  implements java.io.Serializable {
    private int ORMID;

    private java.lang.String apellido;

    private orm.Apoderado apoderado;

    private orm.Director director;

    private orm.Estudiante estudiante;

    private int id;

    private orm.Jefeadministracion jefeadministracion;

    private java.lang.String nombre;

    private java.lang.String pass;

    private orm.Profesor profesor;

    private java.lang.String rut;

    private orm.Secretaria secretaria;

    public Persona() {
    }

    public Persona(
           int ORMID,
           java.lang.String apellido,
           orm.Apoderado apoderado,
           orm.Director director,
           orm.Estudiante estudiante,
           int id,
           orm.Jefeadministracion jefeadministracion,
           java.lang.String nombre,
           java.lang.String pass,
           orm.Profesor profesor,
           java.lang.String rut,
           orm.Secretaria secretaria) {
           this.ORMID = ORMID;
           this.apellido = apellido;
           this.apoderado = apoderado;
           this.director = director;
           this.estudiante = estudiante;
           this.id = id;
           this.jefeadministracion = jefeadministracion;
           this.nombre = nombre;
           this.pass = pass;
           this.profesor = profesor;
           this.rut = rut;
           this.secretaria = secretaria;
    }


    /**
     * Gets the ORMID value for this Persona.
     * 
     * @return ORMID
     */
    public int getORMID() {
        return ORMID;
    }


    /**
     * Sets the ORMID value for this Persona.
     * 
     * @param ORMID
     */
    public void setORMID(int ORMID) {
        this.ORMID = ORMID;
    }


    /**
     * Gets the apellido value for this Persona.
     * 
     * @return apellido
     */
    public java.lang.String getApellido() {
        return apellido;
    }


    /**
     * Sets the apellido value for this Persona.
     * 
     * @param apellido
     */
    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }


    /**
     * Gets the apoderado value for this Persona.
     * 
     * @return apoderado
     */
    public orm.Apoderado getApoderado() {
        return apoderado;
    }


    /**
     * Sets the apoderado value for this Persona.
     * 
     * @param apoderado
     */
    public void setApoderado(orm.Apoderado apoderado) {
        this.apoderado = apoderado;
    }


    /**
     * Gets the director value for this Persona.
     * 
     * @return director
     */
    public orm.Director getDirector() {
        return director;
    }


    /**
     * Sets the director value for this Persona.
     * 
     * @param director
     */
    public void setDirector(orm.Director director) {
        this.director = director;
    }


    /**
     * Gets the estudiante value for this Persona.
     * 
     * @return estudiante
     */
    public orm.Estudiante getEstudiante() {
        return estudiante;
    }


    /**
     * Sets the estudiante value for this Persona.
     * 
     * @param estudiante
     */
    public void setEstudiante(orm.Estudiante estudiante) {
        this.estudiante = estudiante;
    }


    /**
     * Gets the id value for this Persona.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Persona.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the jefeadministracion value for this Persona.
     * 
     * @return jefeadministracion
     */
    public orm.Jefeadministracion getJefeadministracion() {
        return jefeadministracion;
    }


    /**
     * Sets the jefeadministracion value for this Persona.
     * 
     * @param jefeadministracion
     */
    public void setJefeadministracion(orm.Jefeadministracion jefeadministracion) {
        this.jefeadministracion = jefeadministracion;
    }


    /**
     * Gets the nombre value for this Persona.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Persona.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the pass value for this Persona.
     * 
     * @return pass
     */
    public java.lang.String getPass() {
        return pass;
    }


    /**
     * Sets the pass value for this Persona.
     * 
     * @param pass
     */
    public void setPass(java.lang.String pass) {
        this.pass = pass;
    }


    /**
     * Gets the profesor value for this Persona.
     * 
     * @return profesor
     */
    public orm.Profesor getProfesor() {
        return profesor;
    }


    /**
     * Sets the profesor value for this Persona.
     * 
     * @param profesor
     */
    public void setProfesor(orm.Profesor profesor) {
        this.profesor = profesor;
    }


    /**
     * Gets the rut value for this Persona.
     * 
     * @return rut
     */
    public java.lang.String getRut() {
        return rut;
    }


    /**
     * Sets the rut value for this Persona.
     * 
     * @param rut
     */
    public void setRut(java.lang.String rut) {
        this.rut = rut;
    }


    /**
     * Gets the secretaria value for this Persona.
     * 
     * @return secretaria
     */
    public orm.Secretaria getSecretaria() {
        return secretaria;
    }


    /**
     * Sets the secretaria value for this Persona.
     * 
     * @param secretaria
     */
    public void setSecretaria(orm.Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Persona)) return false;
        Persona other = (Persona) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ORMID == other.getORMID() &&
            ((this.apellido==null && other.getApellido()==null) || 
             (this.apellido!=null &&
              this.apellido.equals(other.getApellido()))) &&
            ((this.apoderado==null && other.getApoderado()==null) || 
             (this.apoderado!=null &&
              this.apoderado.equals(other.getApoderado()))) &&
            ((this.director==null && other.getDirector()==null) || 
             (this.director!=null &&
              this.director.equals(other.getDirector()))) &&
            ((this.estudiante==null && other.getEstudiante()==null) || 
             (this.estudiante!=null &&
              this.estudiante.equals(other.getEstudiante()))) &&
            this.id == other.getId() &&
            ((this.jefeadministracion==null && other.getJefeadministracion()==null) || 
             (this.jefeadministracion!=null &&
              this.jefeadministracion.equals(other.getJefeadministracion()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.pass==null && other.getPass()==null) || 
             (this.pass!=null &&
              this.pass.equals(other.getPass()))) &&
            ((this.profesor==null && other.getProfesor()==null) || 
             (this.profesor!=null &&
              this.profesor.equals(other.getProfesor()))) &&
            ((this.rut==null && other.getRut()==null) || 
             (this.rut!=null &&
              this.rut.equals(other.getRut()))) &&
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
        if (getApellido() != null) {
            _hashCode += getApellido().hashCode();
        }
        if (getApoderado() != null) {
            _hashCode += getApoderado().hashCode();
        }
        if (getDirector() != null) {
            _hashCode += getDirector().hashCode();
        }
        if (getEstudiante() != null) {
            _hashCode += getEstudiante().hashCode();
        }
        _hashCode += getId();
        if (getJefeadministracion() != null) {
            _hashCode += getJefeadministracion().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getPass() != null) {
            _hashCode += getPass().hashCode();
        }
        if (getProfesor() != null) {
            _hashCode += getProfesor().hashCode();
        }
        if (getRut() != null) {
            _hashCode += getRut().hashCode();
        }
        if (getSecretaria() != null) {
            _hashCode += getSecretaria().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Persona.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://orm", "Persona"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ORMID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "ORMID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "apellido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apoderado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "apoderado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Apoderado"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("director");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "director"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Director"));
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
        elemField.setFieldName("jefeadministracion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "jefeadministracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Jefeadministracion"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pass");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "pass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profesor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "profesor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://orm", "Profesor"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://orm", "rut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
