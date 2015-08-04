package controlador.Persona;

import org.orm.PersistentException;

public class Apoderado extends Persona {

	public Apoderado(String nombre, String apellido, String rut) {
		super(nombre, apellido, rut);
		// TODO Auto-generated constructor stub
	}
	
	public Apoderado(String nombre, String apellido, String rut, String pass){
		super(nombre, apellido, rut, pass);
	}
	//COMPROBADO!!
	public static String agregarNuevoApoderado(Persona nuevaPersona) {
		try {
			if (nuevaPersona.validarAtributos()) {
				// Se establece una condicion de busqueda
				String condicionPersona = "rut='" + nuevaPersona.getRut() + "'";
				// Se asigna a la variable lormPersonaBuscar, la persona con la
				// condicion establecida
				orm.Persona lormPersonaBuscar = orm.PersonaDAO
						.loadPersonaByQuery(condicionPersona, null);
				// Si la persona no existe
				if (lormPersonaBuscar == null) {
					// Crear nueva persona
					orm.Persona lormPersona = orm.PersonaDAO.createPersona();
					// Enviar valores a persona encontrados en el objto Persona
					// recibido por parametro.
					lormPersona.setNombre(nuevaPersona.getNombre());
					lormPersona.setApellido(nuevaPersona.getApellido());
					lormPersona.setRut(nuevaPersona.getRut());
					// Guardar persona
					orm.PersonaDAO.save(lormPersona);

					// Crear nueva secretaria
					orm.Apoderado lormApoderado = orm.ApoderadoDAO
							.createApoderado();
					lormApoderado.setPersona(lormPersona);
					// Guardar secretaria
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