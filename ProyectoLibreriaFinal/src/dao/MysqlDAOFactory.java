package dao;

import interfaces.DataGenericDAO;
import interfaces.LibroDAO;
import interfaces.PrestamoDAO;
import interfaces.ReciboDAO;
import interfaces.SolicitudDAO;
import interfaces.UsuarioDAO;

public class MysqlDAOFactory extends DAOFactory{

	@Override
	public DataGenericDAO getGeneroLibro() {
		return new DataGeneroLibroImpl();
	}

	@Override
	public DataGenericDAO getTipoDocumento() {
		return new DataTipoDocImpl();
	}

	@Override
	public LibroDAO getLibro() {
		return new LibroImpl();
	}

	@Override
	public PrestamoDAO getPrestamo() {
		return new PrestamoImpl()	;
	}

	@Override
	public ReciboDAO getRecibo() {
		return new ReciboImpl();
	}

	@Override
	public SolicitudDAO getSolicitud() {
		return new SolicitudPrestamoImpl();
	}

	@Override
	public UsuarioDAO getUsuario() {
		return new UsuarioImpl();
	}
	
}
