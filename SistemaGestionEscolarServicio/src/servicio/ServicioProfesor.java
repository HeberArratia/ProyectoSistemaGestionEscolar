package servicio;

import controlador.Academico.StaffAcademico.Profesor;

public class ServicioProfesor {
	
	public String[] buscarProfesor(String rut){
		return Profesor.buscarProfesor(rut);
	}
	
	public String registrarPromedio(String rutEst, int idCurso, String promedio, String rutProfesor){
		return Profesor.registrarPromedio(rutEst, idCurso, promedio, rutProfesor);
	}
	
	public String registrarAsistencia(String rutEst, int idCurso, String asistencia, String rutProfesor){
		return Profesor.registrarAsistencia(rutEst, idCurso, asistencia, rutProfesor);
	}
}
