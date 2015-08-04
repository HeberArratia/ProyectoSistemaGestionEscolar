package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Finanza.Sueldo;

public class SueldoTest {

	@Test
	public void test() {
		System.out.println(Sueldo.registrarSueldoProf("76542342","96356453", 1));
	}

}
