package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.SolicitudDTO;
import interfaces.SolicitudDAO;
import util.MysqlDBConexion;

public class SolicitudPrestamoImpl implements SolicitudDAO{

	Connection cn = null;
	PreparedStatement ps = null;
	String sql = "";
	
	@Override
	public SolicitudDTO buscarSolicitud(int numSolicitud) {
		SolicitudDTO soli = null;
		try {
			cn = MysqlDBConexion.getConexion();
			sql = "select * from solicitud_prestamo where num_soli = ?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, numSolicitud);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				soli = new SolicitudDTO();
				soli.setNumSolicitud(rs.getInt("num_soli"));
				soli.setCodUsuSolicitante(rs.getString("cod_usu_solicitante"));
				soli.setCodUsuAprobador(rs.getString("cod_usu_aprobador"));
				soli.setFecCreacionSoli(rs.getString("fec_creacion_soli"));
				soli.setFecAprobacionSoli(rs.getString("fec_aprobacion_soli"));
				soli.setFecIniPrestamo(rs.getString("fec_ini_pres"));
				soli.setFecDevPrestamo(rs.getString("fec_dev_pres"));
				soli.setEstadoSoli(rs.getString("estado_soli"));				
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return soli;
	}

	@Override
	public List<SolicitudDTO> listarSolicitud() {
		List<SolicitudDTO> lista = new ArrayList<SolicitudDTO>();
		SolicitudDTO soli = null;
		try {
			cn = MysqlDBConexion.getConexion();
			sql = "select * from solicitud_prestamo";
			ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				soli = new SolicitudDTO();
				soli.setNumSolicitud(rs.getInt("num_soli"));
				soli.setCodUsuSolicitante(rs.getString("cod_usu_solicitante"));
				soli.setCodUsuAprobador(rs.getString("cod_usu_aprobador"));
				soli.setFecCreacionSoli(rs.getString("fec_creacion_soli"));
				soli.setFecAprobacionSoli(rs.getString("fec_aprobacion_soli"));
				soli.setFecIniPrestamo(rs.getString("fec_ini_pres"));
				soli.setFecDevPrestamo(rs.getString("fec_dev_pres"));
				soli.setEstadoSoli(rs.getString("estado_soli"));
				lista.add(soli);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<SolicitudDTO> filtrarSolicitud(String nomFiltro, String detFiltro) {
		List<SolicitudDTO> lista = new ArrayList<SolicitudDTO>();
		SolicitudDTO soli = null;
		switch(nomFiltro) {
			case "solicitante":
				sql = "select * from solicitud_prestamo where cod_usu_solicitante = ?";
				break;
			case "estado":
				sql = "select * from solicitud_prestamo where estado_soli = ?";
				break;
		}
		try {
			cn = MysqlDBConexion.getConexion();
			ps = cn.prepareStatement(sql);
			ps.setString(1, detFiltro);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				soli = new SolicitudDTO();
				soli.setNumSolicitud(rs.getInt("num_soli"));
				soli.setCodUsuSolicitante(rs.getString("cod_usu_solicitante"));
				soli.setCodUsuAprobador(rs.getString("cod_usu_aprobador"));
				soli.setFecCreacionSoli(rs.getString("fec_creacion_soli"));
				soli.setFecAprobacionSoli(rs.getString("fec_aprobacion_soli"));
				soli.setFecIniPrestamo(rs.getString("fec_ini_pres"));
				soli.setFecDevPrestamo(rs.getString("fec_dev_pres"));
				soli.setEstadoSoli(rs.getString("estado_soli"));
				lista.add(soli);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int cambiarEstadoSolicitud(String estadoSolicitud, int numSolicitud, String usuarioAprobador) {
		int res = -1;
		try {
			SimpleDateFormat frm = new SimpleDateFormat("yyyy/MM/dd");  
		    Date dt = new Date();  
			cn = MysqlDBConexion.getConexion();
			String sql = "update solicitud_prestamo set estado_soli = ?, cod_usu_aprobador = ?, fec_aprobacion_soli = ? where num_soli = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, estadoSolicitud);
			ps.setString(2, usuarioAprobador);
			ps.setString(3, frm.format(dt));
			ps.setInt(4, numSolicitud);
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(cn != null)cn.close();
				if(ps != null)ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}

}
