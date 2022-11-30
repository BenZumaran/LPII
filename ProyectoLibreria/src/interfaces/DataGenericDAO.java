package interfaces;

import java.util.List;

import beans.DataGenericaDTO;

public interface DataGenericDAO {

	//Métodos para devolver los tipos
	//Género de Libros
	public List<DataGenericaDTO> listarData();
}
