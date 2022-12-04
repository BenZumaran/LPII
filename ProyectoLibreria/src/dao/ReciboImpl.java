package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ReciboDTO;
import interfaces.ReciboDAO;
import util.MysqlDBConexion;

public class ReciboImpl implements ReciboDAO{
	private Connection cn = MysqlDBConexion.getConexion();
	private PreparedStatement ps = null;
	@Override
	public ReciboDTO buscarRecibo(int numRecibo) {
		ReciboDTO recibo = null;
		try {			
			String sql = "select * from recibo where num_reci = ?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, numRecibo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				recibo = new ReciboDTO();
				recibo.setNumRecibo(rs.getInt("num_reci"));
				recibo.setImporteRecibo(rs.getDouble("importe_reci"));
				recibo.setCodUsuarioCobranza(rs.getString("cod_usu_cobranza"));
				recibo.setFechaRecibo(rs.getString("fec_reci"));
				recibo.setCodigoDocumento(rs.getString("cod_doc"));
				recibo.setNumDocRecibo(rs.getString("num_doc_reci"));				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null) cn.close();
				if(ps != null) ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return recibo;
	}

	@Override
	public List<ReciboDTO> listarRecibo() {
		List<ReciboDTO> lista = new ArrayList<ReciboDTO>();
		ReciboDTO recibo = null;
		try {			
			String sql = "select * from recibo;";
			ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				recibo = new ReciboDTO();
				recibo.setNumRecibo(rs.getInt("num_reci"));
				recibo.setImporteRecibo(rs.getDouble("importe_reci"));
				recibo.setCodUsuarioCobranza(rs.getString("cod_usu_cobranza"));
				recibo.setFechaRecibo(rs.getString("fec_reci"));
				recibo.setCodigoDocumento(rs.getString("cod_doc"));
				recibo.setNumDocRecibo(rs.getString("num_doc_reci"));	
				lista.add(recibo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	public List<ReciboDTO> filtrarRecibo(String nomFiltro, String detFiltro) {
		List<ReciboDTO> lista = new ArrayList<ReciboDTO>();
		ReciboDTO recibo = null;
		String sql = "";
		switch(nomFiltro) {
			case "tipoDocumento":
				sql = "select * from recibo where cod_doc = ? ;";
				break;
			case "numeroDocumento":
				sql = "select * from recibo where num_doc_reci like ?;";
				break;
		}
		
		try {			
			ps = cn.prepareStatement(sql);
			ps.setString(1, detFiltro);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				recibo = new ReciboDTO();
				recibo.setNumRecibo(rs.getInt("num_reci"));
				recibo.setImporteRecibo(rs.getDouble("importe_reci"));
				recibo.setCodUsuarioCobranza(rs.getString("cod_usu_cobranza"));
				recibo.setFechaRecibo(rs.getString("fec_reci"));
				recibo.setCodigoDocumento(rs.getString("cod_doc"));
				recibo.setNumDocRecibo(rs.getString("num_doc_reci"));	
				lista.add(recibo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	public int ingresarRecibo(ReciboDTO recibo) {
		int res = -1;
		try {
			String sql = "insert into recibo values (null,?,?,?,?,?,?);";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, recibo.getNumPrestamo());
			ps.setDouble(2, recibo.getImporteRecibo());
			ps.setString(3, recibo.getCodUsuarioCobranza());
			ps.setString(4, recibo.getFechaRecibo());
			ps.setString(5, recibo.getCodigoDocumento());
			ps.setString(6, recibo.getNumDocRecibo());
			res = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
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
