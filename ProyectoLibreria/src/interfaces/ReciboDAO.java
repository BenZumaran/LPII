package interfaces;

import java.util.List;

import beans.ReciboDTO;

public interface ReciboDAO {

	//Recibo
	//Buscar Recibo
	public ReciboDTO buscarRecibo(int numRecibo);
	//Listar Recibo
	public List<ReciboDTO> listarRecibo();
	//Filtrar Recibo
	public List<ReciboDTO> filtrarRecibo(String nomFiltro, String detFiltro);
	//Ingresar Recibo
	public int ingresarRecibo(ReciboDTO recibo);
}
