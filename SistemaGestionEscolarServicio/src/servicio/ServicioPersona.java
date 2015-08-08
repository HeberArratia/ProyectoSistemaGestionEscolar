package servicio;

import controlador.persona.Persona;

public class ServicioPersona {
	
	public String login(String rut,String pass){
		return Persona.login(rut, pass);
	}
}
