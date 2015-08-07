package servicio;

import controlador.Finanza.Matricula;

public class ServicioMatricula {
	public String pagarMatricula(String rutEstudiante,String rutSecretaria){
		return Matricula.pagarMatricula(rutEstudiante, rutSecretaria);
	}
	
	public String obtenerMorososMatricula(){
		return Matricula.ListMorososMatricula();
	}
}
