/**
 * ServicioPersonaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicio;

public class ServicioPersonaServiceLocator extends org.apache.axis.client.Service implements servicio.ServicioPersonaService {

    public ServicioPersonaServiceLocator() {
    }


    public ServicioPersonaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioPersonaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioPersona
    private java.lang.String ServicioPersona_address = "http://localhost:8080/SistemaGestionEscolarServicio/services/ServicioPersona";

    public java.lang.String getServicioPersonaAddress() {
        return ServicioPersona_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioPersonaWSDDServiceName = "ServicioPersona";

    public java.lang.String getServicioPersonaWSDDServiceName() {
        return ServicioPersonaWSDDServiceName;
    }

    public void setServicioPersonaWSDDServiceName(java.lang.String name) {
        ServicioPersonaWSDDServiceName = name;
    }

    public servicio.ServicioPersona getServicioPersona() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioPersona_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioPersona(endpoint);
    }

    public servicio.ServicioPersona getServicioPersona(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            servicio.ServicioPersonaSoapBindingStub _stub = new servicio.ServicioPersonaSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioPersonaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioPersonaEndpointAddress(java.lang.String address) {
        ServicioPersona_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (servicio.ServicioPersona.class.isAssignableFrom(serviceEndpointInterface)) {
                servicio.ServicioPersonaSoapBindingStub _stub = new servicio.ServicioPersonaSoapBindingStub(new java.net.URL(ServicioPersona_address), this);
                _stub.setPortName(getServicioPersonaWSDDServiceName());
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
        if ("ServicioPersona".equals(inputPortName)) {
            return getServicioPersona();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicio", "ServicioPersonaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicio", "ServicioPersona"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioPersona".equals(portName)) {
            setServicioPersonaEndpointAddress(address);
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
