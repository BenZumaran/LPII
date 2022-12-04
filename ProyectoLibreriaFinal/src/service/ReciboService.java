package service;

import java.util.List;

import beans.ReciboDTO;
import dao.DAOFactory;
import interfaces.ReciboDAO;

public class ReciboService {
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ReciboDAO recibo = factory.getRecibo();
	
	public ReciboDTO buscarRecibo(int numRecibo) {
		return recibo.buscarRecibo(numRecibo);
	}
	public List<ReciboDTO> listarRecibo(){
		return recibo.listarRecibo();
	}
	public List<ReciboDTO> filtrarRecibo(String nomFiltro, String detFiltro){
		return recibo.filtrarRecibo(nomFiltro, detFiltro);
	}
	public int ingresarRecibo(ReciboDTO reci) {
		return recibo.ingresarRecibo(reci);
	}
}
