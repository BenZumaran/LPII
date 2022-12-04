package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.PrestamoDTO;
import interfaces.PrestamoDAO;
import util.MysqlDBConexion;

public class PrestamoImpl implements PrestamoDAO {
	private Connection cn = null;
	private PreparedStatement ps = null;
	@Override
	public PrestamoDTO buscarPrestamo(int numPrestamo) {
		PrestamoDTO prestamo = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from prestamo where num_pres = ?;";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, numPrestamo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				prestamo = new PrestamoDTO();
				prestamo.setNumPrestamo(rs.getInt("num_pres"));
				prestamo.setCodUsuario(rs.getString("cod_usu"));
				prestamo.setNumSolicitud(rs.getInt("num_soli"));
				prestamo.setDeudaPrestamo(rs.getDouble("deuda_pres"));
				prestamo.setEstadoPrestamo(rs.getString("est_pres"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(cn != null) cn.close();
				if(ps != null) ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return prestamo;
	}
	@Override
	public List<PrestamoDTO> listarPrestamo() {
		List<PrestamoDTO> lista = new ArrayList<PrestamoDTO>(); 
		PrestamoDTO prestamo = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from prestamo;";
			ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				prestamo = new PrestamoDTO();
				prestamo.setNumPrestamo(rs.getInt("num_pres"));
				prestamo.setCodUsuario(rs.getString("cod_usu"));
				prestamo.setNumSolicitud(rs.getInt("num_soli"));
				prestamo.setDeudaPrestamo(rs.getDouble("deuda_pres"));
				prestamo.setEstadoPrestamo(rs.getString("est_pres"));
				lista.add(prestamo);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(cn != null) cn.close();
				if(ps != null) ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
	@Override
	public List<PrestamoDTO> filtrarPrestamo(String nomFiltro, String detalleFiltro) {
		List<PrestamoDTO> lista = new ArrayList<PrestamoDTO>(); 
		PrestamoDTO prestamo = null;
		String sql = "";
		switch(nomFiltro) {
			case "usuario":
				 sql = "select * from prestamo where cod_usu like \"%"+detalleFiltro+"%\";";
				
				break;
			case "estado":
				sql = "select * from prestamo where est_pres = "+detalleFiltro+"";
				break;
		}
		try {
			cn = MysqlDBConexion.getConexion();
			ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				prestamo = new PrestamoDTO();
				prestamo.setNumPrestamo(rs.getInt("num_pres"));
				prestamo.setCodUsuario(rs.getString("cod_usu"));
				prestamo.setNumSolicitud(rs.getInt("num_soli"));
				prestamo.setDeudaPrestamo(rs.getDouble("deuda_pres"));
				prestamo.setEstadoPrestamo(rs.getString("est_pres"));
				lista.add(prestamo);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(cn != null) cn.close();
				if(ps != null) ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
	@Override
	public int actualizarPrestamoEstado(String estado, int numPrestamo) {
		int res = -1;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update prestamo set est_pres = ? "
					+ "where num_pres = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, estado);
			ps.setInt(2, numPrestamo);
			res = ps.executeUpdate();
		}catch (Exception q) {
			q.printStackTrace();
		} finally {
			try {
				if(cn != null) cn.close();
				if(ps != null) ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	@Override
	public int devolucionLibro(String codLibro, int numPrestamo, boolean deuda) {
		int res = -1;
		if(deuda) res = actualizarPrestamoEstado("deuda", numPrestamo);
		else res = actualizarPrestamoEstado("devuelto", numPrestamo);
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update libro set estado_lib= \"stock\" "
					+ "where cod_lib = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, codLibro);
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(cn != null) cn.close();
				if(ps != null) ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	@Override
	public int crearNuevoPrestamo(PrestamoDTO prestamo) {
		int res = -1;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into prestamo values (null,?,?,?,?)";
			ps = cn.prepareStatement(sql);
			ps.setString(1, prestamo.getCodUsuario());
			ps.setInt(2, prestamo.getNumSolicitud());
			ps.setDouble(3, prestamo.getDeudaPrestamo());
			ps.setString(4, "pendiente");
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(cn != null) cn.close();
				if(ps != null) ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	
}
