package servicio;

import controlador.Academico.StaffAcademico.Estudiante;

public class ServicioEstudiante {
	
	public String[] buscarEstudiante(String rut){
		return Estudiante.buscarEstudiate(rut);
	}
	
	public String obtenerSituacionEstudiante(String rutEstudiante){
		return Estudiante.obtenerSituacionEstudiante(rutEstudiante);
	}
}
