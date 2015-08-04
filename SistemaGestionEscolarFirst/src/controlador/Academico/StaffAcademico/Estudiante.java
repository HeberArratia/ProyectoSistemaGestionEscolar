package controlador.Academico.StaffAcademico;

import org.orm.PersistentException;

import controlador.Persona.*;
/**
 * 
 * @author heberarratia
 *
 */
public class Estudiante extends Persona {
	private static final int ROW_COUNT = 100;

	public Estudiante(String nombre, String apellido, String rut) {
		super(nombre, apellido, rut);
		// TODO Auto-generated constructor stub
	}
	
	public Estudiante(String nombre, String apellido, String rut, String pass){
		super(nombre, apellido, rut, pass);
	}
	
	/**
	 * Metodo que permite crear un nuevo estudiante
	 * @param nuevaPersona
	 * @param rutApoderado quien es apoderado del estudiante
	 * @return string de confirmacion
	 */
	public static String agregarNuevoEstudiante(Persona nuevaPersona, String rutApoderado) {
		try {
			// Se validan los atributos de la persona
			if (nuevaPersona.validarAtributos()) {
				// Condicion de busqueda del apoderado (rut de la persona)
				String queryApoderado = "persona.rut='" + rutApoderado + "'";
				// Variable que almacena el apoderado con la condicion entregada
				orm.Apoderado lormApoderado = orm.ApoderadoDAO.loadApoderadoByQuery(queryApoderado, null);
				// Si el apoderado existe
				if (lormApoderado != null) {
				// Se establece una condicion de busqueda (rut persona)
				String condicionPersona = "rut='" + nuevaPersona.getRut() + "'";
				// Se almacena en la variable la persona con la condicion entregada
				orm.Persona lormPersonaBuscar = orm.PersonaDAO.loadPersonaByQuery(condicionPersona, null);
				// Si la persona no existe se puede proceder
				if (lormPersonaBuscar == null) {
					// Crear nueva persona
					orm.Persona lormPersona = orm.PersonaDAO
							.createPersona();
					// Enviar valores a persona encontrados en el objeto Persona
					lormPersona.setNombre(nuevaPersona.getNombre());
					lormPersona.setApellido(nuevaPersona.getApellido());
					lormPersona.setRut(nuevaPersona.getRut());
					orm.PersonaDAO.save(lormPersona);

					// Crear un nuevo estudiante
					orm.Estudiante lormEstudiante = orm.EstudianteDAO
							.createEstudiante();
					
					//Asignar persona al nuevo estudiante
					lormEstudiante.setPersona(lormPersona);
					//Asignar apoderado al nuevo estudiante
					lormEstudiante.setApoderado(lormApoderado);
					//Guardar estudiante
					orm.EstudianteDAO.save(lormEstudiante);

					// Crear matricula al nuevo estudiante
					orm.Matricula lormMatricula = orm.MatriculaDAO
							.createMatricula();
					// Asignar estudiante a la nueva matricula
					lormMatricula.setEstudiante(lormEstudiante);
					// Asignar matricula no pagada (estado cero y monto cero)
					lormMatricula.setEstadoMatricula(0);
					lormMatricula.setMonto(0);
					//Guardar matricula
					orm.MatriculaDAO.save(lormMatricula);
					
					// Crear las 10 Mensualidades que debe pagar el estudiante
					for(int i=0;i<10;i++){
						// Se crea la mensualidad
						orm.Mensualidad lormMensualidad = orm.MensualidadDAO.createMensualidad();
						// Se asigna el mes y monto
						lormMensualidad.setMes(i+1);
						lormMensualidad.setMonto(0);
						// Se asigna estudiante a la mensualidad
						lormMensualidad.setEstudiante(lormEstudiante);
						// Se guarda la mensualidad
						orm.MensualidadDAO.save(lormMensualidad);
					}
					
					// Si todo se hace de manera correcta se retorna mensaje
					return "Se ingreso nuevo alumno correctamente";
				} 
					return "La persona ya existe";
				
				}
					return "El apoderado no existe";	
			}
			return "Atributo invalido";
			
	} catch (PersistentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}

	/**
	 * Metodo que busca un estudiante
	 * @param rut
	 * @return
	 */
	public static orm.Estudiante buscarEstudiate(String rut) {
		// Condicion de busqueda de el estudiante
		String condicionEstudiante = "persona.rut='" + rut + "'";
		orm.Estudiante lormEstudiante = null;
		try {
			// Asignar estudiante con el rut especificado
			lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(
					condicionEstudiante, null);
			// Si el estudiante especificado existe, se puede proceder
			if (lormEstudiante != null) {
				return lormEstudiante;

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
	 * Metodo que devuelve el promedio general del estudiante
	 * @param rutEstudiante
	 * @return promedio del estudiante
	 */
	public static double obtenerPromedioGeneral(String rutEstudiante){
		double promedio = 0, sumatoria = 0;	
		boolean valorNulo = false;
		// Arreglo que almacena todos los cursos del estudiante
		orm.Estudiante_curso[] ormEstudiante_cursos = null;
		try {			
			//Condicion de busqueda del estudiante (rut del estudiante)
			String queryEstudiante = "persona.rut='" + rutEstudiante	+ "'";
			// Se almacena en una variable el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Si el estudiante existe se puede proceder
			if(lormEstudiante!=null){
			//Condicion de busqueda de estudiante_curso (estudiante)
			String condicionEst_curso = "estudiante='" + lormEstudiante	+ "'";
			// Arreglo que almacena el estudiante_curso con la condicion entregada
			ormEstudiante_cursos = orm.Estudiante_cursoDAO.listEstudiante_cursoByQuery(condicionEst_curso, null);
			// Se almacena el largo del arreglo
			int length = ormEstudiante_cursos.length;	
				for (int i = 0; i < length; i++) {
					// Si un promedio que se encuentra en la tabla estudiante_curso es nulo se cambia el valor del booleano
					if(ormEstudiante_cursos[i].getPromedio()==null){
						valorNulo = true;
						break;
					} else {
						// De lo contrario se suma cada promedio
						sumatoria += ormEstudiante_cursos[i].getPromedio();
					}			
				} 		
				// Si valorNulo es verdadero a promedio se le asigna un 0
				if (valorNulo){
					promedio = 0;
				} else{
					// De lo contrario se asigna a promedio la sumatoria divida por la cantidad del largo
					promedio = sumatoria/length;
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// Se retorna un promedio
		return promedio;
	}
	
	/**
	 * Metodo que devuelve la asistencia general de un estudiante
	 * @param rutEstudiante
	 * @return asistencia del estudiante
	 */
	public static double obtenerPorcentajeAsistencia(String rutEstudiante){
		double promedioAsistencia = 0, sumatoria = 0;	
		// Arreglo que almacena todos los cursos del estudiante
		orm.Estudiante_curso[] ormEstudiante_cursos = null;
		try {			
			//Condicion de busqueda del estudiante (rut del estudiante)
			String queryEstudiante = "persona.rut='" + rutEstudiante	+ "'";
			// Se almacena en una variable el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Si el estudiante existe se puede proceder
			if(lormEstudiante!=null){
				//Condicion de busqueda de estudiante_curso (estudiante)
				String condicionEst_curso = "estudiante='" + lormEstudiante	+ "'";
				// Arreglo que almacena el estudiante_curso con la condicion entregada
				ormEstudiante_cursos = orm.Estudiante_cursoDAO.listEstudiante_cursoByQuery(condicionEst_curso, null);
				// Se almacena el largo del arreglo
			    int length = ormEstudiante_cursos.length;
				for (int i = 0; i < length; i++) {
					// Si una asistencia de la tabla estudiante_cursos es nulo se suma un cero
					if(ormEstudiante_cursos[i].getPorcAsistencia()==null){
						sumatoria += 0;
					} else{
						// De lo contrario se suma la asistencia
						sumatoria += ormEstudiante_cursos[i].getPorcAsistencia();
					}			
				}
				
				promedioAsistencia = sumatoria/ormEstudiante_cursos.length;
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return promedioAsistencia;
	}
	
	/**
	 * Metodo que devuelve el promedio y asistencia de un estudiante
	 * @param rutEstudiante
	 * @return string
	 */
	public static String obtenerSituacionEstudiante(String rutEstudiante){
		double asistencia = obtenerPorcentajeAsistencia(rutEstudiante);
		double promedio = obtenerPromedioGeneral(rutEstudiante);
		if (promedio==0){
			return "Faltan promedios en curso";
		} 
		return "El promedio es: " + promedio + " La asistencia es: " + asistencia;
	}
	
}