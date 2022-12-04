package interfaces;

import java.util.List;

import beans.SolicitudDTO;

public interface SolicitudDAO {

	//Metodos para mantener Data	
	//Solicitud Préstamo
	//BuscarSolicitud
	public SolicitudDTO buscarSolicitud(int numSolicitud);
	//ListarSolicitud
	public List<SolicitudDTO> listarSolicitud();
	//FiltrarSolicitud
	public List<SolicitudDTO> filtrarSolicitud(String nomFiltro, String detFiltro);
	//CanbiarEstadoSolicitud
	public int cambiarEstadoSolicitud(String estadoSolicitud, int numSolicitud);
	
}
