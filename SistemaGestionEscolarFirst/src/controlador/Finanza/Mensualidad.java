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
						// Asignamos la secretaria a la mensualidad
						lormMensualidad.setSecretaria(lormSecretaria);
						// Asignamos el mes en que se paga la matricula
						lormMensualidad.setMes(mes);
						int cant=Curso.calcularCantCursos(rutEs);
						// Si el estudiante tiene cursos
						if(cant!= 0){
							// Se asigna el monto pagado
							lormMensualidad.setMonto(cant*10000);
							orm.MensualidadDAO.save(lormMensualidad);
							return "se registro exitosamente";
						}
						return "El estudiante no tiene cursos";
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

	//COMPROBADO!!
	public static orm.Mensualidad[] obtenerListMorososMensualidad(int mes) {
		String condicionMonto = "monto='" + 0+ "' "+ " and mes<='"+mes+"'";
		orm.Mensualidad[] ormMensualidades = null;
		try {
			 ormMensualidades = orm.MensualidadDAO.listMensualidadByQuery(condicionMonto, null);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ormMensualidades;
	}

}