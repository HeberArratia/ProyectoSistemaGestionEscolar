package controlador.StaffAdministracion;

import org.orm.PersistentException;

import controlador.Persona.*;

public class Director extends Persona {
	
	
	
	public Director (String nombre, String apellido, String rut) {
		super(nombre, apellido, rut);
		// TODO Auto-generated constructor stub
	}
	
	public Director(String nombre, String apellido, String rut, String pass){
		super(nombre, apellido, rut, pass);
	}
	
	/**
	 * Metodo que permite crear un nuevo director
	 * @param nuevaPer
	 * @return string de confirmacion
	 */
	public static String agregarNuevoDirector(Persona nuevaPer) {
		try {
			// Se validan los atributos
			if (nuevaPer.validarAtributos()) {
			// Se establece una condicion de busqueda (persona id)
				String condicionPersona = "rut='" + nuevaPer.getRut() + "'";
			    // Se asigna a la variable la persona con la condicion establecida
				orm.Persona lormPersonaBuscar = orm.PersonaDAO.loadPersonaByQuery(condicionPersona, null);
				// Si la persona no existe se puede proceder
				if (lormPersonaBuscar == null) {
					// Se crea la nueva persona y se asignan sus atributos
					orm.Persona lormPersona = orm.PersonaDAO.createPersona();
					lormPersona.setNombre(nuevaPer.getNombre());
					lormPersona.setApellido(nuevaPer.getApellido());
					lormPersona.setRut(nuevaPer.getRut());
					// Se guarda la persona
					orm.PersonaDAO.save(lormPersona);
					// Se crea un nuevo director
					orm.Director lormDirector = orm.DirectorDAO.createDirector();
					// Se asigna la nueva persona al nuevo director
					lormDirector.setPersona(lormPersona);
					//  Se guarda el director
					orm.DirectorDAO.save(lormDirector);
					return "El director fue ingresado exitosamente";
				} 
				return "El director ingresado ya existe";	
			}
			return "Atributo no valido";
			
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Update the properties of the persistent object
			return null;
	}

}