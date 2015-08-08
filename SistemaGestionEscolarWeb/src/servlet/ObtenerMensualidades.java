package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioMensualidad;
import servicio.ServicioMensualidadProxy;
import servicio.ServicioSueldoProxy;

/**
 * Servlet implementation class ObtenerMensualidades
 */
public class ObtenerMensualidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerMensualidades() {
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
		//Obtenemos el mes en que se va a realizar el pago
		String mes = request.getParameter("mes"); 
		//Si el mes es un dato entero se puede proceder
		if (mes.matches("\\d*")){
			//Convertimos el mes a entero
			int intmes = Integer.parseInt(mes);
			//Requerimos el servicio que permite obtener obtener mosorosos en mensualidad
			ServicioMensualidadProxy mensualidad = new ServicioMensualidadProxy();
			//Enviamos el mes y almacenamos respuesta del servicio en una variable
			String respuesta = mensualidad.obtenerMorososMensualidad(intmes);
			//Si la respuesta es distinta de nulo la enviamos al JSP
			if(respuesta!=null){
				request.setAttribute("json", respuesta);
			//Si la respuesta es igual a numo enviamos un mensaje de error	
			} else {
				request.setAttribute("json", "Error, intente nuevamente");
			}
		//Si el mes no es un dato enetero enviamos mensaje de error
		} else{
			request.setAttribute("json", "Error, intente nuevamente");
		}	
		//Direccionamos al JSP correspondiente
	    request.getRequestDispatcher("ObtenerMorososMensualidad.jsp").forward(request, response); 
	}
	

}
