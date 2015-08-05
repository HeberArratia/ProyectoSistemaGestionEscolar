package controlador.Finanza;

import org.orm.PersistentException;

import controlador.Academico.Curso;
/**
 * 
 * @author heberarratia
 *
 */
public class Sueldo {
	private static final int ROW_COUNT = 100;

	private int monto;
	private int mes;
	private int cantCursos;
	private int estadoPsgo;
	
	/**
	 * Metodo que permite registrar el sueldo de un profesor
	 * @param rutProf a quien se le registra el pago de su sueldo
	 * @param rutAdm quien registra el pago
	 * @param mes en que se registra el pago
	 * @return mensaje de confirmacion
	 */
	public static String registrarSueldoProf(String rutProf, String rutAdm, int mes) {
		// se valida si el mes es correcto
				if (mes < 1 || mes > 10) {
					return "mes invalido";
				}
				try {
					// Condicion de busqueda (rut de persona)
					String queryJefeAdm = "persona.rut='" + rutAdm + "'";
					// Variable que almacena el jefe de administracion con la condicion entregada
					orm.Jefeadministracion lormJefeAdm = orm.JefeadministracionDAO.loadJefeadministracionByQuery(queryJefeAdm, null);
					// si existe el jefe de administracion
					if (lormJefeAdm != null) {
						//se crea una condicion de busqueda del profesor 
						String queryProfesor = "persona.rut='" + rutProf + "'";
						// Variable que almacena al profesor con la condicion entregada
						orm.Profesor lormProfesor = orm.ProfesorDAO.loadProfesorByQuery(queryProfesor, null);
						// Si el profesor existe
						if (lormProfesor != null) {
							// Se crea la condicion de busqueda del sueldo (id profesor y mes)
							String querySueldo = "profesor.id='" + lormProfesor.getId() + "'"+ " and mes='"+mes+"'";
							// Variable que almacena el sueldo con la condicion entregada
							orm.Sueldo lormSueldo = orm.SueldoDAO.loadSueldoByQuery(querySueldo, null);
							// Si el profesor tiene cursos se puede proceder
							if(Curso.calcularCantCursos(rutProf)!=0){
								// Si el sueldo no se encuentra pagado se puede proceder
								if (lormSueldo.getEstadoPago()==0){
									// El estado de pago cambia a pagado (1)
									lormSueldo.setEstadoPago(1);
									// Se asigna el jefe de administracion quien paga el sueldo
									lormSueldo.setJefeadministracion(lormJefeAdm);
									// Se guarda el sueldo
									orm.SueldoDAO.save(lormSueldo);
									return "Sueldo pagado exitosamente";
								}
								return "El mes se encuentra pagado";
							}
							return "El profesor no tiene cursos";	
						}
						return "El profesor no existe";	
					} 
				return "El jefe de administracion no existe";
					

			} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				return null;
	}
	
	/**
	 * Metodo que permite obtener todos los sueldos de un profesor
	 * @param rutProf a quien se desea obtener los sueldos
	 * @return
	 */
	public static String[][] obtenerListSueldoProf(String rutProf) {
		try {
			//Condicion de busqueda del profesor (rut profesor)
			String queryProfesor = "persona.rut='" + rutProf + "'";
			//Variable que almacena el profesor con la condicion entregada
			orm.Profesor lormProfesor = orm.ProfesorDAO.loadProfesorByQuery(
					queryProfesor, null);
			// Si el profesor existe se puede proceder
			if(lormProfesor!=null){
			//Condicion de busqueda del sueldo (objeto profesor)
			String querySueldo = "profesor='" + lormProfesor+ "'";
			//Arreglo que almacena los sueldos del profesor con la condicion entregada
			orm.Sueldo[] ormSueldos = orm.SueldoDAO.listSueldoByQuery(querySueldo, null);
			//Obtenemos el largo del arreglo
			int length =/* Math.min(*/ormSueldos.length/*, ROW_COUNT)*/;
			//Entregamos a la matriz el largo de filas y columnas
			String datos[][] = new String[length][5];
			//Almacenamos todos los sueldos
			for (int i = 0; i < length; i++) {
				datos[i][0]=ormSueldos[i].getProfesor().getPersona().getNombre()+" "+ormSueldos[i].getProfesor().getPersona().getApellido();
				datos[i][1]=""+ormSueldos[i].getMes();
				datos[i][2]=""+ormSueldos[i].getCantCursos();
				datos[i][3]=""+ormSueldos[i].getMonto();
				datos[i][4]=""+ormSueldos[i].getEstadoPago();
			}
			//Retornamos los sueldos en la matriz
			return datos;
			}
			return null;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo que permite actualizar los atributos de los sueldos de un profesor
	 * @param profesor
	 */
	public static void actualizarSueldos(orm.Profesor profesor){
		try {
			// Condicion de busqueda de sueldoprofesor (id profesor)
			String querySueldo = "profesor.id='" + profesor.getId() + "'";
			// Arreglo que almacena los sueldoprofesor con la condicion entregada
			orm.Sueldo[] ormSueldos;
			ormSueldos = orm.SueldoDAO.listSueldoByQuery(querySueldo, null);
			// Lo siguiente permite actualizar la cantidad de cursos y monto de los 10 sueldos del profesor
			// Obtenemos el largo del arreglo
			int length = ormSueldos.length;
			// Obtenemos la cantidad de curso que tiene asignado el profesor
			int cant=Curso.calcularCantCursos(profesor.getPersona().getRut());
			// Bucle que recorre todos los sueldos del profesor
			for (int i = 0; i < length; i++) {
				// Si el sueldo no se encuentra pagado se puede proceder
				if(ormSueldos[i].getEstadoPago()==0){	
					// Si la cantidad de curso del profesor es distinta de cero
					if(cant!=0){
					// Se asigna la cantidad de curso
					ormSueldos[i].setCantCursos(cant);
					// Se asigna el monto que se debe pogar
					ormSueldos[i].setMonto(ormSueldos[i].getCantCursos()*100000);
					// Se guarda cada sueldo
					orm.SueldoDAO.save(ormSueldos[i]);
					}
				}	
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}