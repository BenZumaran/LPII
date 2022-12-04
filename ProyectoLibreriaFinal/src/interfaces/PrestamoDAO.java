package interfaces;

import java.util.List;

import beans.PrestamoDTO;

public interface PrestamoDAO {

	//Metodos para mantener Data	
	//Préstamo
	//Buscar Préstamo
	public PrestamoDTO buscarPrestamo(int numPrestamo);
	//Listar préstamo
	public List<PrestamoDTO> listarPrestamo();
	//Filtrar préstamo
	public List<PrestamoDTO> filtrarPrestamo(String nomFiltro, String detalleFiltro);
	//Actualizar estado préstamo
	public int actualizarPrestamoEstado(String estado, int numPrestamo);
	//Devolución de libro
	public int devolucionLibro(String codLibro, int numPrestamo,  boolean deuda);
	//Crear préstamo
	public int crearNuevoPrestamo(PrestamoDTO prestamo);
	
}
