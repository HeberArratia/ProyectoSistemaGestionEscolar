package servicio;

import controlador.Finanza.Mensualidad;

public class ServicioMensualidad {
	
	public String registrarPagoMensualidad(String rutSc, String rutEs, int mes){
		return Mensualidad.regPagoMensualidad(rutSc, rutEs, mes);
	}
	
	public String obtenerMorososMensualidad(int mes){
		return Mensualidad.ListMorososMensualidad(mes);
	}
	
	
}
