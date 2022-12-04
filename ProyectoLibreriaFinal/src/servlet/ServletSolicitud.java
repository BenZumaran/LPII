package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SolicitudService;

/**
 * Servlet implementation class ServletSolicitud
 */
@WebServlet("/ServletSolicitud")
public class ServletSolicitud extends HttpServlet {
	SolicitudService service = new SolicitudService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSolicitud() {
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
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  numSolicitud = Integer.parseInt(request.getParameter("numero"));		
		request.setAttribute("dataSolicitud", service.buscarSolicitud(numSolicitud));		
		request.getRequestDispatcher("actualizarSolicitud.jsp").forward( request, response);					
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dataSolicitud", service.listarSolicitud());		
		request.getRequestDispatcher("reporteSolicitudPrestamo.jsp").forward( request, response);					
	}
	
	private void filtrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomFiltro = request.getParameter("nomfilro");
		String detFiltro = request.getParameter("cbo_estado");		
		if(detFiltro.equals("listar"))listar(request, response);
		request.setAttribute("dataSolicitud", service.filtrarSolicitud(nomFiltro, detFiltro));		
		request.getRequestDispatcher("reporteSolicitudPrestamo.jsp").forward( request, response);					
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int numSolicitud = Integer.parseInt(request.getParameter("num_soli"));
		String estadoSolicitud = request.getParameter("cbo_estado"), codUsuAprobador = (String) session.getAttribute("nom_usu");			
		
		
		request.setAttribute("dataSolicitud", service.cambiarEstadoSolicitud(estadoSolicitud, numSolicitud, codUsuAprobador));		
		listar(request, response);				
	}
	

}
