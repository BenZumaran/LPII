package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			String sql = "select contra_usu from usuario where cod_usu = ?;";
			ps = cn.prepareStatement(sql);
			ps.setString(1, codUsuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
				res = rs.getString(0).equals(contraUsuario);				
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(cn != null) cn.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public UsuarioDTO buscarUsuario(String codUsuario) {
		UsuarioDTO usuario = null;
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = MysqlDBConexion.getConexion();
			ps = cn.prepareStatement("selec * from usuario where cod_usu = ?");
			ps.setString(1, codUsuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				usuario = new UsuarioDTO();
				usuario.setCodUsuario(codUsuario);
				usuario.setNomUsuario(rs.getString("nom_usu"));
				usuario.setApePatUsuario(rs.getString("ape_pat_usu"));
				usuario.setApeMatUsuario(rs.getString("ape_mat_usu"));
				usuario.setTipoUsuario(rs.getString("tipo_usu"));
				usuario.setNumDocUsuario("num_doc_usu");
				usuario.setImgUsuario(rs.getString("img_usu"));
				usuario.setFecNacUsuario("fecha_nac_usu");
				usuario.setAdminUsuario(rs.getBoolean("admin_usu"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(cn != null) cn.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return usuario;
	}

	@Override
	public int actualizarUsuario(UsuarioDTO usuario) {
		int res = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = MysqlDBConexion.getConexion();
			ps = cn.prepareStatement("update usuario set nom_usu = ?, ape_pat_usu = ?, "
					+ "ape_mat_usu = ?, tipo_usu = ?, num_doc_usu = ?, "
					+ "img_usu = ?, fec_nac_usu = ?, admin = ? where cod_usu = ?;");
			ps.setString(1, usuario.getNomUsuario());
			ps.setString(2, usuario.getApePatUsuario());
			ps.setString(3, usuario.getApeMatUsuario());
			ps.setString(4, usuario.getTipoUsuario());
			ps.setString(5, usuario.getNumDocUsuario());
			ps.setString(6, usuario.getImgUsuario());
			ps.setString(7, usuario.getFecNacUsuario());
			ps.setBoolean(8, usuario.isAdminUsuario());
			ps.setString(9, usuario.getCodUsuario());
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(cn != null) cn.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
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
