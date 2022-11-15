package interfaces;

import java.util.List;

import beans.ClienteDTO;
import beans.EditorialDTO;
import beans.LibroDTO;
import beans.PrestamoDTO;
import beans.TemaDTO;

public interface LibroDAO {
	public List<LibroDTO> listarLibros();
	public LibroDTO buscarLibro(String codigo);
	public int crearLibro(LibroDTO libro);
	public int actualizarLibro(LibroDTO libro);
	public int eliminarLibro(String codigo);
		
	public List<EditorialDTO> listarEditoriales();
	public EditorialDTO buscarEditorial(String codigo);
	public int crearEditorial(EditorialDTO editorial);
	public int actualizarEditorial(EditorialDTO editorial);
	public int eliminarEditorial(String codigo);
	
	public List<TemaDTO> listarTemas();
	public EditorialDTO buscarTema(String codigo);
	public int crearTema(TemaDTO tema);
	public int actualizarTema(TemaDTO tema);
	public int eliminarTema(String codigo);
	
	
	public List<ClienteDTO> listarClientes();
	public EditorialDTO buscarCliente(String codigo);
	public int crearCliente(ClienteDTO cliente);
	public int actualizarCliente(ClienteDTO cliente);
	public int eliminarCliente(String codigo);
	
	
	public List<PrestamoDTO> listarPrestamo();
	public EditorialDTO buscarPrestamo(String codigo);
	public int crearPrestamo(PrestamoDTO prestamo);
	public int actualizarPrestamo(PrestamoDTO prestamo);
	
}
