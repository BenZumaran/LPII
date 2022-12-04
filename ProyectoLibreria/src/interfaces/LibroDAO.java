package interfaces;

import java.util.List;

import beans.LibroDTO;

public interface LibroDAO {
	
	//Metodos para mantener Data	
	//Libro
	//BuscarLibro
	public LibroDTO buscarLibro(String codLibro);
	//Listar Libro
	public List<LibroDTO> listarLibro();
	//Filtrar libro por genero
	public List<LibroDTO> filtrarLibro(String nomFiltro, String detFiltro);
	//Actualizar Libro
	public int actualizarLibro(LibroDTO libro);
	//Actualizar estado libro
	public int actualizarEstadoLibro(String estado, String codLibro);
	//Ingresar libro
	public int darDeBajaLibro(String codLibro);
		
}
