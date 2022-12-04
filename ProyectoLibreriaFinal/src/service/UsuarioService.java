package service;

import java.util.List;

import beans.DataGenericaDTO;
import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.DataGenericDAO;
import interfaces.UsuarioDAO;

public class UsuarioService {
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDAO usuario = factory.getUsuario();
	DataGenericDAO generoLibro = factory.getGeneroLibro();
	DataGenericDAO tipoDocumento = factory.getTipoDocumento();
	
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
	public List<DataGenericaDTO> listarDataGenero() {
		return generoLibro.listarData();
	}
	
	public List<DataGenericaDTO> listarTipoDocumento() {
		return tipoDocumento.listarData();
	} 
}
