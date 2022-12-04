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
			String sql = "select * from libro";
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarEstadoLibro(String estado, String codLibro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ingresarLibro(LibroDTO libro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int darDeBajaLibro(String codLibro) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
