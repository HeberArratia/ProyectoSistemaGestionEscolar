package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioCursoProxy;
import servicio.ServicioEstudianteProxy;

/**
 * Servlet implementation class MostrarEstudiante
 */
public class MostrarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtenemos el rut del estudiante
		String rutEstudiante = request.getParameter("rutEstudiante");
		//Obtenemos parametro que nos indica a que JSP debemos direccionar
		String direccion = request.getParameter("direccion");
		//Requerimos el servicio que permite buscar al estudiante en la db
		ServicioEstudianteProxy estudiante = new ServicioEstudianteProxy();
		//Enviamos el rut del estudiante y almacenamos respuesta del servicio en un arreglo
		String datos[] = estudiante.buscarEstudiante(rutEstudiante);
		//Si el arreglo es distinto de numo procemos a guardar los datos para enviarlos al JSP
		if (datos!=null){
			request.setAttribute("respuesta", "aprobado");
			request.setAttribute("estudiante", datos[0]);
			request.setAttribute("rut", datos[1]);
			request.setAttribute("estadomatricula", datos[2]);
			request.setAttribute("apoderado", datos[3]);
		//Si el arreglo es nulo entonces enviamos mensaje "reprobado"
		} else {
			request.setAttribute("respuesta", "reprobado");
		}
		//Si direccion corresponde a matricula direccionamos a jsp correspondiente
		if (direccion.equals("matricula")){
		request.getRequestDispatcher("/PagoMatricula.jsp").forward(request, response);
		//Si direccion corresponde a mensualidad direccionamos a jsp correspondiente
		} else if (direccion.equals("mensualidad")){
			request.getRequestDispatcher("/PagoMensualidad.jsp").forward(request, response);
		}	
	}

}
