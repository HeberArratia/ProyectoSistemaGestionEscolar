package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Academico.Curso;

public class CursoTest {

	@Test
	public void test() {
		
		 /*// CREAR CURSO
		 //Verficicar si se crea un curso correctamente
		 String resultado = "";
		 resultado = Curso.crearCurso("Matematica", "96356453");
		 // Resultado esperado: "Se creo el curso exitosamente"
		 assertTrue(resultado == "Se creo el curso exitosamente");
		 // --> Aprobado*/
		 
		 
		/*// CREAR CURSO
		//Verficicar ingreso de jefe de administracion no existente
		String resultado = "";
		resultado = Curso.crearCurso("Algebra", "96356451");
		// Resultado esperado: "No existe jefe de administracion"
		assertTrue(resultado == "No existe jefe de administracion");
		// --> Aprobado*/
		 
		/*// Desactivar curso
		//Verficicar si se desactiva un curso correctamente
		String resultado = "";
		resultado = Curso.desactivarCurso(1, "52347653");
		// Resultado esperado: "Curso desactivado exitosamente"
		assertTrue(resultado == "Curso desactivado exitosamente");
		// --> Aprobado*/
		
		/*// Desactivar curso
		//Verificar que no se pueda desactivar curso ya desactivado
		String resultado = "";
		resultado = Curso.desactivarCurso(1, "52347653");
		// Resultado esperado: "Curso se encuentra desactivado"
		assertTrue(resultado == "Curso se encuentra desactivado");
		// --> Aprobado*/
		
		/*// Desactivar curso
		//Verificar que no se pueda desactivar un curso inexistente
		String resultado = "";
		resultado = Curso.desactivarCurso(7, "52347653");
		// Resultado esperado: "Curso no existente"
		assertTrue(resultado == "Curso no existente");
		// --> Aprobado*/
		 
		/*// Desactivar curso
		//Verificar ingreso de director no existente
		String resultado = "";
		resultado = Curso.desactivarCurso(2, "132347653");
		// Resultado esperado: "No existe el director"
		assertTrue(resultado == "No existe el director");
		// --> Aprobado
		
		// Asignar profesor a curso
		//Verificar que el jefe de administracion exista
		String resultado = "";
		resultado = Curso.asignarProfesor(5, "Matematica", "54329873", "6356453");
		// Resultado esperado: "El jefe de administracion no existe";
		assertTrue(resultado == "No existe el curso");
		// --> Aprobado*/
					
		/*// Inscribir estudiante
		//Verificar que se inscribe estudiante correctamente
		String resultado = "";
		resultado = Curso.inscribirEstudiante(2, "197652345", "76542342");
		// Resultado esperado: "Alumno inscrito";
		assertTrue(resultado == "Alumno inscrito");
		// --> Aprobado*/
		
		/*// Crear curso
		//Verificar que no se ingrese nombre muy corto
		String resultado = "";
		resultado = Curso.crearCurso("Ge", "96356453");
		// Resultado esperado: "Nombre inválido (debe ser mayor a 4 y menor que 21)";
		assertTrue(resultado == "Nombre inválido (debe ser mayor a 4 y menor que 21)");
		// --> Aprobado*/
		
		/*// Crear curso
		//Verificar que no se ingrese rut inválido
		String resultado = "";
		resultado = Curso.crearCurso("Geografia", "assdf");
		// Resultado esperado: "Rut inválido";
		assertTrue(resultado == "Rut inválido");
		// --> Aprobado*/
		
	    //System.out.println(Curso.crearCurso("Geografia", "96356453"));
		//System.out.println(Curso.asignarProfesor(3, "Geografia", "78763452", "96356453"));
		System.out.println(Curso.inscribirEstudiante(3, "187003105", "78763452"));
		
	}

}






















//...





















