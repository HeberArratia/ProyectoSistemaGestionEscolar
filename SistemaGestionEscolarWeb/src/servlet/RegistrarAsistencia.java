package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioProfesorProxy;

/**
 * Servlet implementation class RegistrarAsistencia
 */
public class RegistrarAsistencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarAsistencia() {
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
		//Obtenemos el codigo del curso
		String codigoCurso = request.getParameter("codigoCurso");
		//Variable que almacena la respuesta que se envia al usuario
		String resultado = "";
		//Si el codigo del curso es un dato entero se puede proceder
		if (codigoCurso.matches("\\d*")){
			//Convertimos el codigo del curso a entero
			int idCurso = Integer.parseInt(codigoCurso);
			//Obtenemos el resto de parametros necesarios
			String rutProfesor = request.getParameter("rutProfesor");
			String rutEstudiante= request.getParameter("rutEstudiante");
			String asistencia = request.getParameter("asistencia");
			//Requerimos el servicio que permite registrar la asistencia
			ServicioProfesorProxy profesor = new ServicioProfesorProxy();
			//Enviamos los parametros y almacenamos el resultado del servicio
			resultado = profesor.registrarAsistencia(rutEstudiante, idCurso, asistencia, rutProfesor);
		//Si el codigo del curso no es un dato entero enviaremos un error
		} else {
			resultado = "Código de curso inválido";
		}
		//Respuesta que se envia al usuario
		request.setAttribute("mensaje",  "<div class='alert alert-info' role='alert'>"
				+ resultado + "</div>" );
		//Direccionamos al JSP correspondiente
		request.getRequestDispatcher("/RegistrarAsistencias.jsp").forward(request, response);
	}

}
