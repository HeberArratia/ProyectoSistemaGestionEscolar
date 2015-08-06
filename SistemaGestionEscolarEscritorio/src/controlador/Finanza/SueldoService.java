/**
 * SueldoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package controlador.Finanza;

public interface SueldoService extends javax.xml.rpc.Service {
    public java.lang.String getSueldoAddress();

    public controlador.Finanza.Sueldo getSueldo() throws javax.xml.rpc.ServiceException;

    public controlador.Finanza.Sueldo getSueldo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
