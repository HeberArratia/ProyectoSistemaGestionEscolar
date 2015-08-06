/**
 * SueldoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package controlador.Finanza;

public class SueldoServiceLocator extends org.apache.axis.client.Service implements controlador.Finanza.SueldoService {

    public SueldoServiceLocator() {
    }


    public SueldoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SueldoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Sueldo
    private java.lang.String Sueldo_address = "http://localhost:8080/SistemaGestionEscolarFirst/services/Sueldo";

    public java.lang.String getSueldoAddress() {
        return Sueldo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SueldoWSDDServiceName = "Sueldo";

    public java.lang.String getSueldoWSDDServiceName() {
        return SueldoWSDDServiceName;
    }

    public void setSueldoWSDDServiceName(java.lang.String name) {
        SueldoWSDDServiceName = name;
    }

    public controlador.Finanza.Sueldo getSueldo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Sueldo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSueldo(endpoint);
    }

    public controlador.Finanza.Sueldo getSueldo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            controlador.Finanza.SueldoSoapBindingStub _stub = new controlador.Finanza.SueldoSoapBindingStub(portAddress, this);
            _stub.setPortName(getSueldoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSueldoEndpointAddress(java.lang.String address) {
        Sueldo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (controlador.Finanza.Sueldo.class.isAssignableFrom(serviceEndpointInterface)) {
                controlador.Finanza.SueldoSoapBindingStub _stub = new controlador.Finanza.SueldoSoapBindingStub(new java.net.URL(Sueldo_address), this);
                _stub.setPortName(getSueldoWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Sueldo".equals(inputPortName)) {
            return getSueldo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Finanza.controlador", "SueldoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Finanza.controlador", "Sueldo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Sueldo".equals(portName)) {
            setSueldoEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
