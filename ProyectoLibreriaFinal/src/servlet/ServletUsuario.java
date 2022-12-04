package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		}/*
		else if (tipo.equals("registrar")) {
			registrar(request, response);
		}
		else if (tipo.equals("actualizar")) {
			actualizar(request, response);
		}
		else if (tipo.equals("eliminar")) {
			eliminar(request, response);
		}*/
	}

	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomUsuario = request.getParameter("nom_usu"),
				password = request.getParameter("password");
		boolean con = service.autenticarUsuario(nomUsuario, password);
		if(con) request.getRequestDispatcher("menu.jsp").forward( request, response);			
		else {
			PrintWriter out = response.getWriter(); 
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('Contraseña y/o usuario incorrectos');"); 
			out.println("location='inicio.jsp';"); 
			out.println("</script>"); 
		}		
		
	}/*
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("cod"));
		service.eliminarJugador(codigo);
		listar(request, response);
	}*/

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codJ, dni, codClub, codPosc; String nom, ape; double sueldo; 
		codJ = Integer.parseInt(request.getParameter("txt_cod"));
		dni = Integer.parseInt(request.getParameter("txt_dni"));
		codClub = Integer.parseInt(request.getParameter("cbo_club"));
		codPosc = Integer.parseInt(request.getParameter("cbo_posc"));
		nom = request.getParameter("txt_nom");
		ape = request.getParameter("txt_ape");
		sueldo = Double.parseDouble(request.getParameter("txt_sueldo"));
		
		Jugador jugador = new Jugador();
		jugador.setCodJugador(codJ);
		jugador.setNomJugador(nom);
		jugador.setApeJugador(ape);
		jugador.setDniJugador(dni);
		jugador.setSueldo(sueldo);
		jugador.setCodClub(codClub);
		jugador.setCodPosicion(codPosc);
		
		service.actualizarUsuario();
		request.getRequestDispatcher("menu.jsp").forward(request, response);
			
	}
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int dni, codClub, codPosc; String nom, ape; double sueldo; 
	dni = Integer.parseInt(request.getParameter("txt_dni"));
	codClub = Integer.parseInt(request.getParameter("cbo_club"));
	codPosc = Integer.parseInt(request.getParameter("cbo_posc"));
	nom = request.getParameter("txt_nom");
	ape = request.getParameter("txt_ape");
	sueldo = Double.parseDouble(request.getParameter("txt_sueldo"));
	
	Jugador jugador = new Jugador();
	jugador.setNomJugador(nom);
	jugador.setApeJugador(ape);
	jugador.setDniJugador(dni);
	jugador.setSueldo(sueldo);
	jugador.setCodClub(codClub);
	jugador.setCodPosicion(codPosc);
	
	service.ingresarJugador(jugador);
	listar(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean actualizar = Boolean.parseBoolean(request.getParameter("actualizar"));
		if(actualizar) {
			String codigo = request.getParameter("codigo");
			request.setAttribute("dataUsuario", service.buscarUsuario(codigo));
		}					

		request.setAttribute("dataGeneroLibro", service.listarDataGenero());
		request.setAttribute("dataTipoDocumento", service.listarTipoDocumento());
		
		request.getRequestDispatcher("menuUsuario.jsp").forward(request, response);
		
	}
	

}
