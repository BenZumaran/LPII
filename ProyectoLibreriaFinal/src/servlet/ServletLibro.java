package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LibroDTO;
import service.LibroService;

/**
 * Servlet implementation class ServletLibro
 */
@WebServlet("/ServletLibro")
public class ServletLibro extends HttpServlet {
	LibroService service = new LibroService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLibro() {
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
		else if (tipo.equals("ingresar")) {
			ingresar(request, response);
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Boolean.parseBoolean((String)request.getParameter("actualizar"))) {
			String codLibro= request.getParameter("codigo");					
			request.setAttribute("dataLibro", service.buscarLibro(codLibro));					
		} 
		
		request.setAttribute("dataGeneroLibro", service.listarDataGenero());	
		request.setAttribute("actualizar", request.getParameter("actualizar"));		
		request.getRequestDispatcher("actualizarLibros.jsp").forward( request, response);		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dataLibro", service.listarLibro());		
		request.setAttribute("dataGeneroLibro", service.listarDataGenero());
		request.getRequestDispatcher("consultaLibro.jsp").forward( request, response);					
	}
	
	private void filtrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomFiltro = request.getParameter("nom_filtro"), detFiltro = request.getParameter("det_filtro");
		request.setAttribute("dataLibro", service.filtrarLibro(nomFiltro, detFiltro));		
		request.getRequestDispatcher("").forward( request, response);					
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codLibro = request.getParameter("codigo_libro");
		String descLibro = request.getParameter("desc_libro");
		int anioLibro = Integer.parseInt(request.getParameter("anio_libro"));
		String codGenero = request.getParameter("cbo_genero");
		String autorLibro = request.getParameter("autor_libro");
		String estadoLibro = request.getParameter("cbo_estado");
		
		LibroDTO libro = new LibroDTO();
		libro.setCodLibro(codLibro);
		libro.setDescLibro(descLibro);
		libro.setAnioLibro(anioLibro);
		libro.setCodGenero(codGenero);
		libro.setAutorLibro(autorLibro);
		libro.setEstadoLibro(estadoLibro);
		
		service.actualizarLibro(libro);
		listar(request, response);
				
	}
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codLibro = request.getParameter("codigo_libro");
		String descLibro = request.getParameter("desc_libro");
		int anioLibro = Integer.parseInt(request.getParameter("anio_libro"));
		String codGenero = request.getParameter("cbo_genero");
		String autorLibro = request.getParameter("autor_libro");
		String estadoLibro = request.getParameter("cbo_estado");
		
		LibroDTO libro = new LibroDTO();
		libro.setCodLibro(codLibro);
		libro.setDescLibro(descLibro);
		libro.setAnioLibro(anioLibro);
		libro.setCodGenero(codGenero);
		libro.setAutorLibro(autorLibro);
		libro.setEstadoLibro(estadoLibro);
		
		request.setAttribute("dataLibro", service.ingresarLibro(libro));	
		request.setAttribute("actualizar", request.getParameter("actualizar"));
		
		listar(request, response);			
	}
	

}
