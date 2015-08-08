/**
 * ServicioProfesor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicio;

public interface ServicioProfesor extends java.rmi.Remote {
    public java.lang.String[] buscarProfesor(java.lang.String rut) throws java.rmi.RemoteException;
    public java.lang.String registrarPromedio(java.lang.String rutEst, int idCurso, java.lang.String promedio, java.lang.String rutProfesor) throws java.rmi.RemoteException;
    public java.lang.String registrarAsistencia(java.lang.String rutEst, int idCurso, java.lang.String asistencia, java.lang.String rutProfesor) throws java.rmi.RemoteException;
}
