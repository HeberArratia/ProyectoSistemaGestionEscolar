/**
 * ServicioEstudiante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicio;

public interface ServicioEstudiante extends java.rmi.Remote {
    public java.lang.String obtenerSituacionEstudiante(java.lang.String rutEstudiante) throws java.rmi.RemoteException;
    public java.lang.String[] buscarEstudiante(java.lang.String rut) throws java.rmi.RemoteException;
}
