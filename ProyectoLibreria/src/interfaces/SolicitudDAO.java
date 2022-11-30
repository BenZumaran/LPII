package interfaces;

import java.util.List;

import beans.SolicitudDTO;

public interface SolicitudDAO {

	//Metodos para mantener Data	
	//Solicitud Préstamo
	//BuscarSolicitud
	public SolicitudDTO buscarSolicitud(SolicitudDTO solicitud);
	//ListarSolicitud
	public List<SolicitudDTO> listarSolicitud();
	//FiltrarSolicitud
	public List<SolicitudDTO> filtrarSolicitud(String nomFiltro, String detFiltro);
	//Actualizar Estado Solicitud
	public int actualizarSolicitudEstado(int numSoli, String nuevoEstado, String codUsuModificador);
	
}
