package interfaces;

import java.util.List;

import beans.PrestamoDTO;

public interface PrestamoDAO {

	//Metodos para mantener Data	
	//Pr�stamo
	//Buscar Pr�stamo
	public PrestamoDTO buscarPrestamo(PrestamoDTO prestamo, String detFiltro);
	//Listar pr�stamo
	public List<PrestamoDTO> listarPrestamo();
	//Filtrar pr�stamo
	public List<PrestamoDTO> filtrarPrestamo(String nomFiltro);
	//Actualizar estado pr�stamo
	public int actualizarPrestamoEstado(String estado, int numPrestamo);
	//Devoluci�n de libro
	public int devolucionLibro(String codLibro, int numPrestamo);
	//Crear pr�stamo
	public int crearNuevoPrestamo(PrestamoDTO prestamo);
	
}
