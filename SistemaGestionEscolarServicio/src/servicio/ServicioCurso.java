package servicio;

import controlador.Academico.Curso;

public class ServicioCurso {
	
	public String crearCurso(String nombreCurso, String rutJefeAdm){
		return Curso.crearCurso(nombreCurso, rutJefeAdm);
	}
	
	public String desactivarCurso(int id,String rutDirector){
		return Curso.desactivarCurso(id, rutDirector);
	}
	
	public String asignarProfesor(int id, String nombreCurso, String rutProfe, String rutJefeAdm){
		return Curso.asignarProfesor(id, nombreCurso, rutProfe, rutJefeAdm);
	}
	
	public String incribirEstudiante(int idCurso, String rutEstudiante, String rutProfesor){
		return Curso.inscribirEstudiante(idCurso, rutEstudiante, rutProfesor);
	}
	
}

