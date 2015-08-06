package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Academico.StaffAcademico.Profesor;
import controlador.persona.Persona;

public class ProfesorTest {

	@Test
	public void test() {
		System.out.println(Profesor.agregarNuevoProfesor(new Persona("Marcos","Avila","123453322","323622")));
		
			
		 /*// REGRISTRAR PROMEDIO ESTUDIANTE
		 //Verificar que no se ingrese el mismo promedio
		 String resultado = "";
		 resultado = Profesor.registrarPromedio("197652345", 2, 5.3, "76542342");
		 // Resultado esperado: "El promedio fue registrado con anterioridad"
		 assertTrue(resultado == "El promedio fue registrado con anterioridad");
		 // --> Aprobado*/
		 
		/*// REGRISTRAR ASISTENCIA ESTUDIANTE
		// Verificar que no se registre asistencia nuevamente
		String resultado = "";
		resultado = Profesor.registrarAsistencia("197652345", 2, 80, "76542342");
		// Resultado esperado: "La asistencia fue registrada con anterioridad";
		assertTrue(resultado == "La asistencia fue registrada con anterioridad");
		// --> Aprobado*/
	}

}




























//

















