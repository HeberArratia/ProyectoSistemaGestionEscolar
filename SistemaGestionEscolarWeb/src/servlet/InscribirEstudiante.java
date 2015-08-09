package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioCursoProxy;

/**
 * Servlet implementation class InscribirEstudiante
 */
public class InscribirEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscribirEstudiante() {
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
		//Variable que almacena el resultado de la operacion
		String resultado = "";
		//Si el codigo del curso es un dato entero
		if (codigoCurso.matches("\\d*")){
			//Obtenemos los datos necesarios restantes
			String rutProfesor = request.getParameter("rutProfesor");
			String rutEstudiante = request.getParameter("rutEtudiante");
			//Convertimos el codigo del curso a entero
			int idCurso = Integer.parseInt(codigoCurso);
			//Requerimos el servicio que permite inscribir al estudiante
			ServicioCursoProxy curso = new ServicioCursoProxy();
			// Pasamos por parametro el codigo del curso, rut del estudiante y rut del profesor
			resultado = curso.incribirEstudiante(idCurso, rutEstudiante, rutProfesor);
		//En caso de que el codigo del curso no sea un dato entero imprimimos un mensaje
		} else {
			resultado = "Código de curso inválido";
		}	
		//Mensaje de confirmacion para el usuario
		request.setAttribute("mensajeinscribir",  "<div class='alert alert-info' role='alert'>"
				+ resultado + "</div>" );
		//Direccionamos al JSP correspondiente
		request.getRequestDispatcher("/InscribirEstudiante.jsp").forward(request, response);	
	}

}
