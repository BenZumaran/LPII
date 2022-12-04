package dao;

import interfaces.DataGenericDAO;
import interfaces.LibroDAO;
import interfaces.PrestamoDAO;
import interfaces.ReciboDAO;
import interfaces.SolicitudDAO;
import interfaces.UsuarioDAO;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	
	public abstract DataGenericDAO getGeneroLibro();
	public abstract DataGenericDAO getTipoDocumento();
	public abstract LibroDAO getLibro();
	public abstract PrestamoDAO getPrestamo();
	public abstract ReciboDAO getRecibo();
	public abstract SolicitudDAO getSolicitud();
	public abstract UsuarioDAO getUsuario();
	
	public static DAOFactory getDAOFactory(int numFactory) {
		switch(numFactory) {
			case MYSQL:
				return new MysqlDAOFactory();
		}
		return null;
	}

}
