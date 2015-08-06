package controlador.Finanza;

public class SueldoProxy implements controlador.Finanza.Sueldo {
  private String _endpoint = null;
  private controlador.Finanza.Sueldo sueldo = null;
  
  public SueldoProxy() {
    _initSueldoProxy();
  }
  
  public SueldoProxy(String endpoint) {
    _endpoint = endpoint;
    _initSueldoProxy();
  }
  
  private void _initSueldoProxy() {
    try {
      sueldo = (new controlador.Finanza.SueldoServiceLocator()).getSueldo();
      if (sueldo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sueldo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sueldo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sueldo != null)
      ((javax.xml.rpc.Stub)sueldo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public controlador.Finanza.Sueldo getSueldo() {
    if (sueldo == null)
      _initSueldoProxy();
    return sueldo;
  }
  
  public void actualizarSueldos(orm.Profesor profesor) throws java.rmi.RemoteException{
    if (sueldo == null)
      _initSueldoProxy();
    sueldo.actualizarSueldos(profesor);
  }
  
  public java.lang.String[][] obtenerListSueldoProf(java.lang.String rutProf) throws java.rmi.RemoteException{
    if (sueldo == null)
      _initSueldoProxy();
    return sueldo.obtenerListSueldoProf(rutProf);
  }
  
  public java.lang.String registrarSueldoProf(java.lang.String rutProf, java.lang.String rutAdm, int mes) throws java.rmi.RemoteException{
    if (sueldo == null)
      _initSueldoProxy();
    return sueldo.registrarSueldoProf(rutProf, rutAdm, mes);
  }
  
  
}