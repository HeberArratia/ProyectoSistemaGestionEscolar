package controlador.persona;

import org.orm.PersistentException;
/**
 * 
 * @author heberarratia
 *
 */
public class Apoderado extends Persona {

	public Apoderado(String nombre, String apellido, String rut) {
		super(nombre, apellido, rut);
		// TODO Auto-generated constructor stub
	}
	
	public Apoderado(String nombre, String apellido, String rut, String pass){
		super(nombre, apellido, rut, pass);
	}
	
	/**
	 * Metodo que permite agregar un nuevo apoderado
	 * @param nuevaPersona
	 * @return 
	 */
	public static String agregarNuevoApoderado(String nombre,String apellido,String rut,String pass) {
		try {
			Persona nuevaPersona = new Persona(nombre,apellido,rut,pass);
			if (nuevaPersona.validarAtributos()) {
				// Se establece una condicion de busqueda
				String condicionPersona = "rut='" + nuevaPersona.getRut() + "'";
				// Variable que contiene la persona con la condicion entregada 
				orm.Persona lormPersonaBuscar = orm.PersonaDAO.loadPersonaByQuery(condicionPersona, null);
				// Si la persona no existe se puede proceder
				if (lormPersonaBuscar == null) {
					// Crear nueva persona
					orm.Persona lormPersona = orm.PersonaDAO.createPersona();
					// Asignar valores a nueva persona
					lormPersona.setNombre(nuevaPersona.getNombre());
					lormPersona.setApellido(nuevaPersona.getApellido());
					lormPersona.setRut(nuevaPersona.getRut());
					// Guardar persona
					orm.PersonaDAO.save(lormPersona);
					// Crear nuevo apoderado
					orm.Apoderado lormApoderado = orm.ApoderadoDAO.createApoderado();
					// Asignar persona a apoderado
					lormApoderado.setPersona(lormPersona);
					// Guardar apoderado
					orm.ApoderadoDAO.save(lormApoderado);
					return "Se ingreso nuevo apoderado correctamente";
				} else {
					return "La persona ya existe";
				}
			} else {
				return "Atributo no valido";
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}