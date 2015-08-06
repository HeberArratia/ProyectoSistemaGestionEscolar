package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.persona.Apoderado;

public class ApoderadoTest {

	@Test
	public void test() {
		System.out.println(Apoderado.agregarNuevoApoderado("Marta","Cardenas","102345432","232322"));
	}

}
