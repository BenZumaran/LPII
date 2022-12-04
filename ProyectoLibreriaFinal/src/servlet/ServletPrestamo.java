package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.PrestamoDTO;
import service.PrestamoService;

/**
 * Servlet implementation class ServletPrestamo
 */
@WebServlet("/ServletPrestamo")
public class ServletPrestamo extends HttpServlet {
	PrestamoService service = new PrestamoService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrestamo() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("rqst");
		if (tipo.equals("buscar")) {
			buscar(request, response);
		}
		else if (tipo.equals("listar")) {
			listar(request, response);
		}
		else if (tipo.equals("filtrar")) {
			filtrar(request, response);
		}
		else if (tipo.equals("actualizar")) {
			actualizar(request, response);
		}
		else if (tipo.equals("devolucion")) {
			devolucion(request, response);
		}
		else if (tipo.equals("ingresar")) {
			ingresar(request, response);
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  numPrestamo= Integer.parseInt(request.getParameter("numero"));		
		request.setAttribute("dataRecibo", service.buscarPrestamo(numPrestamo));		
		request.getRequestDispatcher("").forward( request, response);					
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dataPrestamo", service.listarPrestamo());		
		request.getRequestDispatcher("reportePrestamo.jsp").forward( request, response);					
	}
	
	private void filtrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomFiltro = request.getParameter("nomfilro"),detalleFiltro = request.getParameter("txtUsuario");
		if(detalleFiltro.equals(""))listar(request, response);
		request.setAttribute("dataPrestamo", service.filtrarPrestamo(nomFiltro, detalleFiltro));		
		request.getRequestDispatcher("reportePrestamo.jsp").forward( request, response);					
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numPrestamo= Integer.parseInt(request.getParameter("numero_prestamo"));
		String estado = request.getParameter("est_pres");		
		
		request.setAttribute("dataPrestamo", service.actualizarPrestamoEstado(estado, numPrestamo));		
		request.getRequestDispatcher("").forward( request, response);					
	}	
	
	private void devolucion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numPrestamo= Integer.parseInt(request.getParameter("numero_prestamo"));
		String codLibro = request.getParameter("cod_libro");		
		boolean deuda = Double.parseDouble(request.getParameter("importe_reci"))>0;
		request.setAttribute("dataPrestamo", service.devolucionLibro(codLibro, numPrestamo, deuda));		
		request.getRequestDispatcher("").forward( request, response);					
	}	
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numPrestamo = Integer.parseInt(request.getParameter("numero_prestamo"));
		String codUsuario= request.getParameter("cod_usu");
		int numSolicitud= Integer.parseInt(request.getParameter("numero_solicitud"));
		double deudaPrestamo= Double.parseDouble(request.getParameter("deuda_prestamo"));
		String estadoPrestamo = request.getParameter("est_prestamo");
		
		PrestamoDTO prestamo = new PrestamoDTO();
		
		prestamo.setNumPrestamo(numPrestamo);
		prestamo.setCodUsuario(codUsuario);
		prestamo.setNumSolicitud(numSolicitud);;
		prestamo.setDeudaPrestamo(deudaPrestamo);
		prestamo.setEstadoPrestamo(estadoPrestamo);
		
		request.setAttribute("dataRecibo", service.crearNuevoPrestamo(prestamo));		
		request.getRequestDispatcher("").forward( request, response);					
	}	
	
}
