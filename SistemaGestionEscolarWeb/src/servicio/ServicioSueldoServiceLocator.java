/**
 * ServicioSueldoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicio;

public class ServicioSueldoServiceLocator extends org.apache.axis.client.Service implements servicio.ServicioSueldoService {

    public ServicioSueldoServiceLocator() {
    }


    public ServicioSueldoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioSueldoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioSueldo
    private java.lang.String ServicioSueldo_address = "http://localhost:8080/SistemaGestionEscolarServicio/services/ServicioSueldo";

    public java.lang.String getServicioSueldoAddress() {
        return ServicioSueldo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioSueldoWSDDServiceName = "ServicioSueldo";

    public java.lang.String getServicioSueldoWSDDServiceName() {
        return ServicioSueldoWSDDServiceName;
    }

    public void setServicioSueldoWSDDServiceName(java.lang.String name) {
        ServicioSueldoWSDDServiceName = name;
    }

    public servicio.ServicioSueldo getServicioSueldo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioSueldo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioSueldo(endpoint);
    }

    public servicio.ServicioSueldo getServicioSueldo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            servicio.ServicioSueldoSoapBindingStub _stub = new servicio.ServicioSueldoSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioSueldoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioSueldoEndpointAddress(java.lang.String address) {
        ServicioSueldo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (servicio.ServicioSueldo.class.isAssignableFrom(serviceEndpointInterface)) {
                servicio.ServicioSueldoSoapBindingStub _stub = new servicio.ServicioSueldoSoapBindingStub(new java.net.URL(ServicioSueldo_address), this);
                _stub.setPortName(getServicioSueldoWSDDServiceName());
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
        if ("ServicioSueldo".equals(inputPortName)) {
            return getServicioSueldo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicio", "ServicioSueldoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicio", "ServicioSueldo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioSueldo".equals(portName)) {
            setServicioSueldoEndpointAddress(address);
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
