package service;

import java.util.List;

import beans.PrestamoDTO;
import dao.DAOFactory;
import interfaces.PrestamoDAO;

public class PrestamoService {
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	PrestamoDAO prestamo = factory.getPrestamo();
	
	public PrestamoDTO buscarPrestamo(int numPrestamo) {
		return prestamo.buscarPrestamo(numPrestamo);
	}
	public List<PrestamoDTO> listarPrestamo(){
		return prestamo.listarPrestamo();
	}
	public List<PrestamoDTO> filtrarPrestamo(String nomFiltro, String detalleFiltro){
		return prestamo.filtrarPrestamo(nomFiltro, detalleFiltro);
	}
	public int actualizarPrestamoEstado(String estado, int numPrestamo) {
		return prestamo.actualizarPrestamoEstado(estado, numPrestamo);
	}
	public int devolucionLibro(String codLibro, int numPrestamo,  boolean deuda) {
		return prestamo.devolucionLibro(codLibro, numPrestamo, deuda);
	}
	public int crearNuevoPrestamo(PrestamoDTO pres) {
		return prestamo.crearNuevoPrestamo(pres);
	}

}
