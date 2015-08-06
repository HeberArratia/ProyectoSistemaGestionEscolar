package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Finanza.Matricula;
import controlador.Finanza.Mensualidad;

public class MensualidadTest {

	@Test
	public void test() {
		
		
		 /*// PAGAR MENSUALIDAD
		 //Verificar si se paga la mensualidad correctamente
		 String resultado = "";
		 resultado = Mensualidad.regPagoMensualidad("183511203", "176786542", 2);
		 // Resultado esperado: "Se registro pago exitosamente"
		 assertTrue(resultado == "Se registro pago exitosamente");
		 // --> Aprobado*/
		
		Mensualidad.ListMorososMensualidad(33);
	}

}































//