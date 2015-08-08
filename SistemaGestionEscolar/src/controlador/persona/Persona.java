package controlador.persona;

import org.orm.PersistentException;

/**
 * 
 * @author heberarratia
 *
 */
public class Persona {
	private String nombre;
	private String apellido;
	private String rut;
	private String pass;
	
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param rut
	 */

	public Persona(String nombre, String apellido, String rut) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
	}
	
	public Persona(String nombre, String apellido, String rut, String pass) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.pass=pass;
	}

	
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	/**
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return this.rut;
	}

	/**
	 * 
	 * @param rut
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean validarAtributos() {
		/*
		 * Si nombre y apellido son menores e iguales que 20, nombre y apellido
		 * estan compuestos de letras y la validacion del rut es verdadera se
		 * retorna una variable boolean true, de lo contrario se retorna false
		 */
		if (this.nombre.length() <= 20 && this.apellido.length() <= 20
				&& validarSoloLetras(this.nombre) && validarPass()
				&& validarSoloLetras(this.apellido) && validarRut()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que valida que el rut este compuesto de 9 numeros
	 * 
	 * @return booleano con el resultado de la operacion
	 */
	public boolean validarRut() {
		// Si el parametro ingresado se compone de numeros y su largo es 9, se
		// retorna true
		if (this.rut.matches("\\d*") == true && (this.rut.length() == 9 || this.rut.length() == 8)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validacionRut(String rut) {
		// Si el parametro ingresado se compone de numeros y su largo es 9, se
		// retorna true
		if (rut.matches("\\d*") == true && (rut.length() == 9 || rut.length() == 8)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que valida que una cadena ingresada por parametro se componga de
	 * solo letras
	 * 
	 * @param cedena
	 *            de texto
	 * @return booleano con el resultado de la operacion
	 */
	public boolean validarSoloLetras(String cedena) {
		// Si la cadena se compone de solo letras, se retorna true
		if (cedena.matches("([a-z]|[A-Z]|\\s)+")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Metodo que valida que el largo del pass sea mayor a 5 y menor o igual a 15
	 * @return
	 */
	public boolean validarPass(){
		if (this.pass.length() > 5 && this.pass.length()<=15) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Metodo que permite verificar si la persona existe y a que perfil corresponde
	 * @param rut
	 * @param pass
	 * @return string de confirmacion
	 */
	// Este es el método 
	public static String login(String rut, String pass){
		try {
			// Condicion de busqueda (rut persona)
			String condicion= "persona.rut='"+rut+ "'" + " and persona.pass='" + pass + "'";
			// Se almacena en variable cada objeto con la condicion entregada		
			orm.Profesor lormProfesor = orm.ProfesorDAO.loadProfesorByQuery(condicion, null);
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(condicion, null);
			orm.Apoderado lormApoderado = orm.ApoderadoDAO.loadApoderadoByQuery(condicion, null);
			orm.Director lormDirector = orm.DirectorDAO.loadDirectorByQuery(condicion, null);
			orm.Jefeadministracion lormJefeadministracion = orm.JefeadministracionDAO.loadJefeadministracionByQuery(condicion, null);
			orm.Secretaria lormSecretaria = orm.SecretariaDAO.loadSecretariaByQuery(condicion, null);
			// Si existe alguno de los perfiles se retorna como string, de lo contrario se retorna error
			if (lormProfesor!=null){
				return "Profesor";
			} else if (lormEstudiante!=null){
				return "Estudiante";
			} else if (lormApoderado!=null){
				return "Apoderado";
			} else if (lormDirector!=null){
				return "Director";
			} else if (lormJefeadministracion!=null){
				return "JefeAdm";
			} else if (lormSecretaria!=null){
				return "Secretaria";
			} else {
				return "Error";
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
	}
	
}