package interfaces;

import java.util.List;

import beans.PrestamoDTO;

public interface PrestamoDAO {

	//Metodos para mantener Data	
	//Préstamo
	//Buscar Préstamo
	public PrestamoDTO buscarPrestamo(PrestamoDTO prestamo, String detFiltro);
	//Listar préstamo
	public List<PrestamoDTO> listarPrestamo();
	//Filtrar préstamo
	public List<PrestamoDTO> filtrarPrestamo(String nomFiltro);
	//Actualizar estado préstamo
	public int actualizarPrestamoEstado(String estado, int numPrestamo);
	//Devolución de libro
	public int devolucionLibro(String codLibro, int numPrestamo);
	//Crear préstamo
	public int crearNuevoPrestamo(PrestamoDTO prestamo);
	
}
