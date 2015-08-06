package servicio;

public class ServicioPersonaProxy implements servicio.ServicioPersona {
  private String _endpoint = null;
  private servicio.ServicioPersona servicioPersona = null;
  
  public ServicioPersonaProxy() {
    _initServicioPersonaProxy();
  }
  
  public ServicioPersonaProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioPersonaProxy();
  }
  
  private void _initServicioPersonaProxy() {
    try {
      servicioPersona = (new servicio.ServicioPersonaServiceLocator()).getServicioPersona();
      if (servicioPersona != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioPersona)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioPersona)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioPersona != null)
      ((javax.xml.rpc.Stub)servicioPersona)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servicio.ServicioPersona getServicioPersona() {
    if (servicioPersona == null)
      _initServicioPersonaProxy();
    return servicioPersona;
  }
  
  public java.lang.String login(java.lang.String rut, java.lang.String pass) throws java.rmi.RemoteException{
    if (servicioPersona == null)
      _initServicioPersonaProxy();
    return servicioPersona.login(rut, pass);
  }
  
  
}