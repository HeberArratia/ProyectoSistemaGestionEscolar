package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Academico.StaffAcademico.Profesor;
import controlador.Persona.Persona;

public class ProfesorTest {

	@Test
	public void test() {
		System.out.println(Profesor.agregarNuevoProfesor(new Persona("Catalina","Avello","76543456","386421")));
	}

}
