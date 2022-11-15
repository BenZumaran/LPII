package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ClienteDTO;
import beans.EditorialDTO;
import beans.LibroDTO;
import beans.PrestamoDTO;
import beans.TemaDTO;
import interfaces.LibroDAO;
import util.MysqlDBConexion;

public class ImplLibroDAO implements LibroDAO{

	@Override
	public List<LibroDTO> listarLibros() {
		LibroDTO libro = null;
		List<LibroDTO> libros = new ArrayList<LibroDTO>();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from tb_libro";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				libro = new LibroDTO();
				libro.setCodLibro(rs.getString(1));
				libro.setNomLibro(rs.getString(2));
				libro.setTipoEdit(rs.getInt(3));
				libro.setAutor(rs.getString(4));
				libro.setCodTema(rs.getInt(5));
				libro.setPrecio(rs.getDouble(6));
				libro.setStock(rs.getInt(7));
				libros.add(libro);
			}
			
		} catch(Exception x) {
			x.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) rs.close();
				if(cn != null) rs.close();
			} catch(Exception x1) {
				x1.printStackTrace();
			}
		}
		return libros;
	}

	@Override
	public LibroDTO buscarLibro(String codigo) {
		LibroDTO libro = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from tb_libro where cod_lib =?;";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				libro = new LibroDTO();
				libro.setCodLibro(rs.getString(1));
				libro.setNomLibro(rs.getString(2));
				libro.setTipoEdit(rs.getInt(3));
				libro.setAutor(rs.getString(4));
				libro.setCodTema(rs.getInt(5));
				libro.setPrecio(rs.getDouble(6));
				libro.setStock(rs.getInt(7));
			}
		} catch(Exception x) {
			x.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) rs.close();
				if(cn != null) rs.close();
			} catch(Exception x1) {
				x1.printStackTrace();
			}
		}
		return libro;
	}

	@Override
	public int crearLibro(LibroDTO libro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarLibro(LibroDTO libro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarLibro(String codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EditorialDTO> listarEditoriales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EditorialDTO buscarEditorial(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int crearEditorial(EditorialDTO editorial) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarEditorial(EditorialDTO editorial) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarEditorial(String codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TemaDTO> listarTemas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EditorialDTO buscarTema(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int crearTema(TemaDTO tema) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarTema(TemaDTO tema) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarTema(String codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ClienteDTO> listarClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EditorialDTO buscarCliente(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int crearCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCliente(String codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PrestamoDTO> listarPrestamo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EditorialDTO buscarPrestamo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int crearPrestamo(PrestamoDTO prestamo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarPrestamo(PrestamoDTO prestamo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
