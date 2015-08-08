package servicio;

public class ServicioCursoProxy implements servicio.ServicioCurso {
  private String _endpoint = null;
  private servicio.ServicioCurso servicioCurso = null;
  
  public ServicioCursoProxy() {
    _initServicioCursoProxy();
  }
  
  public ServicioCursoProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioCursoProxy();
  }
  
  private void _initServicioCursoProxy() {
    try {
      servicioCurso = (new servicio.ServicioCursoServiceLocator()).getServicioCurso();
      if (servicioCurso != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioCurso)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioCurso)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioCurso != null)
      ((javax.xml.rpc.Stub)servicioCurso)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servicio.ServicioCurso getServicioCurso() {
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso;
  }
  
  public java.lang.String desactivarCurso(int id, java.lang.String rutDirector) throws java.rmi.RemoteException{
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso.desactivarCurso(id, rutDirector);
  }
  
  public java.lang.String incribirEstudiante(int idCurso, java.lang.String rutEstudiante, java.lang.String rutProfesor) throws java.rmi.RemoteException{
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso.incribirEstudiante(idCurso, rutEstudiante, rutProfesor);
  }
  
  public java.lang.String crearCurso(java.lang.String nombreCurso, java.lang.String rutJefeAdm) throws java.rmi.RemoteException{
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso.crearCurso(nombreCurso, rutJefeAdm);
  }
  
  public java.lang.String asignarProfesor(int id, java.lang.String nombreCurso, java.lang.String rutProfe, java.lang.String rutJefeAdm) throws java.rmi.RemoteException{
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso.asignarProfesor(id, nombreCurso, rutProfe, rutJefeAdm);
  }
  
  
}