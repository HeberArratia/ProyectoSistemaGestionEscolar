package controlador.Academico;

import org.orm.PersistentException;

import controlador.Finanza.Sueldo;
import controlador.persona.Persona;
/**
 * 
 * @author heberarratia
 *
 */
public class Curso {

	private String nombreCurso;
	private int estadoCurso;
	private int cupos;
	private static final int ROW_COUNT = 100;
	
	public Curso() {
		super();
	}
	
	public Curso(String nombreCurso) {
		super();
		this.nombreCurso = nombreCurso;
	}
	
	/**
	 * Metodo que permite crear un nuevo curso especificado por paramatro
	 * 
	 * @param nuevoCurso a crear
	 * @param rutJefeAdm quien crea el curso
	 * @return string de confirmacion
	 */
	public static String crearCurso(String nombreCurso, String rutJefeAdm) {
		try {
			
			if (nombreCurso.length()>4 && nombreCurso.length()<=20){
			// Condicion de busqueda de la persona (rut persona)
			String queryPersona= "persona.rut='"+rutJefeAdm+"'";
			// Se almacena en la variable el jefe de administracion con la condicion entregada
			orm.Jefeadministracion lormJefeAdm = orm.JefeadministracionDAO.loadJefeadministracionByQuery(queryPersona, null);
			// Si el rut es valido y el jefe de administracion existe se puede proceder
			if (lormJefeAdm!=null){
				// Se crea un nuevo curso
				orm.Curso lormCurso = orm.CursoDAO.createCurso();
				// Se asigna el nombre del curso
				lormCurso.setNombreCurso(nombreCurso);
				// Se asigna el jefe de administracion quien crea el curso
				lormCurso.setJefeadministracion(lormJefeAdm);
				// Se asigna un estado de curso activo (1)
				lormCurso.setEstadocurso(1);
				// Se asignan 40 cupos
				lormCurso.setCupos(40);
				// Se guarda el curso
				orm.CursoDAO.save(lormCurso);
				// Se retorna un mensaje de confirmacion
				return "Se creó el curso exitosamente";
			}
			return "No existe jefe de administracion";
			} return "Nombre inválido (debe ser mayor a 4 y menor que 21)";
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo que permite desactivar un curso especificado por parametro
	 * 
	 * @param id del curso a desactivar
	 * @param rutDirector quien desactiva el curso
	 * @return string de confirmacion
	 */
	public static String desactivarCurso(int id, String rutDirector) {	
		try {
			// Condicion de busqueda del director (rut persona)
			String queryDirector = "persona.rut='"+rutDirector+"'";
			// Se almacena en la variable el director con la condicion entregada
			orm.Director lormDirector = orm.DirectorDAO.loadDirectorByQuery(queryDirector, null);
			// Si el director existe se puede proceder
			if (lormDirector!=null){
				//Condicion de busqueda del curso (id del curso)
				String queryCurso="id='"+id+"'";
				// Se almacena en la variable el curso con la condicion entregada
				orm.Curso lormCurso=orm.CursoDAO.loadCursoByQuery(queryCurso, null);
				// Si el curso existe se puede proceder
				if(lormCurso!=null){
					// Si el estado del curso se encuentra activo se puede proceder
					if(lormCurso.getEstadocurso()==1){
						// El estado del curso se cambia a desactivado
						lormCurso.setEstadocurso(0);
						// Se guarda el director que desactiva el curso
						lormCurso.setORM_Director(lormDirector);
						// Se guardan los cambios
						orm.CursoDAO.save(lormCurso);
						//Actualizar sueldo del profesor que imparte el curso
						// Condicion de busqueda en Curso_profesor (curso)
						String queryCurso_profesor = "curso='"+lormCurso+"'";
						//Asignamos a la variable la relacion curso profesor con la condicion entregada
						orm.Curso_profesor lormCurso_profesor = orm.Curso_profesorDAO.loadCurso_profesorByQuery(queryCurso_profesor, null);
						// Si la relacion existe se puede proceder
						if (lormCurso_profesor!=null){
							//Se actualizan los sueldos
							Sueldo.actualizarSueldos(lormCurso_profesor.getProfesor());
						}
						// Se retorna un mensaje de confirmacion
						return "Curso desactivado exitosamente";
					}
					return "Curso se encuentra desactivado";
				}
				return "Curso no existente";
			} 
			return "No existe el director";
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	
	/**
	 * Metodo que permite asignarle un profesor existente a un curso existente
	 * 
	 * @param id del curso a cual se le va a asignar un profesor
	 * @param nombreCurso a cual se le va a asignar el profesor
	 * @param rutProfe quien se asigna al curso
	 * @param rutJefeAdm quien asigna el profesor al curso
	 * @return string de confirmacion 
	 */
	public static String asignarProfesor(int id, String nombreCurso,String rutProfe,String rutJefeAdm ) {
		try {
			//Condicion de busqueda del curso (id del curso)
			String queryCurso = "id='" + id + "'";
			//Se almacena en la variable el curso con la condicion entregada
			orm.Curso lormCurso = orm.CursoDAO.loadCursoByQuery(queryCurso,	null);
			// Si el curso existe se puede proceder
			if (lormCurso != null){
				// Si el estado del curso se encuentra activo
				if (lormCurso.getEstadocurso()!=0){
					//Si el nombre del curso es igual al nombre recibido por parametro se puede proceder
					if (lormCurso.getNombreCurso().equals(nombreCurso)){
						// Condicion de busqueda del jefe de administracion (rut persona)
						String queryJefeAd = "persona.rut='" + rutJefeAdm + "'";
						// Se almacena en la variable el jefe de administracion con la condicion entregada
						orm.Jefeadministracion lormJefeadministracion = orm.JefeadministracionDAO.loadJefeadministracionByQuery(queryJefeAd, null);
						// Si el jefe de administracion existe se puede proceder
						if (lormJefeadministracion !=null){
							//Condicion de busqueda del profesor (rut persona)
							String queryProfesor = "persona.rut='" + rutProfe + "'";
							//Guardamos en la variable el profesor con la condicion entregada
							orm.Profesor lormProfesor = orm.ProfesorDAO.loadProfesorByQuery(queryProfesor, null);
							// Si el profesor existe se puede proceder
							if (lormProfesor != null){
								// Condicion de busqueda de curso_profesor (id del curso)
								String queryCur_Prof = "curso.id='" + id + "'";
								// Variable que almacena el curso_profesor con la condicion entregada
								orm.Curso_profesor lormCurso_profesorBuscar = orm.Curso_profesorDAO.loadCurso_profesorByQuery(queryCur_Prof, null);
								// Si el curso_profesor con el id curso indicado no existe (El curso no se le asignen dos profesores)
								if (lormCurso_profesorBuscar==null){
									// Creamos un nuevo curso_profesor
									orm.Curso_profesor lormCurso_profesor = orm.Curso_profesorDAO.createCurso_profesor();
									// Asignamos el curso
									lormCurso_profesor.setCurso(lormCurso);
									// Asignamos el profesor
									lormCurso_profesor.setProfesor(lormProfesor);
									//Guardamos sueldo_profesor
									orm.Curso_profesorDAO.save(lormCurso_profesor);
									// Se actualizan los sueldos del profesor
									Sueldo.actualizarSueldos(lormProfesor);			
									return "Profesor asignado";
								}
								return "El curso ya tiene asignado un profesor";
							}
							return "El profesor no existe";
						}
						return "El jefe de administracion no existe";
					}
					return "El nombre ingresado no corresponde al codigo del curso";
				}
				return "El curso se encuentra desactivado";
			}
			return "No existe el curso";
		}catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
			
	
	/**
	 * Metodo que permite inscribir un estudiante existente en un curso existente
	 * 
	 * @param idCurso al cual se le inscribe el estudiante
	 * @param rutEstudiante el cual se inscribe en el curso
	 * @param rutProfesor quien inscribe al estudiante en el curso
	 * @return string de confirmacion
	 */
	public static String inscribirEstudiante(int idCurso, String rutEstudiante, String rutProfesor) {
		try {
			// Condicion de busqueda del estudiante (rut del estudiante)
			String queryEstudiante = "persona.rut='" + rutEstudiante + "'";
			// Almacenamos en la variable el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Si el estudiante existe se puede proceder
			if (lormEstudiante!= null){
			// Condicion de busqueda del curso (id del curso)
			String queryCurso = "id='" + idCurso + "'";
			// Se almacena en la variable el curso con la condicion entregada
			orm.Curso lormCurso = orm.CursoDAO.loadCursoByQuery(queryCurso,	null);
			// Si el curso existe se puede proceder
			if (lormCurso != null) {
				// Si el curso se encuentra activo se puede proceder
				if(lormCurso.getEstadocurso() == 1){
					// Si el curso tiene cupos para un nuevo estudiante
					if (lormCurso.getCupos() > 0){
						//Condicion de busqueda en estudiante_curso
						String queryEstCurso = "curso.id='" + idCurso+ "' "+ "and estudiante.persona.rut='" + rutEstudiante + "'";
						// Variable que almacena la relacion estudiante_curso con la condicion entregada
						orm.Estudiante_curso lormEstudiante_cursoExiste = orm.Estudiante_cursoDAO.loadEstudiante_cursoByQuery(queryEstCurso, null);
						// Verificar que el estudiante no se encuentre inscrito en el curso
						if (lormEstudiante_cursoExiste==null){
						// Condicion de busqueda del curso_profesor (id curso)
						String queryCurso_profesor = "curso.id='" + lormCurso.getId() + "'";
						// Se almacena en la variable el curso_profesor con la condicion entregada
						orm.Curso_profesor lormCurso_profesor = orm.Curso_profesorDAO.loadCurso_profesorByQuery(queryCurso_profesor, null);
						// Si el profesor que inscribe al estudiante es el mismo al que se le asigno el curso se puede proceder
						if(lormCurso_profesor!=null && lormCurso_profesor.getProfesor().getPersona().getRut().equals(rutProfesor)){
							// Creamos un nuevo estudiante_curso
							orm.Estudiante_curso lormEstudiante_curso = orm.Estudiante_cursoDAO.createEstudiante_curso();
							// Almacenamos el curso
							lormEstudiante_curso.setCurso(lormCurso);
							// Almacenanos el estudiante
							lormEstudiante_curso.setEstudiante(lormEstudiante);
							// Restamos un cupo al curso
							int cupos = lormCurso.getCupos() - 1;	
							lormCurso.setCupos(cupos);
							// Guardamos estudiante_curso
							orm.Estudiante_cursoDAO.save(lormEstudiante_curso);
							
							return "Alumno inscrito";
						} return "Acceso denegado al curso";
						} return "El estudiante ya posee este curso";
					}
					return "No quedan cupos en el curso";
				} 
				return "El curso no se encuentra activo";
			} 
			return "No existe el curso";
		}
		return "No existe estudiante";

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	/**
	 * Metodo que calcula la cantidad de cursos del profesor o estudiante
	 * @param rut del profesor o estudiante
	 * @return int con cantidad de cursos
	 */
	public static int calcularCantCursos(String rut) {
		try {
			// Condicion de busqueda (rut persona)
			String condicion= "persona.rut='"+rut+"'";
			// Se almacena en una variable el profesor con la condicion entregada
			orm.Profesor lormProfesor = orm.ProfesorDAO.loadProfesorByQuery(condicion, null);
			// Se almacena en una variable el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(condicion, null);
			// Si el profesor existe
			if (lormProfesor!=null){
				// Condicion de busqueda (profesor y estado del curso activo)
				String queryCurProf= "profesor='"+lormProfesor+ "'" + " and curso.estadocurso='" + 1 + "'";
				// Arreglo que almacena todas las relaciones curso_profesor que existen
				orm.Curso_profesor[] ormCurso_profesors = orm.Curso_profesorDAO.listCurso_profesorByQuery(queryCurProf, null);
				// Se retorna el largo del arreglo
				return ormCurso_profesors.length;
			// Si el estudiante existe
			}else if(lormEstudiante!=null) {
				// Condicion de busqueda (estudiante y estado del curso activo)
				String condicionCurEst= "estudiante='"+lormEstudiante+ "'" + " and curso.estadocurso='" + 1 + "'";
				// Arreglo que almacena todas las relaciones estudiante_cruso que existen
				orm.Estudiante_curso[] ormEstudiante_cursos = orm.Estudiante_cursoDAO.listEstudiante_cursoByQuery(condicionCurEst, null);
				// Se retorna el largo del arreglo
				return ormEstudiante_cursos.length;			
			}else{
				// Si no existe profesor o estudiante se retorna un cero
				return 0;
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	
	public static boolean soloNumeros(String numero){
		return numero.matches("\\d*");
	}
	
	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombre(String nombre) {
		this.nombreCurso = nombre;
	}
	
	public void buscarCurso() {
		// TODO - implement Curso.buscarCurso
		throw new UnsupportedOperationException();
	}

}