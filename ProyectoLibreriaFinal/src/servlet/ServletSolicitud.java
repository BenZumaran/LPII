package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.getRequestDispatcher("").forward( request, response);					
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dataSolicitud", service.listarSolicitud());		
		request.getRequestDispatcher("").forward( request, response);					
	}
	
	private void filtrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomFiltro = request.getParameter("nom_filro"), detFiltro = request.getParameter("det_filtro");		
		request.setAttribute("dataSolicitud", service.filtrarSolicitud(nomFiltro, detFiltro));		
		request.getRequestDispatcher("").forward( request, response);					
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numSolicitud = Integer.parseInt(request.getParameter("numero"));
		String estadoSolicitud = request.getParameter("estado_soli");
		request.setAttribute("dataSolicitud", service.cambiarEstadoSolicitud(estadoSolicitud, numSolicitud));		
		request.getRequestDispatcher("").forward( request, response);					
	}
	

}
