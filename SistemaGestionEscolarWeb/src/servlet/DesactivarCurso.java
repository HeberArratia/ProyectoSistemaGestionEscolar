package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicio.ServicioCursoProxy;

/**
 * Servlet implementation class DesactivarCurso
 */
public class DesactivarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesactivarCurso() {
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
		//Variable que almacena la respuesta de cada operacion
		String resultado = "";
		//Verificamos que el codigo del curso sea un entero
		if (codigoCurso.matches("\\d*")){
			// Convertimos el codigo del curso a entero
			int idCurso = Integer.parseInt(codigoCurso);
			// Requerimos el servicio que permite desactivar el curso
			ServicioCursoProxy curso = new ServicioCursoProxy();
			// Enviamos el codigo del curso y el rut de quien desactiva el curso
			resultado = curso.desactivarCurso(idCurso, "52347653");
		//Si el codigo del curso no es un entero imprimimos un mensaje 
		} else {
			resultado = "Código de curso inválido";
		}
		//Mensaje de respues al usuario
		request.setAttribute("mensajeDesactivar",  "<div class='alert alert-info' role='alert'>"
				+ resultado + "</div>" );
		//Direccionamos al JSP correspondiente
		request.getRequestDispatcher("/DesactivarCurso.jsp").forward(request, response);
	}

}
