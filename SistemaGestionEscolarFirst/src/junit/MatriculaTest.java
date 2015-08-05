package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Finanza.Matricula;

public class MatriculaTest {

	@Test
	public void test() {
		
		
		 // PAGAR MATRICULA
		 //Verificar que no se pueda cancelar matricula nuevamente
		 String resultado = "";
		 resultado = Matricula.pagarMatricula("176786542", "183511203");
		 // Resultado esperado: "La matricula ya se encuentra pagada"
		 assertTrue(resultado == "La matricula ya se encuentra pagada");
		 // --> Aprobado
		 
		 Matricula.ListMorososMatricula();
	}

}




























//
