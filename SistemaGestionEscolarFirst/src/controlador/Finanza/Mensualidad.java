package controlador.Finanza;

import org.orm.PersistentException;

import controlador.Academico.Curso;

public class Mensualidad {

	private int mes;
	private int monto;
	
	/**
	 * Metodo que permite registrar el pago de mensualidad de un estudiante
	 * @param rutSc quien registra el pago de mensualidad
	 * @param rutEs a quien se le paga la mensualidad
	 * @param mes en el cual se paga la mensualidad
	 * @return string de confirmacion
	 */
	public static String regPagoMensualidad(String rutSc, String rutEs, int mes) {
		// Si el mes se encuentra entre 1 y 10 se puede proceder
		if (mes < 1 || mes > 10) {
			return "mes invalido";
		}
		try {
			//Se crea una condicion de busqueda
			String querySecretaria = "persona.rut='" + rutSc + "'";
			// Se almacena en la variable la secretaria con la condicion entregada
			orm.Secretaria lormSecretaria = orm.SecretariaDAO.loadSecretariaByQuery(querySecretaria, null);
			// Si la secretaria existe se puede proceder
			if (lormSecretaria != null) {
				//Se crea una condicion de busqueda
				String queryEstudiante = "persona.rut='" + rutEs + "'";
				// Se almacena en la variable el estudiante 
				orm.Estudiante lormEstudiante = orm.EstudianteDAO.loadEstudianteByQuery(queryEstudiante, null);			
				//Si el estudiante existe se puede proceder
				if (lormEstudiante != null) {
					// Se crea una condicion de busqueda de mensualidad (estudiante y mes)
					String queryMensualidad = "estudiante='" + lormEstudiante + "' " + " and mes='"+mes+"'";
					// Se almacena en la variable mensualidad con la condicion entregada
					orm.Mensualidad lormMensualidad = orm.MensualidadDAO.loadMensualidadByQuery(queryMensualidad, null);
					// Si la mensualidad no se encuentra pagada se puede proceder
					if (lormMensualidad.getMonto() == 0){
						int cant=Curso.calcularCantCursos(rutEs);
						// Si el estudiante tiene cursos
						if(cant!= 0){
						// Asignamos la secretaria a la mensualidad
						lormMensualidad.setSecretaria(lormSecretaria);
						// Asignamos el mes en que se paga la matricula
						lormMensualidad.setMes(mes);
						// Se asigna el monto pagado
						lormMensualidad.setMonto(cant*10000);
						orm.MensualidadDAO.save(lormMensualidad);
						return "se registro exitosamente";
						}
						return "El estudiante no tiene cursos, no podemos realizar el pago.";
					}
					return "La mensualidad se encuentra pagada";
				}
				return "El estudiante no existe";
			}
			return "La secretaria no existe";
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Metodo que permite obtener la lista de los estudiantes mososos en los pagos de mensualidad
	 * @param mes hasta el cual se desea obtener la lista
	 * @return
	 */
	public static String[][] ListMorososMensualidad(int mes) {
		try {
		// Validamos el mes
		if (mes > 0 && mes <=10){
			// Condicion de busqueda en mensualidad (monto 0 y mes menor o igual al entregado por parametro)
			String queryMensualidad = "monto='" + 0+ "' "+" and mes<='"+mes+ "'";
			//Matriz que guarda los datos a retornar
			String datos[][];
		 		//Arreglo que almacena las mensualidades con la condicion entregada
		    	orm.Mensualidad[] ormMensualidad = orm.MensualidadDAO.listMensualidadByQuery(queryMensualidad, null);
				//Obtenemos el largo del arreglo
		    	int length =/* Math.min(*/ormMensualidad.length/*, ROW_COUNT)*/;
		    	// Creamos la datos con la cantidad de filas del largo del arreglo y cuatro columnas
				datos=new String[length][4];
				for (int i = 0; i < length; i++) {
					//Guardamos en la matriz el nombre y apellido del estudiante mososo en mensualidad
					datos[i][0]=""+ormMensualidad[i].getEstudiante().getPersona().getNombre() + " " + ormMensualidad[i].getEstudiante().getPersona().getApellido();
					//Guardamos en la matriz el rut del estudiante mososo en mensualidad
					datos[i][1]=""+ormMensualidad[i].getEstudiante().getPersona().getRut();
					//Guardamos en la matriz el mes en que el estudiante debe la mensualidad
					datos[i][2]=""+ormMensualidad[i].getMes();
					//Guardamos en la matriz el monto del estudiante mososo en mensualidad
					datos[i][3]=""+ormMensualidad[i].getMonto();
					System.out.println("Nombre apellido: "+datos[i][0]+" |Rut: "+datos[i][1]+" |Mes: "+datos[i][2]+" |Deuda: $"+datos[i][3]);
				}
				// Retornamos la datos
				return datos;
		} 
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}