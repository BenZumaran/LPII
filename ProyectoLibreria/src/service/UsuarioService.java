package service;

import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;

public class UsuarioService {
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDAO usuario = factory.getUsuario();
	
	public boolean autenticarUsuario(String codUsuario, String contraUsuario) {
		return usuario.autenticarUsuario(codUsuario, contraUsuario);
	}
	public UsuarioDTO buscarUsuario(String codUsuario) {
		return usuario.buscarUsuario(codUsuario);
	}
	public int actualizarUsuario(UsuarioDTO usu) {
		return usuario.actualizarUsuario(usu);
	}
	public int registrarUsuario(UsuarioDTO usu) {
		return usuario.registrarUsuario(usu);
	}
	public int eliminarUsuario(String codUsuario) {
		return usuario.eliminarUsuario(codUsuario);
	}
}
