package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioMatriculaProxy;
import servicio.ServicioSueldoProxy;

/**
 * Servlet implementation class PagarSueldo
 */
public class PagarSueldo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagarSueldo() {
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
		//Obtenemos el mes en que se desea pagar el sueldo
		String mes = request.getParameter("mes");
		//Variable que almacena la respuesta del proceso
		String resultadoregistro = "";
		//Si el mes corresponde a un dato entero se puede procedor
		if (mes.matches("\\d*")){
				//Obtenemos el rut del profesor
				String rutregistro = request.getParameter("rutregistro");
				//Convertimos el mes a entero
				int idmes = Integer.parseInt(mes);
				//Requerimos el servicio que permite pagar el sueldo
				ServicioSueldoProxy sueldo = new ServicioSueldoProxy();
				//Enviamos los parametros correspondientes y almacenamos la respuesta del servicio
				resultadoregistro = sueldo.registrarSueldo(rutregistro, "96356453", idmes);
		//Si el mes no es entero almacena mensaje de rror
		} else {
			resultadoregistro = "Mes inválido";
		}
		//Enviamos mensaje de confirmacion del proceso al usuario
		request.setAttribute("resultadoregistro",  "<div class='alert alert-info' role='alert'>"
				+ resultadoregistro + "</div>" );
		//Direccionamos al JSP correspondiente
		request.getRequestDispatcher("/RegistrarSueldo.jsp").forward(request, response);
	}

}
