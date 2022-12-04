package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.DataGenericaDTO;
import interfaces.DataGenericDAO;
import util.MysqlDBConexion;

public class DataGeneroLibroImpl implements DataGenericDAO{

	@Override
	public List<DataGenericaDTO> listarData() {
		List<DataGenericaDTO> data = new ArrayList<DataGenericaDTO>();
		DataGenericaDTO dt = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from genero_libros";
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dt = new DataGenericaDTO();
				dt.setCodigo(rs.getString(1));
				dt.setDescripcion(rs.getString(2));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if (ps != null) ps.close();
				if(cn != null) cn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
}
