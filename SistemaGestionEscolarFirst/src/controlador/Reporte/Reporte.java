package controlador.Reporte;

import org.orm.PersistentException;
/**
 * 
 * @author heberarratia
 *
 */
public class Reporte {
	
	/**
	 * Metodo que obtiene la suma de todas las mensualidades de los 10 meses
	 * @return
	 */
	public static int[] balanceMen(){
		// Arreglo donde se almacena el monto de cada mes
		int[] mes= new int[10];
		try {
			//Arreglo que alamacena toda la tabla Mensualidad
			orm.Mensualidad[] ormMensualidads = orm.MensualidadDAO.listMensualidadByQuery(null, null);
			//Obtenemos el largo del arreglo
			int length = ormMensualidads.length;
			//Recorremmos el arreglo
			for (int i = 0; i < length; i++) {
				// Se asigna a cada mes el monto correspondiente a todas las mensualidades de ese mes
				if(ormMensualidads[i].getMes()==1 ){
					mes[0]= mes[0]+ormMensualidads[i].getMonto();
				}if(ormMensualidads[i].getMes()==2){
					mes[1]= mes[1]+ormMensualidads[i].getMonto();
				}if(ormMensualidads[i].getMes()==3){
					mes[2]= mes[2]+ormMensualidads[i].getMonto();
				}if(ormMensualidads[i].getMes()==4){
					mes[3]= mes[3]+ormMensualidads[i].getMonto();
				}if(ormMensualidads[i].getMes()==5){
					mes[4]= mes[4]+ormMensualidads[i].getMonto();
				}if(ormMensualidads[i].getMes()==6){
					mes[5]= mes[5]+ormMensualidads[i].getMonto();
				}if(ormMensualidads[i].getMes()==7){
					mes[6]= mes[6]+ormMensualidads[i].getMonto();
				}if(ormMensualidads[i].getMes()==8){
					mes[7]= mes[7]+ormMensualidads[i].getMonto();
				}if(ormMensualidads[i].getMes()==9){
					mes[8]= mes[8]+ormMensualidads[i].getMonto();
				}if(ormMensualidads[i].getMes()==10){
					mes[9]= mes[9]+ormMensualidads[i].getMonto();
				}			
			}			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Retornamos el arreglo
		return mes;
		
		
	}
	
	/**
	 * Metodo que obtiene la suma de todos los pagos de matricula 
	 * @return
	 */
	public static int balanceMat(){
		// Variable que almacena el total (suma de todos los pagos de matricula)
		int totalM=0;
		try {
			// Arreglo que almacena todas las matriculas
			orm.Matricula[] ormMatriculas = orm.MatriculaDAO.listMatriculaByQuery(null, null);
			//Almacenamos el largo del arreglo
			int length = ormMatriculas.length;
			for (int i = 0; i < length; i++) {
				// Si la matricula se encuentra pagada se suma su monto
				if(ormMatriculas[i].getEstadoMatricula()==1){
					totalM= totalM+ormMatriculas[i].getMonto();
				}
			}
				
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Retornamos el total
		return totalM;	
	}
	
	/**
	 * Metodo que obtiene la suma de todos los sueldos de los 10 meses
	 * @return
	 */
	public static int[] balanceSueldo() {
		// Arreglo donde se almacena el monto de cada mes
		int[] mes = new int[10];
		try {
			//Arreglo que alamacena toda la tabla Sueldo
			orm.Sueldo[] ormSueldos = orm.SueldoDAO.listSueldoByQuery(null, null);
			//Obtenemos el largo del arreglo
			int length =ormSueldos.length;
			for (int i = 0; i < length; i++) {
				// Se asigna a cada mes el monto correspondiente a todos los sueldos encontrados en ese mes
				if (ormSueldos[i].getMes() == 1) {
					mes[0] = mes[0] + ormSueldos[i].getMonto();
				}
				if (ormSueldos[i].getMes() == 2) {
					mes[1] = mes[1] + ormSueldos[i].getMonto();
				}
				if (ormSueldos[i].getMes() == 3) {
					mes[2] = mes[2] + ormSueldos[i].getMonto();
				}
				if (ormSueldos[i].getMes() == 4) {
					mes[3] = mes[3] + ormSueldos[i].getMonto();
				}
				if (ormSueldos[i].getMes() == 5) {
					mes[4] = mes[4] + ormSueldos[i].getMonto();
				}
				if (ormSueldos[i].getMes() == 6) {
					mes[5] = mes[5] + ormSueldos[i].getMonto();
				}
				if (ormSueldos[i].getMes() == 7) {
					mes[6] = mes[6] + ormSueldos[i].getMonto();
				}
				if (ormSueldos[i].getMes() == 8) {
					mes[7] = mes[7] + ormSueldos[i].getMonto();
				}
				if (ormSueldos[i].getMes() == 9) {
					mes[8] = mes[8] + ormSueldos[i].getMonto();
				}
				if (ormSueldos[i].getMes() == 10) {
					mes[9] = mes[9] + ormSueldos[i].getMonto();
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Se retorna el arreglo
		return mes;

	}
	
	/**
	 * Metodo que permite obtener el balance ingreso y gasto en 10 meses
	 * @return
	 */
	public static String[][] obtenerBalanceIngGasto() {
		//Obtenemos los sueldos
		int[] balanceS=balanceSueldo();
		//Obtenemos las mensualidades
		int[] balanceM=balanceMen();
		//Obtenemos el total de matriculas
		int totalM=balanceMat();
		//Matriz que va a almacenar el ingreso/gasto/balance
		String[][] matrizBalance= new String[10][3];
		for (int i = 0; i < matrizBalance.length; i++) {  //número de filas
		     for (int j = 0; j < matrizBalance[i].length; j++) { //número de columnas de cada fila
		         // Guardamos los ingresos (Mensualidades + matriculas)
		    	 int suma= balanceM[i]+totalM;
		    	 // Asignamos los ingresos a la matriz
		    	 matrizBalance[i][0]=""+(suma);
		    	 // Asignamos los gatos a la matriz (sueldo)
		         matrizBalance[i][1]=""+(balanceS[i]+0);
		         //Asisgnamos el balance (ingreso - gastos)
		         matrizBalance[i][2]=""+(suma-balanceS[i]);
		            
		     }
		     totalM=0;
		    // System.out.println(matrizBalance[i][0]+" y "+matrizBalance[i][1] +" y "+matrizBalance[i][2]);
		}
		//Retornamos la matriz
		return matrizBalance;
		
	}
	
}