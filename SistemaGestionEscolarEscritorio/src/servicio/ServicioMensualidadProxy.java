package servicio;

public class ServicioMensualidadProxy implements servicio.ServicioMensualidad {
  private String _endpoint = null;
  private servicio.ServicioMensualidad servicioMensualidad = null;
  
  public ServicioMensualidadProxy() {
    _initServicioMensualidadProxy();
  }
  
  public ServicioMensualidadProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioMensualidadProxy();
  }
  
  private void _initServicioMensualidadProxy() {
    try {
      servicioMensualidad = (new servicio.ServicioMensualidadServiceLocator()).getServicioMensualidad();
      if (servicioMensualidad != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioMensualidad)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioMensualidad)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioMensualidad != null)
      ((javax.xml.rpc.Stub)servicioMensualidad)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servicio.ServicioMensualidad getServicioMensualidad() {
    if (servicioMensualidad == null)
      _initServicioMensualidadProxy();
    return servicioMensualidad;
  }
  
  public java.lang.String obtenerMorososMensualidad(int mes) throws java.rmi.RemoteException{
    if (servicioMensualidad == null)
      _initServicioMensualidadProxy();
    return servicioMensualidad.obtenerMorososMensualidad(mes);
  }
  
  public java.lang.String registrarPagoMensualidad(java.lang.String rutSc, java.lang.String rutEs, int mes) throws java.rmi.RemoteException{
    if (servicioMensualidad == null)
      _initServicioMensualidadProxy();
    return servicioMensualidad.registrarPagoMensualidad(rutSc, rutEs, mes);
  }
  
  
}