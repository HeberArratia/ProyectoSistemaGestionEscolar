package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.persona.Persona;

public class PersonaTest {

	@Test
	public void test() {
		System.out.println(Persona.login("183511203", "74012"));
	}

}
