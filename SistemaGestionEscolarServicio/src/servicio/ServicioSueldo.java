package servicio;

import controlador.Finanza.Sueldo;

public class ServicioSueldo {
	
	public String registrarSueldo(String rutProf, String rutAdm, int mes){
		return Sueldo.registrarSueldoProf(rutProf, rutAdm, mes);
	}
	
	public String obtenerSueldos(String rutProf){
		return Sueldo.obtenerListSueldoProf(rutProf);
	}
}
