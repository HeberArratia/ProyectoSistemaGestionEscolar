/**
 * ServicioMensualidad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicio;

public interface ServicioMensualidad extends java.rmi.Remote {
    public java.lang.String obtenerMorososMensualidad(int mes) throws java.rmi.RemoteException;
    public java.lang.String registrarPagoMensualidad(java.lang.String rutSc, java.lang.String rutEs, int mes) throws java.rmi.RemoteException;
}
