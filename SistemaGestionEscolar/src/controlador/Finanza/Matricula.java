package controlador.Finanza;

import org.orm.PersistentException;

import com.google.gson.Gson;
/**
 * 
 * @author heberarratia
 *
 */
public class Matricula {

	private int estadoMatricula;
	private int monto;

	/**
	 * Metodo que permite cancelar la matricula de un estudiante
	 * @param rutEstudiante 
	 * @param rutSecretaria 
	 * @param monto 
	 * @return String de confirmacion
	 */
	public static String pagarMatricula(String rutEstudiante,
			String rutSecretaria) {
		try {
			// Condicion de busqueda de el estudiante
			String queryEstudiante = "persona.rut='" + rutEstudiante + "'";
			// Variable que almacena el estudiante con la condicion entregada
			orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);
			// Condicion de busqueda de la secretaria
			String condicionSecretaria = "persona.rut='" + rutSecretaria + "'";
			// Variable que almacena la secretaria con la condicion entregada
			orm.Secretaria lormSecretaria = orm.SecretariaDAO.loadSecretariaByQuery(condicionSecretaria, null);
			// Si existe el estudiante y la secretaria se puede proceder
			if (lormEstudiante != null && lormSecretaria != null) {
				// Condicion de busqueda de la matricula
				String queryMatricula = "estudiante='" + lormEstudiante + "'";
				orm.Matricula lormMatricula = orm.MatriculaDAO.loadMatriculaByQuery(queryMatricula, null);
				// Si el estado de matricula se encuentra no pagado (0) se puede proceder
				if (lormMatricula.getEstadoMatricula() == 0) {
					// Enviar valores a matricula
					lormMatricula.setEstadoMatricula(1);
					lormMatricula.setMonto(20000);
					lormMatricula.setSecretaria(lormSecretaria);
					// Guardar matricula
					orm.MatriculaDAO.save(lormMatricula);
					return "Matricula pagada";
				} else {
					return "La matricula ya se encuentra pagada";
				}
			} else {
				return "No existe estudiante o secretaria";
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo que permite obtener una lista de los estudiantes morosos en los pagos de matricula
	 * @return String
	 */
	public static String ListMorososMatricula() {
		   // Matriz donde se van a guardar todos los alumnos con matricula no pagada
			String datos[][];
			//Instanciamos el objeto Gson
			Gson gson = new Gson();
		try {
			//Condicion de busqueda de la matricula (estado de matricula no pagado (0))
			String queryMatricula = "estadoMatricula='" + 0 + "'";
			// Arreglo que contiene la lista de matriculas de los estudiantes con la condicion entregada
			orm.Matricula[] ormMatriculas = orm.MatriculaDAO.listMatriculaByQuery(queryMatricula,null);
			//Obtenemos el largo del arreglo
			int length =/* Math.min(*/ormMatriculas.length/*, ROW_COUNT)*/;
			// Si el largo del arreglo es mayor a cero podemos continuar
			if (length>0){
			//A la matriz de datos le asignamos su nomero de filas y columnas
			datos= new String [length][3];
			for (int i = 0; i < length; i++) {
				//Almacenamos los datos
				datos[i][0]=""+ormMatriculas[i].getEstudiante().getPersona().getNombre() + " " + ormMatriculas[i].getEstudiante().getPersona().getApellido();
				datos[i][1]=ormMatriculas[i].getEstudiante().getPersona().getRut();
				datos[i][2]=""+20000;
				System.out.println("|Nombre: "+datos[i][0]+" |Rut: "+datos[i][1]+" |Deuda: "+datos[i][2]);
				
			}
			//Guardamos la matriz como Gson
			String arrayDatosJson = gson.toJson(datos);
			//Retornamos el Gson
			return arrayDatosJson;
			} return null;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}