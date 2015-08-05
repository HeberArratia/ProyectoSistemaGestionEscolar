package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Persona.Apoderado;

public class ApoderadoTest {

	@Test
	public void test() {
		System.out.println(Apoderado.agregarNuevoApoderado("Sofia","Fuentes","65432342","232372"));
	}

}
