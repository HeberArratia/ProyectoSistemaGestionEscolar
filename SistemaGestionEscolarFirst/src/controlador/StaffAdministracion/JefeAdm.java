package controlador.StaffAdministracion;

import org.orm.PersistentException;

import controlador.Persona.*;

public class JefeAdm extends Persona {
	
	
	public JefeAdm(String nombre, String apellido, String rut) {
		super(nombre, apellido, rut);
		// TODO Auto-generated constructor stub
	}
	
	public JefeAdm(String nombre, String apellido, String rut, String pass){
		super(nombre, apellido, rut, pass);
	}
	
	/**
	 * Metodo que permite crear un nuevo jede de administracion
	 * @param nuevaPer
	 * @return string de confirmacion
	 */
	public static String agregarNuevoJefeAdm(Persona nuevaPer) {
		try {
			// Se validan los atributos de la nueva persona
			if (nuevaPer.validarAtributos()) {
				// Se establece una condicion de busqueda 
				String condicionPersona = "rut='" + nuevaPer.getRut() + "'";
			    // Se almacena en la variable la persona con la condicion entregada
				orm.Persona lormPersonaBuscar = orm.PersonaDAO.loadPersonaByQuery(condicionPersona, null);
				// Si la persona no existe se puede proceder
				if (lormPersonaBuscar == null) {
					// Se crea la nueva persona
					orm.Persona lormPersona = orm.PersonaDAO.createPersona();
					// Se asignan los atributos 
					lormPersona.setNombre(nuevaPer.getNombre());
					lormPersona.setApellido(nuevaPer.getApellido());
					lormPersona.setRut(nuevaPer.getRut());
					// Se guarda la nueva persona
					orm.PersonaDAO.save(lormPersona);
					// Se crea un nuevo jefe de administracion
					orm.Jefeadministracion lormJadm = orm.JefeadministracionDAO.createJefeadministracion();
					// Se asigna la persona al nuevo jefe de administracion
					lormJadm.setPersona(lormPersona);
					// Se guarda el nuevo jefe de administracion
					orm.JefeadministracionDAO.save(lormJadm);
					return "El jefe adm ingresado exitosamente";
				} else {
					return "El Profesor ingresado ya existe";
				}
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

}