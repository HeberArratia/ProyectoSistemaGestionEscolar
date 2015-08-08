package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioCursoProxy;

/**
 * Servlet implementation class AsignarProfesor
 */
public class AsignarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignarProfesor() {
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
		//Obtenemos el código del curso
		String codigoCurso = request.getParameter("codigocurso"); 
		//Variable utilizado para entregar mensaje confirmacion de la operacion
		String resultado = "";
		//Verificamos que el codigo del curso sea un dato entero
		if (codigoCurso.matches("\\d*")){
			//Convertimos el codigo del curso a entero
			int idCurso = Integer.parseInt(codigoCurso);
			//Obtenemos otros datos necearios
			String nombreCurso = request.getParameter("nombrecurso");
			String rutProfesor = request.getParameter("rutprofesor");
			//Servicio que permite asignar profesor
			ServicioCursoProxy curso = new ServicioCursoProxy();
			//Enviamos los parametros
			resultado = curso.asignarProfesor(idCurso, nombreCurso, rutProfesor, "96356453");
		// Si el codigo del curso no es un dato entero enviamos un mensaje
		} else {
			resultado = "Código de curso inválido";
		}
		// Mensaje de confirmacion 
		request.setAttribute("mensajeasignarprofesor",  "<div class='alert alert-info' role='alert'>"
				+ resultado + "</div>" );
		// Direccionamos el usuario al jsp correspondiente
		request.getRequestDispatcher("/CrearCurso.jsp").forward(request, response);
	}

}
