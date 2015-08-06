package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Academico.StaffAcademico.Estudiante;

public class EstudianteTest {

	@Test
	public void test() {
		//System.out.println(Estudiante.agregarNuevoEstudiante("David","Cartes","176786542","981232", "107652346"));
		//Estudiante.buscarEstudiate("176786542");
		
		 /*// AGREGAR NUEVO ESTUDIANTE
		 //Verificar que no se pueda ingresar estudiante sin apoderado
		 String resultado = "";
		 resultado = Estudiante.agregarNuevoEstudiante("Gonzalo", "Guzman", "197652345", "736473", "233445431");
		 // Resultado esperado: "El apoderado no existe"
		 assertTrue(resultado == "El apoderado no existe");
		 // --> Aprobado*/
		 
		/*// AGREGAR NUEVO ESTUDIANTE
		//Verificar que se ingrese nuevo estudiante correctamente
		String resultado = "";
		resultado = Estudiante.agregarNuevoEstudiante("Gonzalo", "Guzman", "197652345", "736473", "65432342");
		// Resultado esperado: "Se ingreso nuevo alumno correctamente"
		assertTrue(resultado == "Se ingreso nuevo alumno correctamente");
		// --> Aprobado*/
		
		//*/ OBTENER SITUACION ESTUDIANTE
		//Verificar que no se muestre estudiante sin cursos
		String resultado = "";
		resultado = Estudiante.obtenerSituacionEstudiante("197652345");
		// Resultado esperado: "El estudiante no tiene cursos"
		assertTrue(resultado == "El estudiante no tiene cursos");
		// --> Aprobado*/*/
		System.out.println(Estudiante.agregarNuevoEstudiante("Heber", "Arratia", "187003105", "03060306", ""));
		

	}

}





























//___