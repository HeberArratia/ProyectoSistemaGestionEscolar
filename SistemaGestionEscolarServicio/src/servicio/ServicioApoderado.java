package servicio;

import controlador.persona.Apoderado;

public class ServicioApoderado {
		public String crearApoderado(String nombre,String apellido,String rut,String pass){
			return Apoderado.agregarNuevoApoderado(nombre, apellido, rut, pass);
		}
}
