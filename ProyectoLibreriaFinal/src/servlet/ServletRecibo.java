package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReciboDTO;
import service.ReciboService;

/**
 * Servlet implementation class ServletRecibo
 */
@WebServlet("/ServletRecibo")
public class ServletRecibo extends HttpServlet {
	ReciboService service = new ReciboService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRecibo() {
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
		else if (tipo.equals("ingresar")) {
			ingresar(request, response);
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  numRecibo = Integer.parseInt(request.getParameter("numero"));		
		request.setAttribute("dataRecibo", service.buscarRecibo(numRecibo));		
		request.getRequestDispatcher("").forward( request, response);					
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dataRecibo", service.listarRecibo());		
		request.getRequestDispatcher("").forward( request, response);					
	}
	
	private void filtrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomFiltro = request.getParameter("nom_filtro"),detFiltro = request.getParameter("det_filtro");
		request.setAttribute("dataRecibo", service.filtrarRecibo(nomFiltro, detFiltro));		
		request.getRequestDispatcher("").forward( request, response);					
	}
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numRecibo = Integer.parseInt(request.getParameter("numero"));
		int numPrestamo = Integer.parseInt(request.getParameter("num_pres"));
		double importeRecibo= Integer.parseInt(request.getParameter("importe_reci"));
		String codUsuarioCobranza = request.getParameter("cod_usu_cobra");
		String fechaRecibo = request.getParameter("cod_fec_reci");
		String codigoDocumento = request.getParameter("cod_documento");
		String numDocRecibo = request.getParameter("num_doc_reci");
		
		ReciboDTO recibo = new ReciboDTO();
		recibo.setNumRecibo(numRecibo);
		recibo.setNumPrestamo(numPrestamo);
		recibo.setImporteRecibo(importeRecibo);
		recibo.setCodUsuarioCobranza(codUsuarioCobranza);
		recibo.setFechaRecibo(fechaRecibo);
		recibo.setCodigoDocumento(codigoDocumento);
		recibo.setNumDocRecibo(numDocRecibo);
		
		request.setAttribute("dataRecibo", service.ingresarRecibo(recibo));		
		request.getRequestDispatcher("").forward( request, response);					
	}	
}
