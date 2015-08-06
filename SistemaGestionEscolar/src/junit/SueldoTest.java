package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Finanza.Sueldo;

public class SueldoTest {

	@Test
	public void test() {
		
		 // PAGAR SUELDO
		 //Verificar si se cancela sueldo exitosamente
		 String resultado = "";
		 resultado = Sueldo.registrarSueldoProf("76542342", "96356453", 6);
		 // Resultado esperado: "Sueldo pagado exitosamente"
		 assertTrue(resultado == "Sueldo pagado exitosamente");
		 // --> Aprobado
	}

}



























//