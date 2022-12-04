package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
				res = rs.getString("contra_usu").equals(contraUsuario);				
			
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
			String sql = "select * from usuario where cod_usu = ?;";
			ps = cn.prepareStatement(sql);
			ps.setString(1, codUsuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				usuario = new UsuarioDTO();
				usuario.setCodUsuario(codUsuario);
				usuario.setNomUsuario(rs.getString("nom_usu"));
				usuario.setApePatUsuario(rs.getString("ape_pat_usu"));
				usuario.setApeMatUsuario(rs.getString("ape_mat_usu"));
				usuario.setTipoUsuario(rs.getString("tipo_usu"));
				usuario.setNumDocUsuario(rs.getString("num_doc_usu"));
				usuario.setImgUsuario(rs.getString("img_usu"));
				usuario.setFecNacUsuario(rs.getString("fecha_nac_usu"));
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
			ps = cn.prepareStatement("update usuario set nom_usu = ?, ape_pat_usu = ?, ape_mat_usu = ?, tipo_usu = ?, num_doc_usu = ?, img_usu = ?, fecha_nac_usu = ?, admin_usu = ? where cod_usu = ?;");
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
		int res = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = MysqlDBConexion.getConexion();
			ps = cn.prepareStatement("insert into usuario values (?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, usuario.getCodUsuario());
			ps.setString(2, usuario.getNomUsuario());
			ps.setString(3, usuario.getApePatUsuario());
			ps.setString(4, usuario.getApeMatUsuario());
			ps.setString(5, usuario.getTipoUsuario());
			ps.setString(6, usuario.getNumDocUsuario());
			ps.setString(7, usuario.getImgUsuario());
			ps.setString(8, usuario.getFecNacUsuario());
			ps.setBoolean(9, usuario.isAdminUsuario());
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
	public int eliminarUsuario(String codUsuario) {
		int res = -1;
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = MysqlDBConexion.getConexion();
			ps = cn.prepareStatement("delete * from usuario where cod_usu = ?;");
			ps.setString(1, codUsuario);
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
	
}
