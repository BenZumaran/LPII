package service;

import java.util.List;

import beans.DataGenericaDTO;
import beans.LibroDTO;
import dao.DAOFactory;
import interfaces.DataGenericDAO;
import interfaces.LibroDAO;

public class LibroService {
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	LibroDAO libro = factory.getLibro();
	DataGenericDAO generoLibro = factory.getGeneroLibro();
	
	public LibroDTO buscarLibro(String codLibro) {
		return libro.buscarLibro(codLibro);
	}
	public List<LibroDTO> listarLibro(){
		return libro.listarLibro();
	}
	public List<LibroDTO> filtrarLibro(String nomFiltro, String detFiltro){
		return libro.filtrarLibro(nomFiltro, detFiltro);
	}
	public int actualizarLibro(LibroDTO lib) {
		return libro.actualizarLibro(lib);
	}
	public int ingresarLibro(LibroDTO lib) {
		return libro.ingresarLibro(lib);
	}
	public List<DataGenericaDTO> listarDataGenero() {
		return generoLibro.listarData();
	}
}
