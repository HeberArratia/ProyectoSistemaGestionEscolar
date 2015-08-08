package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.StaffAdministracion.Secretaria;

public class SecretariaTest {

	@Test
	public void test() {
		System.out.println(Secretaria.agregarNuevaSecretatia("Carola", "Vergara", "183511203", "331135"));
	}

}
