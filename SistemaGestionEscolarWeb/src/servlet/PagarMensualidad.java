package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioMatriculaProxy;
import servicio.ServicioMensualidadProxy;

/**
 * Servlet implementation class PagarMensualidad
 */
public class PagarMensualidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagarMensualidad() {
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
		//Obtenemos el mes en que se desea pagar mensualidad
		String mes = request.getParameter("mes");
		//Variable que almacena la respuesta del proceso
		String resultadoregistro = "";
		//Si el mes corresponde a un dato entero se puede proceder
		if (mes.matches("\\d*")){
			//Obtenemos el rut del estudiante
			String rutregistro = request.getParameter("rutregistro");
			//Convertimos el mes a entero
			int idmes = Integer.parseInt(mes);
			//Requerimos al servicio necesario y enviamos los parametros correspondientes
			ServicioMensualidadProxy mensualidad = new ServicioMensualidadProxy();
			//Almacenamos la respuesta del servicio
			resultadoregistro = mensualidad.registrarPagoMensualidad("183511203", rutregistro, idmes);
		//Si el mes no es un dato entero imprimimos un mensaje de error
		} else {
			resultadoregistro = "Mes inválido";
		}
		//Enviamos mensaje de respuesta al usuario
		request.setAttribute("resultadoregistro",  "<div class='alert alert-info' role='alert'>"
				+ resultadoregistro + "</div>" );
		//Direccionamos al JSP correspondiente
		request.getRequestDispatcher("/PagoMensualidad.jsp").forward(request, response);
	}

}
