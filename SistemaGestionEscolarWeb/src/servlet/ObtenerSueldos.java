package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import servicio.ServicioSueldoProxy;

/**
 * Servlet implementation class ObtenerSueldos
 */
public class ObtenerSueldos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerSueldos() {
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
		String rut = request.getParameter("rutprofesor");
		//Requerimos el servicio que permite obtener los sueldos del profesor
		ServicioSueldoProxy sueldo = new ServicioSueldoProxy();
		//Enviamos el rut y almacenamos la respuesta del metodo
		String respuesta = sueldo.obtenerSueldos(rut);
		//Si la respuesta es distinta de nulo
		if(respuesta!=null){
			//Enviamos la respuesta al jsp
			request.setAttribute("json", respuesta);
		//Si la respuesta es nula enviamos mensaje de error	
		} else {
			request.setAttribute("json", "No existe el profesor");
		}
		//Direccionamos al JSP correspondiente
	    request.getRequestDispatcher("ConocerPagosProfesores.jsp").forward(request, response); 
	}

}
