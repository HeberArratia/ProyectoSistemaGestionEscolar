package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.StaffAdministracion.Director;

public class DirectorTest {

	@Test
	public void test() {
		System.out.println(Director.agregarNuevoDirector("Flavio","Sagredo","52347653","765367"));
	}

}
