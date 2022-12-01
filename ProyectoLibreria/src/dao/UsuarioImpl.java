package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import util.MysqlDBConexion;

public class UsuarioImpl implements UsuarioDAO{

	@Override
	public boolean autenticarUsuario(String codUsuario, String contraUsuario) {
		boolean res = false;
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql = "";
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			
		}
		return res;
	}

	@Override
	public UsuarioDTO buscarUsuario(String codUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int actualizarUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registrarUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarUsuario(String codUsuario) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
