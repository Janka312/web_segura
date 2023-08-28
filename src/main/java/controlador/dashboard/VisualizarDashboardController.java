package controlador.dashboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;
import modelo.entidades.TipoCuenta;
import modelo.entidades.Usuario;

@WebServlet("/VisualizarDashboardController")
public class VisualizarDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizarDashboardController() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ruta = (request.getParameter("ruta") == null) ? "visualizar" : request.getParameter("ruta");

		switch (ruta) {
		case "visualizar":
			this.visualizar(request, response);
			break;
		case "visualizarDashboardPorMes":
			this.visualizarDashboardPorMes(request, response);
			break;
		default:
			break;
		}
	}

	private void visualizarDashboardPorMes(HttpServletRequest request, HttpServletResponse response) {
		try {
	        // Obtener datos que me env�an en la solicitud
	        HttpSession session = request.getSession();
	        Usuario usuarioAutenticado = (Usuario) session.getAttribute("usuarioLogeado");
	        int mesSeleccionado = Integer.parseInt(request.getParameter("mesSeleccionado"));

	        // Llamar al modelo para obtener datos
	        List<Cuenta> listaCuentas = modelo.dao.DAOFactory.getFactory().getCuentaDAO().getCuentasByPropietario(usuarioAutenticado);
	        request.setAttribute("listaCuentas", listaCuentas);

	        // Calcular el montoMovido para cada cuenta y establecerlo en la entidad por mes seleccionado
	        for (Cuenta cuenta : listaCuentas) {
	            List<Movimiento> movimientos = modelo.dao.DAOFactory.getFactory().getMovimientoDAO().getMovimientosByCuentaAndMonth(cuenta, mesSeleccionado);

	            float montoMovidoIngreso = 0;
	            float montoMovidoGasto = 0;

	            for (Movimiento movimiento : movimientos) {
	                if (movimiento.getCuentaOrigen().getTipoCuenta() == TipoCuenta.SOLO_INGRESO) {
	                    montoMovidoIngreso += movimiento.getMonto();
	                } else if (movimiento.getCuentaDestino().getTipoCuenta() == TipoCuenta.SOLO_GASTO) {
	                    montoMovidoGasto += movimiento.getMonto();
	                }
	            }

	            cuenta.setMontoMovidoIngreso(montoMovidoIngreso);
	            cuenta.setMontoMovidoGasto(montoMovidoGasto);
	        }

	        // Llamar a la vista
	        request.getRequestDispatcher("jsp/dashboard.jsp").forward(request, response);
	    } catch (IOException | ServletException e) {
	        // Manejar las excepciones de entrada/salida y servlet
	        e.printStackTrace();
	    }
		
	}

	private void visualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.- Obtener datos que me envian en la solicitudo
		HttpSession session = request.getSession();
	    Usuario usuarioAutenticado = (Usuario) session.getAttribute("usuarioLogeado");

		// 2.- Llamo al modelo para obtener datos
		
		List<Cuenta> listaCuentas = modelo.dao.DAOFactory.getFactory().getCuentaDAO().getCuentasByPropietario(usuarioAutenticado);
		request.setAttribute("listaCuentas", listaCuentas);
		
		// 3. Calcular el montoMovido para cada cuenta y establecerlo en la entidad
	    for (Cuenta cuenta : listaCuentas) {
	        modelo.dao.DAOFactory.getFactory().getCuentaDAO().calcularYActualizarMontoMovido(cuenta);
	    }

		// 3.- Llamo a la vista
		request.getRequestDispatcher("jsp/dashboard.jsp").forward(request, response);
	}

}
