package service;

import java.util.List;

import beans.DataGenericaDTO;
import dao.DAOFactory;
import interfaces.DataGenericDAO;

public class DataService {
	DAOFactory factory  = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	DataGenericDAO generoLibro = factory.getGeneroLibro();
	DataGenericDAO tipoDocumento = factory.getTipoDocumento();
	
	public List<DataGenericaDTO> listarDataGenero() {
		return generoLibro.listarData();
	}
	
	public List<DataGenericaDTO> listarTipoDocumento() {
		return tipoDocumento.listarData();
	} 
	
}
