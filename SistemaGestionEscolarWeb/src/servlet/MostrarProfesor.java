package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioEstudianteProxy;
import servicio.ServicioProfesorProxy;

/**
 * Servlet implementation class MostrarProfesor
 */
public class MostrarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProfesor() {
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
		//Obtenemos el rut del profesor
		String rutProfesor = request.getParameter("rutProfesor");
		//Requerimos el servicio que permite buscar al profesor
		ServicioProfesorProxy profesor = new ServicioProfesorProxy();
		//Enviamos el rut del profesor y almacenamos respuesta en un arreglo
		String datos[] = profesor.buscarProfesor(rutProfesor);
		//Si el arreglo es distinto de nulo almacenamos sus datos para ser enviados al JSP
		if (datos!=null){
			request.setAttribute("respuesta", "aprobado");
			request.setAttribute("profesor", datos[0]);
			request.setAttribute("rut", datos[1]);
			request.setAttribute("cantidad", datos[2]);
		//Si el arreglo es numo enviamos mensaje de error
		} else {
			request.setAttribute("respuesta", "reprobado");
		}	
		//Direccionamos al JSP correspondiente
		request.getRequestDispatcher("/RegistrarSueldo.jsp").forward(request, response);
	}

}
