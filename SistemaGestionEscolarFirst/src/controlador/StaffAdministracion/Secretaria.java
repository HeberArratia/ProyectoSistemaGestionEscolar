package controlador.StaffAdministracion;

import org.orm.PersistentException;

import controlador.Persona.*;

public class Secretaria extends Persona {
	
	
	public Secretaria(String nombre, String apellido, String rut) {
		super(nombre, apellido, rut);
		// TODO Auto-generated constructor stub
	}
	
	public Secretaria(String nombre, String apellido, String rut, String pass){
		super(nombre, apellido, rut, pass);
	}
	
	/**
	 * Metodo que permite agregar una nueva secretaria
	 * @param nuevaPersona
	 * @return string de confirmacion
	 */
	public static String agregarNuevaSecretatia(Persona nuevaPersona) {
		try {
			// Validar atributos del nuevo profesor 
			if (nuevaPersona.validarAtributos()) {
				// Se establece una condicion de busqueda
				String condicionPersona = "rut='" + nuevaPersona.getRut() + "'";
				// Se almacena en la variable la persona con la condicion entregada
				orm.Persona lormPersonaBuscar = orm.PersonaDAO.loadPersonaByQuery(condicionPersona, null);
				// Si la persona no existe se puede proceder
				if (lormPersonaBuscar == null) {
					// Crear nueva persona
					orm.Persona lormPersona = orm.PersonaDAO.createPersona();
					// Enviar valores a persona 
					lormPersona.setNombre(nuevaPersona.getNombre());
					lormPersona.setApellido(nuevaPersona.getApellido());
					lormPersona.setRut(nuevaPersona.getRut());
					// Guardar persona
					orm.PersonaDAO.save(lormPersona);
					// Crear nueva secretaria
					orm.Secretaria lormSecretaria = orm.SecretariaDAO.createSecretaria();
					//Asignar nueva persona a la nueva secretaria
					lormSecretaria.setPersona(lormPersona);
					// Guardar secretaria
					orm.SecretariaDAO.save(lormSecretaria);
					return "Se ingreso nueva secretaria correctamente";
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