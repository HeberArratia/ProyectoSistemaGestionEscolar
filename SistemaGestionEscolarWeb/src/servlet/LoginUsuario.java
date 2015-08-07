package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import servicio.ServicioPersonaProxy;

/**
 * Servlet implementation class LoginUsuario
 */
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsuario() {
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
		String rut = request.getParameter("rut");
		String pass = request.getParameter("pass");
		ServicioPersonaProxy persona = new ServicioPersonaProxy();
		String perfil = persona.login(rut, pass);
		switch (perfil) {
		case "Director":
			request.getRequestDispatcher("/HomeDirector.jsp").forward(request, response);
			break;
		case "JafeAdm":
			request.getRequestDispatcher("/HomeJefeAdm.jsp").forward(request, response);
			break;
		case "Secretaria":
			request.getRequestDispatcher("/HomeSecretaria.jsp").forward(request, response);
			break;
		case "Apoderado":
			request.getRequestDispatcher("/Apoderado.jsp").forward(request, response);
			break;
		case "Estudiante":
			request.getRequestDispatcher("/Estudiante.jsp").forward(request, response);
			break;
		case "Profesor":
			request.getRequestDispatcher("/HomeProfesor.jsp").forward(request, response);
			break;
		default:
			String mensaje = "Usuario o contraseña inválido";
			request.setAttribute("mensajeerror",  mensaje);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		}
	}

}
