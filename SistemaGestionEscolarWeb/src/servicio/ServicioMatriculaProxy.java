package servicio;

public class ServicioMatriculaProxy implements servicio.ServicioMatricula {
  private String _endpoint = null;
  private servicio.ServicioMatricula servicioMatricula = null;
  
  public ServicioMatriculaProxy() {
    _initServicioMatriculaProxy();
  }
  
  public ServicioMatriculaProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioMatriculaProxy();
  }
  
  private void _initServicioMatriculaProxy() {
    try {
      servicioMatricula = (new servicio.ServicioMatriculaServiceLocator()).getServicioMatricula();
      if (servicioMatricula != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioMatricula)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioMatricula)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioMatricula != null)
      ((javax.xml.rpc.Stub)servicioMatricula)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servicio.ServicioMatricula getServicioMatricula() {
    if (servicioMatricula == null)
      _initServicioMatriculaProxy();
    return servicioMatricula;
  }
  
  public java.lang.String pagarMatricula(java.lang.String rutEstudiante, java.lang.String rutSecretaria) throws java.rmi.RemoteException{
    if (servicioMatricula == null)
      _initServicioMatriculaProxy();
    return servicioMatricula.pagarMatricula(rutEstudiante, rutSecretaria);
  }
  
  public java.lang.String obtenerMorososMatricula() throws java.rmi.RemoteException{
    if (servicioMatricula == null)
      _initServicioMatriculaProxy();
    return servicioMatricula.obtenerMorososMatricula();
  }
  
  
}