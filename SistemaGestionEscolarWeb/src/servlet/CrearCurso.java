package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioCursoProxy;

/**
 * Servlet implementation class CrearCurso
 */
public class CrearCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearCurso() {
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
		//Obtenemos el nombre del curso a crear
		String nombreCurso = request.getParameter("nombre");
		////Servicio que permite crear un curso
		ServicioCursoProxy curso = new ServicioCursoProxy();
		//Enviamos el parametro (nombre del curso) y rut de la secretaria que crea el curso
		String resultado = curso.crearCurso(nombreCurso, "96356453");
		//Mensaje de respuesta al usuario
		request.setAttribute("mensajecrearcurso",  "<div class='alert alert-info' role='alert'>"
				+ resultado + "</div>" );
		//Direccionamos al JSP correspondiente
		request.getRequestDispatcher("/CrearCurso.jsp").forward(request, response);
	}

}
