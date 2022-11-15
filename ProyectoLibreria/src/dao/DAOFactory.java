package dao;

import interfaces.LibroDAO;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	
	public abstract LibroDAO getLibro();

}
