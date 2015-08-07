package servicio;

public class ServicioReporteProxy implements servicio.ServicioReporte {
  private String _endpoint = null;
  private servicio.ServicioReporte servicioReporte = null;
  
  public ServicioReporteProxy() {
    _initServicioReporteProxy();
  }
  
  public ServicioReporteProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioReporteProxy();
  }
  
  private void _initServicioReporteProxy() {
    try {
      servicioReporte = (new servicio.ServicioReporteServiceLocator()).getServicioReporte();
      if (servicioReporte != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioReporte)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioReporte)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioReporte != null)
      ((javax.xml.rpc.Stub)servicioReporte)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servicio.ServicioReporte getServicioReporte() {
    if (servicioReporte == null)
      _initServicioReporteProxy();
    return servicioReporte;
  }
  
  public java.lang.String obtenerBalanceIngGasto() throws java.rmi.RemoteException{
    if (servicioReporte == null)
      _initServicioReporteProxy();
    return servicioReporte.obtenerBalanceIngGasto();
  }
  
  
}