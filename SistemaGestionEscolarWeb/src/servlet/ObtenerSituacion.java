package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioEstudianteProxy;

/**
 * Servlet implementation class ObtenerSituacion
 */
public class ObtenerSituacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerSituacion() {
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
		String rut = request.getParameter("rut");
		//Requerimos el servicio que permite obtener la situacion
		ServicioEstudianteProxy estudiante = new ServicioEstudianteProxy();
		//Enviamos el rut y alacenamos la respuesta en una variable
		String resultado = estudiante.obtenerSituacionEstudiante(rut);
		//Respuesta que se envia al usuario
		request.setAttribute("resultado",   resultado );
		//Direccionamos al JSP correspondiente
		request.getRequestDispatcher("/Situacion.jsp").forward(request, response);
	}

}
