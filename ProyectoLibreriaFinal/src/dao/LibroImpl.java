package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.LibroDTO;
import interfaces.LibroDAO;
import util.MysqlDBConexion;

public class LibroImpl implements LibroDAO{
	
	Connection cn = MysqlDBConexion.getConexion();
	PreparedStatement ps = null;
	
	@Override
	public LibroDTO buscarLibro(String codLibro) {
		LibroDTO libro = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from libro where cod_lib = ?";
			ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				libro = new LibroDTO();
				libro.setCodLibro(rs.getString("cod_lib"));
				libro.setDescLibro(rs.getString("desc_lib"));
				libro.setAnioLibro(rs.getInt("anio_lib"));
				libro.setCodGenero(rs.getString("cod_gen"));
				libro.setAutorLibro(rs.getString("autor_lib"));
				libro.setEstadoLibro(rs.getString("estado_lib"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null) cn.close();;
				if(ps != null) ps.close();;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return libro;
	}

	@Override
	public List<LibroDTO> listarLibro() {
		List<LibroDTO> lista = new ArrayList<LibroDTO>();
		LibroDTO libro = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from libro";
			ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				libro = new LibroDTO();
				libro.setCodLibro(rs.getString("cod_lib"));
				libro.setDescLibro(rs.getString("desc_lib"));
				libro.setAnioLibro(rs.getInt("anio_lib"));
				libro.setCodGenero(rs.getString("cod_gen"));
				libro.setAutorLibro(rs.getString("autor_lib"));
				libro.setEstadoLibro(rs.getString("estado_lib"));
				lista.add(libro);				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null) cn.close();;
				if(ps != null) ps.close();;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<LibroDTO> filtrarLibro(String nomFiltro, String detFiltro) {
		List<LibroDTO> lista = new ArrayList<LibroDTO>();
		LibroDTO libro = null;
		String sql = "";
		switch(nomFiltro) {
			case "descripcion":
				sql = "select * from libro where desc_lib like ?";
				break;
			case "genero":
				sql = "select * from libro where cod_gen like ?";				
				break;
			case "autor":
				sql = "select * from libro where autor_lib like ?";
				break;
			case "estado":
				sql = "select * from libro where estado_lib like ?";
				break;
		}
		try {
			cn = MysqlDBConexion.getConexion();
			ps = cn.prepareStatement(sql);
			ps.setString(1, detFiltro);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				libro = new LibroDTO();
				libro.setCodLibro(rs.getString("cod_lib"));
				libro.setDescLibro(rs.getString("desc_lib"));
				libro.setAnioLibro(rs.getInt("anio_lib"));
				libro.setCodGenero(rs.getString("cod_gen"));
				libro.setAutorLibro(rs.getString("autor_lib"));
				libro.setEstadoLibro(rs.getString("estado_lib"));
				lista.add(libro);				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null) cn.close();;
				if(ps != null) ps.close();;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int actualizarLibro(LibroDTO libro) {
		int res = -1;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update libro set desc_lib = ?, anio_lib = ?, cod_gen = ?, autor_lib = ?, estado_lib = ? where cod_lib = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, libro.getDescLibro());
			ps.setInt(2, libro.getAnioLibro());
			ps.setString(3, libro.getCodGenero());
			ps.setString(4, libro.getAutorLibro());
			ps.setString(5, libro.getEstadoLibro());
			ps.setString(6, libro.getCodLibro());
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

	@Override
	public int ingresarLibro(LibroDTO libro) {
		int res = -1;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into libro values (?,?,?,?,?,?);";
			ps = cn.prepareStatement(sql);
			ps.setString(1, libro.getCodLibro());
			ps.setString(2, libro.getDescLibro());
			ps.setInt(3, libro.getAnioLibro());
			ps.setString(4, libro.getCodGenero());
			ps.setString(5, libro.getAutorLibro());
			ps.setString(6, libro.getEstadoLibro());
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
