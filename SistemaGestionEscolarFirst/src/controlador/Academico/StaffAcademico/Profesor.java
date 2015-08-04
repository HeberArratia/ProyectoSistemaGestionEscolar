package controlador.Academico.StaffAcademico;

import org.orm.PersistentException;

import controlador.Academico.Curso;
import controlador.Persona.*;

/**
 * 
 * @author heberarratia
 *
 */
public class Profesor extends Persona {

	public Profesor(String nombre, String apellido, String rut) {
		super(nombre, apellido, rut);
		// TODO Auto-generated constructor stub
	}
	
	public Profesor(String nombre, String apellido, String rut, String pass){
		super(nombre, apellido, rut, pass);
	}


	/**
	 * Metodo que permite agregar un nuevo profesor
	 * @param nuevaPer
	 * @return string de confirmacion
	 */
	public static String agregarNuevoProfesor(Persona nuevaPer) {
		try {
			// Si los atributos de la nueva persona son validos
			if (nuevaPer.validarAtributos()) {
			// Se establece una condicion de busqueda
			String queryPersona = "rut='" + nuevaPer.getRut() + "'";
		    // Se asigna a la variable la persona con la condicion establecida
			orm.Persona lormPersonaBuscar = orm.PersonaDAO.loadPersonaByQuery(queryPersona, null);
			// Si la persona no existe se puede proceder
			if (lormPersonaBuscar == null) {
				// se crea una persona y se asignan sus atributos correspondientes
				orm.Persona lormPersona = orm.PersonaDAO.createPersona();
				lormPersona.setNombre(nuevaPer.getNombre());
				lormPersona.setApellido(nuevaPer.getApellido());
				lormPersona.setRut(nuevaPer.getRut());
				lormPersona.setPass(nuevaPer.getPass());
				// Guardamos la nueva persona
				orm.PersonaDAO.save(lormPersona);
				//Una vez guardada la persona se procede a crear un nuevo profesor 
				orm.Profesor lormProfesor = orm.ProfesorDAO.createProfesor();
				lormProfesor.setPersona(lormPersona);
				orm.ProfesorDAO.save(lormProfesor);
				// Se crean los 10 sueldos del profesor que corresponden a los 10 meses
				for(int i=0;i<10;i++){
					orm.Sueldo lormSueldo = orm.SueldoDAO.createSueldo();
					// Se asigna el profesor
					lormSueldo.setProfesor(lormProfesor);
					lormSueldo.setCantCursos(0);
					lormSueldo.setEstadoPago(0);
					lormSueldo.setMes(i+1);
					lormSueldo.setMonto(0);
					//Se guarda el sueldo
					orm.SueldoDAO.save(lormSueldo);
				}
				
				return "El Profesor ingresado exitosamente";
				
			} 
				return "El Profesor ingresado ya existe";
			}else{
				return "Atributo no valido";
			}
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Update the properties of the persistent object
		return null;
	}

	
	/**
	 * Metodo que permite buscar un profesor por medio de su rut
	 * @param rut del profesor
	 * @return
	 */
	public static String[] buscarProfesor(String rut) {
		//Arreglo que almacena los datos del profesor
		String[] datos = new String[3];
		//Condicion de busqueda del profesor
		String queryProfesor = "persona.rut='" + rut + "'";
		try {
			// Almacenamos en la variable el profesor con la condicion entregada
			orm.Profesor lormProfesor = orm.ProfesorDAO.loadProfesorByQuery(queryProfesor,null);
			// Obtenemos la cantidad de cursos del profesor
			int cant = Curso.calcularCantCursos(rut);
			// Si el profesor existe se puede proceder
			if (lormProfesor != null) {
				// Se almacenan los datos del profesor
				datos[0] = "" + lormProfesor.getPersona().getNombre() + " " + lormProfesor.getPersona().getApellido();
				datos[1] = "" + lormProfesor.getPersona().getRut();
				datos[2] = "" + cant;
				System.out.println("|nombre: " + datos[0] + " |Apellido: "
						+ datos[1] + " |Rut: " + datos[2] + "|Cursos: "
						+ datos[3]);
				// Retornamos los datos del profesor
				return datos;
			} else {
				return null;
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Metodo que registra el promedio de un estudiante en un curso
	 * @param rutEst a quien se le registra el promedio
	 * @param idCurso donde se registra el promedio
	 * @param promedio del curso
	 * @param rutProfesor quien registra el promedio
	 * @return
	 */
	public static String registrarPromedio(String rutEst, int idCurso, double promedio,String rutProfesor) {
		try {
			// Condicion de busqueda del estudiante (rut persona)
			String queryEstudiante = "persona.rut='" + rutEst+ "'";
			// Se almacena en la variable el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Si el estudiante existe se puede proceder
			if (lormEstudiante!=null){
				//Buscar la relación curso estudiante con el id del estudiante y id curso
				String queryEstCurso = "estudiante='" + lormEstudiante+ "'"+" and curso.id='"+idCurso+"'";
				// Variable que almacena estudiante_curso con la condicion entregada
				orm.Estudiante_curso lormEstudiante_curso = orm.Estudiante_cursoDAO.loadEstudiante_cursoByQuery(queryEstCurso, null);
				// Si la relacion existe se puede proceder
				if(lormEstudiante_curso!=null){
					// Si el promedio es igual nulo se puede proceder a registrarlo
					if (lormEstudiante_curso.getPromedio()==null){
						// Condicion de busqueda de curso_profesor (id del curso)
						String queryCurso_profesor = "curso.id='" + idCurso + "'";
						// Se almacena en la variable el curso_profesor con la condicion entregada
						orm.Curso_profesor lormCurso_profesor = orm.Curso_profesorDAO.loadCurso_profesorByQuery(queryCurso_profesor, null);
						// Si el profesor es el mismo al cual se le asigno el curso se puede proceder
						if(lormCurso_profesor.getProfesor().getPersona().getRut().equals(rutProfesor)){
							// Se asigna el promedio 
							lormEstudiante_curso.setPromedio(promedio);
							orm.Estudiante_cursoDAO.save(lormEstudiante_curso);
							return "Promedio registrado";
						} return "Acceso denegado";
					}
					return "El promedio fue registrado con anterioridad";
				} 
				return "El estudiante no posee el curso especificado";
			} 
			return "El estudiante no existe";
					
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo que registra la asistencia en un curso de un estudiante
	 * @param rutEst
	 * @param idCurso
	 * @param asistencia
	 * @param rutProfesor
	 * @return
	 */
	public static String registrarAsistencia(String rutEst, int idCurso, double asistencia,String rutProfesor) {
		try {
			// Condicion de busqueda del estudiante (rut persona)
			String queryEstudiante = "persona.rut='" + rutEst+ "'";
			// Se almacena en la variable el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Si el estudiante existe se puede proceder
			if (lormEstudiante!=null){
				//buscar la relación curso estudiante con el id del estudiante y id curso
				String queryEstCurso = "estudiante='" + lormEstudiante+ "'"+" and curso.id='"+idCurso+"'";
				// Variable que almacena estudiante_curso con la condicion entregada
				orm.Estudiante_curso lormEstudiante_curso = orm.Estudiante_cursoDAO.loadEstudiante_cursoByQuery(queryEstCurso, null);
				// Si la relacion existe se puede proceder
				if(lormEstudiante_curso!=null){
					// Si el porcentaje en el curso es nulo se puede registrar
					if (lormEstudiante_curso.getPorcAsistencia()==null){
						//Buscar la relación curso profesor con el id del estudiante y id curso
						String queryCurso_profesor = "curso.id='" + idCurso + "'";
						// Se almacena en la variable el curso_profesor con la condicion entregada
						orm.Curso_profesor lormCurso_profesor = orm.Curso_profesorDAO.loadCurso_profesorByQuery(queryCurso_profesor, null);
						// Si el profesor es el mismo al cual se le asigno el curso se puede proceder
						if(lormCurso_profesor.getProfesor().getPersona().getRut().equals(rutProfesor)){
							// Se asigna la asistencia
							lormEstudiante_curso.setPorcAsistencia(asistencia);
							// Se guarda la asistencia en la tabla
							orm.Estudiante_cursoDAO.save(lormEstudiante_curso);
							return "Asistencia registrada";
						} return "Acceso denegado";
					}
					return "La asistencia fue registrada con anterioridad";
				} 
				return "El estudiante no posee el curso especificado";
			} 
			return "El estudiante no existe";
					
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}