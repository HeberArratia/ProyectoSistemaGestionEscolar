package servicio;

import controlador.Academico.StaffAcademico.Profesor;

public class ServicioProfesor {
	
	public String[] buscarProfesor(String rut){
		return Profesor.buscarProfesor(rut);
	}
	
	public String registrarPromedio(String rutEst, int idCurso, double promedio, String rutProfesor){
		return Profesor.registrarPromedio(rutEst, idCurso, promedio, rutProfesor);
	}
	
	public String registrarAsistencia(String rutEst, int idCurso, double asistencia, String rutProfesor){
		return Profesor.registrarAsistencia(rutEst, idCurso, asistencia, rutProfesor);
	}
}
