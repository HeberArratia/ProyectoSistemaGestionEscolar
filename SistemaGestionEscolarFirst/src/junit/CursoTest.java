package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Academico.Curso;

public class CursoTest {

	@Test
	public void test() {
		 //System.out.println(Curso.crearCurso(new Curso("Lenguaje"), "96356453"));
		 //System.out.println(Curso.asignarProfesor(4,"Lenguaje", "76543456", "96356453"));
		 System.out.println(Curso.asignarProfesor(3,"Geografia", "76542342", "96356453"));
	}

}
