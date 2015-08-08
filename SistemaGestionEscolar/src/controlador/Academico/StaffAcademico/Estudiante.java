package controlador.Academico.StaffAcademico;

import org.orm.PersistentException;

import controlador.Academico.Curso;
import controlador.persona.*;
/**
 * 
 * @author heberarratia
 *
 */
public class Estudiante extends Persona {

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
	public static String agregarNuevoEstudiante(String nombre,String apellido,String rut,String pass, String rutApoderado) {
		try {
			Persona nuevaPersona = new Persona(nombre,apellido,rut,pass);
			// Se validan los atributos de la persona
			if (nuevaPersona.validarAtributos()) {
				// Condicion de busqueda del apoderado (rut de la persona)
				String queryApoderado = "persona.rut='" + rutApoderado + "'";
				// Variable que almacena el apoderado con la condicion entregada
				orm.Apoderado lormApoderado = orm.ApoderadoDAO.loadApoderadoByQuery(queryApoderado, null);
				// Si el apoderado existe se puede proceder
				if (lormApoderado != null) {
				// Se establece una condicion de busqueda (rut persona)
				String queryPersona = "rut='" + nuevaPersona.getRut() + "'";
				// Se almacena en la variable la persona con la condicion entregada
				orm.Persona lormPersonaBuscar = orm.PersonaDAO.loadPersonaByQuery(queryPersona, null);
				// Si la persona no existe se puede proceder
				if (lormPersonaBuscar == null) {
					// Crear nueva persona
					orm.Persona lormPersona = orm.PersonaDAO.createPersona();
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
	 * Metodo que permite buscar un estudiante y retornar sus datos
	 * @param rut
	 * @return
	 */
	public static String[] buscarEstudiate(String rut) {
		// Condicion de busqueda de el estudiante
		String queryEstudiante = "persona.rut='" + rut + "'";
		try {
			// Asignar estudiante con el rut especificado
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Si el estudiante existe se puede proceder
			if (lormEstudiante != null) {
				//Creamos una arreglo para almacenar los datos del estudiante
				String datos[]=new String[4];
				// Almacenamos los datos
				datos[0]=""+lormEstudiante.getPersona().getNombre() + " " + lormEstudiante.getPersona().getApellido();
				datos[1]=""+lormEstudiante.getPersona().getRut();
				datos[2]=""+lormEstudiante.getMatricula().getEstadoMatricula();
				datos[3]=""+lormEstudiante.getApoderado().getPersona().getNombre() + " " + lormEstudiante.getApoderado().getPersona().getApellido();
				System.out.println("|Nombre: "+datos[0]+" |Rut: "+datos[1]+" |Matricula: "+datos[2]+" |Apoderado: "+datos[3]);
			//Retornamos el arreglo de datos	
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
	 * Metodo que devuelve el promedio general del estudiante
	 * @param rutEstudiante a quien se le obtiene el promedio
	 * @return promedio del estudiante
	 */
	public static double obtenerPromedioGeneral(String rutEstudiante){
		double promedio = 0, sumatoria = 0;	
		boolean valorNulo = false;
		// datos que almacena todos los cursos del estudiante
		orm.Estudiante_curso[] ormEstudiante_cursos = null;
		try {			
			//Condicion de busqueda del estudiante (rut del estudiante)
			String queryEstudiante = "persona.rut='" + rutEstudiante	+ "'";
			// Se almacena en una variable el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Si el estudiante existe se puede proceder
			if(lormEstudiante!=null){
			//Condicion de busqueda de estudiante_curso (estudiante)
			String queryCurEst= "estudiante='"+lormEstudiante+ "'" + " and curso.estadocurso='" + 1 + "'";
			// datos que almacena las relaciones estudiante_curso con la condicion entregada
			ormEstudiante_cursos = orm.Estudiante_cursoDAO.listEstudiante_cursoByQuery(queryCurEst, null);
			// Se almacena el largo del datos
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
	 * @param rutEstudiante de quien se obtiene la asistencia
	 * @return asistencia del estudiante
	 */
	public static double obtenerPorcentajeAsistencia(String rutEstudiante){
		double promedioAsistencia = 0, sumatoria = 0;	
		// datos que almacena todos los cursos del estudiante
		orm.Estudiante_curso[] ormEstudiante_cursos = null;
		try {			
			//Condicion de busqueda del estudiante (rut del estudiante)
			String queryEstudiante = "persona.rut='" + rutEstudiante + "'";
			// Se almacena en una variable el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Si el estudiante existe se puede proceder
			if(lormEstudiante!=null){
				//Condicion de busqueda de la relacion estudiante_curso (estudiante)
				String queryCurEst= "estudiante='"+lormEstudiante+ "'" + " and curso.estadocurso='" + 1 + "'";
				// datos que almacena el estudiante_curso con la condicion entregada
				ormEstudiante_cursos = orm.Estudiante_cursoDAO.listEstudiante_cursoByQuery(queryCurEst, null);
				// Se almacena el largo del datos
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
		try {
			//Condicion de busqueda del estudiante
			String queryEstudiante = "persona.rut='" + rutEstudiante + "'";
			// Almacenamos en la variable el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante;
			lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Si el estudiante existe se puede proceder
			if (lormEstudiante!= null){
				if(Curso.calcularCantCursos(lormEstudiante.getPersona().getRut())!=0){
				//Obtenemos promedio del estudiante
				double promedio = obtenerPromedioGeneral(rutEstudiante);
				// Si el promedio no es cero se puede proceder
				if (promedio!=0){
					//Obtenemos la asistencia del estudiante
					double asistencia = obtenerPorcentajeAsistencia(rutEstudiante);
					//Retornamos como string el promedio y asistencia del estudiante
					return "El promedio es: " + promedio + " La asistencia es: " + asistencia;
				} return "Faltan promedios en curso del estudiante";	
				} return "El estudiante no tiene cursos";
			} return "El estudiante no existe";
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}