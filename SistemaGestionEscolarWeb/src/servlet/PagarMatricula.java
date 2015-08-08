package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioMatriculaProxy;

/**
 * Servlet implementation class PagarMatricula
 */
public class PagarMatricula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagarMatricula() {
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
		String rutregistro = request.getParameter("rutregistro");
		//Requerimos el servicio necesario
		ServicioMatriculaProxy matricula = new ServicioMatriculaProxy();
		//Enviamos los parametros correspondientes y obtenemos la respuesta
		String resultadoregistro = matricula.pagarMatricula(rutregistro, "183511203");
		//Enviamos la respuesta al usuario
		request.setAttribute("resultadoregistro",  "<div class='alert alert-info' role='alert'>"
				+ resultadoregistro + "</div>" );
		//Direccionamos al JSP correspondiente
		request.getRequestDispatcher("/PagoMatricula.jsp").forward(request, response);
	}

}
