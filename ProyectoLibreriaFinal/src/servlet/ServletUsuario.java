package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsuarioDTO;
import service.UsuarioService;

/**
 * Servlet implementation class SevletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	UsuarioService service = new UsuarioService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("rqst");
		if (tipo.equals("ingresar")) {
			ingresar(request, response);
		}
		else if (tipo.equals("buscar")) {
			buscar(request, response);
		}
		else if (tipo.equals("registrar")) {
			registrar(request, response);
		}
		else if (tipo.equals("actualizar")) {
			actualizar(request, response);
		}
		else if (tipo.equals("eliminar")) {
			eliminar(request, response);
		}
	}

	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomUsuario = request.getParameter("nom_usu"),
				password = request.getParameter("password");
		boolean con = service.autenticarUsuario(nomUsuario, password);
		if(con) {
			HttpSession session = request.getSession();
			session.setAttribute("nom_usu", nomUsuario);
			request.getRequestDispatcher("menu.jsp").forward( request, response);			
		}
		else {
			PrintWriter out = response.getWriter(); 
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('Contraseña y/o usuario incorrectos');"); 
			out.println("location='inicio.jsp';"); 
			out.println("</script>"); 
		}		
		
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codUsuario, nomUsuario, apePatUsuario, apeMatUsuario, tipoUsuario,numDocUsuario, imgUsuario,fecNacUsuario;
		boolean adminUsuario;
		codUsuario = request.getParameter("txt_cod");
		nomUsuario = request.getParameter("txt_nombre");
		apePatUsuario = request.getParameter("txt_ape_paterno");
		apeMatUsuario = request.getParameter("txt_ape_materno");
		tipoUsuario = request.getParameter("txt_tipo_usu");
		numDocUsuario = request.getParameter("txt_doc_usu");
		imgUsuario = request.getParameter("txt_img_usu");
		fecNacUsuario = request.getParameter("fec_nac_usu");
		adminUsuario = Boolean.parseBoolean(request.getParameter("admin_usu"));
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setCodUsuario(codUsuario);
		usuario.setNomUsuario(nomUsuario);
		usuario.setApePatUsuario(apePatUsuario);
		usuario.setApeMatUsuario(apeMatUsuario);
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setNumDocUsuario(numDocUsuario);
		usuario.setImgUsuario(imgUsuario);
		usuario.setFecNacUsuario(fecNacUsuario);
		usuario.setAdminUsuario(adminUsuario);
		
		System.out.println( service.actualizarUsuario(usuario));
		buscar(request, response);
			
	}
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codUsuario, nomUsuario, apePatUsuario, apeMatUsuario, tipoUsuario,numDocUsuario, imgUsuario,fecNacUsuario;
		boolean adminUsuario;
		codUsuario = request.getParameter("txt_cod");
		nomUsuario = request.getParameter("txt_nombre");
		apePatUsuario = request.getParameter("txt_ape_paterno");
		apeMatUsuario = request.getParameter("txt_ape_materno");
		tipoUsuario = request.getParameter("txt_tipo_usu");
		numDocUsuario = request.getParameter("txt_doc_usu");
		imgUsuario = request.getParameter("txt_img_usu");
		fecNacUsuario = request.getParameter("fec_nac_usu");
		adminUsuario = Boolean.parseBoolean(request.getParameter("admin_usu"));
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setCodUsuario(codUsuario);
		usuario.setNomUsuario(nomUsuario);
		usuario.setApePatUsuario(apePatUsuario);
		usuario.setApeMatUsuario(apeMatUsuario);
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setNumDocUsuario(numDocUsuario);
		usuario.setImgUsuario(imgUsuario);
		usuario.setFecNacUsuario(fecNacUsuario);
		usuario.setAdminUsuario(adminUsuario);
		
		service.registrarUsuario(usuario);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		

		String codigo = (String) session.getAttribute("nom_usu");

		request.setAttribute("dataUsuario", service.buscarUsuario(codigo));
		request.setAttribute("dataGeneroLibro", service.listarDataGenero());
		request.setAttribute("dataTipoDocumento", service.listarTipoDocumento());
		
		request.getRequestDispatcher("menuUsuario.jsp").forward(request, response);
		
	}
	

}
