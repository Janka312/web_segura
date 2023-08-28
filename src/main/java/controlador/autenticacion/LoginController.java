package controlador.autenticacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.entidades.Usuario;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.ruteador(request, response);
	}
	
	private void ruteador (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = (request.getParameter("ruta") == null) ? "inicio" : request.getParameter("ruta");
		
		switch(ruta) {
		case "inicio":
			this.inicio(request, response);
			break;
		case "ingresar":
			this.ingresar(request, response);
			break;
		case "salir":
			this.salir(request, response);
			break;
		default:
			break;
		}
	}
	
	private void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		// 1.- Obtener datos que me envian en la solicitudo

		// 2.- Llamo al modelo para obtener datos

		// 3.- Llamo a la vista
		response.sendRedirect("jsp/login.jsp");
	}
	
	private void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
		request.getSession().invalidate();
		response.sendRedirect("jsp/login.jsp");
		
	}
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		    String nombre = request.getParameter("usuario");
		    String password = request.getParameter("password");

		    Usuario usuarioAutenticado = modelo.dao.DAOFactory.getFactory().getUsuarioDAO().autorizar(nombre, password);

		    if (usuarioAutenticado != null) {
		        HttpSession session = request.getSession();
		        session.setAttribute("usuarioLogeado", usuarioAutenticado);

		        response.sendRedirect("VisualizarDashboardController?ruta=visualizar");
		        
		    } else {
		    	String mensaje = "Usuario o clave incorrectas";
		        request.setAttribute("mensajeError", mensaje); 
		        request.getRequestDispatcher("jsp/login.jsp").forward(request, response); 
		    }
	}
		
	}


