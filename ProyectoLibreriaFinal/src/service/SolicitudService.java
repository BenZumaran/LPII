package service;

import java.util.List;

import beans.SolicitudDTO;
import dao.DAOFactory;
import interfaces.SolicitudDAO;

public class SolicitudService {
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	SolicitudDAO solicitud = factory.getSolicitud();
	
	public SolicitudDTO buscarSolicitud(int numSolicitud) {
		return solicitud.buscarSolicitud(numSolicitud);
	}
	public List<SolicitudDTO> listarSolicitud(){
		return solicitud.listarSolicitud();
	}
	public List<SolicitudDTO> filtrarSolicitud(String nomFiltro, String detFiltro){
		return solicitud.filtrarSolicitud(nomFiltro, detFiltro);
	}
	public int cambiarEstadoSolicitud(String estadoSolicitud, int numSolicitud) {
		return solicitud.cambiarEstadoSolicitud(estadoSolicitud, numSolicitud);
	}
}
