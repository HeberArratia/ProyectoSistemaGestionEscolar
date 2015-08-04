package controlador.Finanza;

import org.orm.PersistentException;

import controlador.Academico.Curso;

public class Sueldo {
	private static final int ROW_COUNT = 100;

	private int monto;
	private int mes;
	private int cantCursos;
	private int estadoPsgo;

	public void obtenerListSueldoProf() {
		// TODO - implement Sueldo.obtenerListSueldoProf
		throw new UnsupportedOperationException();
	}

	public static String registrarSueldoProf(String rutProf, String rutAdm, int mes) {
		// se valida si el mes es correcto
				if (mes < 1 || mes > 10) {
					return "mes invalido";
				}
				try {
					// creacion de condicion de busqueda
					String condicionAdmin = "persona.rut='" + rutAdm + "'";
					orm.Jefeadministracion lormJefeAdm = orm.JefeadministracionDAO.loadJefeadministracionByQuery(condicionAdmin, null);
					// si existe el jefe de administracion
					if (lormJefeAdm != null) {
						//se crea una condicion de busqueda del profesor ingresando el rut
						String rutProfesor = "persona.rut='" + rutProf + "'";
						orm.Profesor lormProfesor = orm.ProfesorDAO.loadProfesorByQuery(rutProfesor, null);
						// si el profesor existe
						if (lormProfesor != null) {
							System.out.println("hola1");
							// se crea la condicion de busqueda que tiene el id del profesor y el mes de pago
							String condicionprof = "profesor.id='" + lormProfesor.getId() + "'"+ " and mes='"+mes+"'";
							orm.Sueldo lormSueldo = orm.SueldoDAO.loadSueldoByQuery(condicionprof, null);
							//orm.Sueldo_profesor lormSueldo_profesor = orm.Sueldo_profesorDAO.loadSueldo_profesorByQuery(condicionprof, null);
							System.out.println("Nombre: " + lormSueldo.getProfesor().getPersona().getNombre() + "mes: " + lormSueldo.getMes());
							if(Curso.calcularCantCursos(rutProf)!=0){
								 
								if (lormSueldo.getEstadoPago()==0){
									lormSueldo.setEstadoPago(1);
									lormSueldo.setJefeadministracion(lormJefeAdm);
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

	public void consSueldoProf() {
		
	}

}