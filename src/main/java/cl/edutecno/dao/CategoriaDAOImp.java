package cl.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.edutecno.conexionDB.ProcesaConexionDB;
import cl.edutecno.model.Categoria;
import cl.edutecno.model.Producto;

public class CategoriaDAOImp extends ProcesaConexionDB implements ICategoriaDAO {
	public CategoriaDAOImp() {
		// Connection conn = generaPoolConexion();
		Connection conn = obtenerConexion();
	}
	@Override
	public List<Categoria> listarCategoria() {
		String query = "SELECT * FROM categoria";
		List<Categoria> list = new ArrayList<Categoria>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) { // mientras existan datos, continúa el ciclo
				Categoria categ = new Categoria(rs.getInt("id_categoria"), rs.getString("nombre_categoria"));
				list.add(categ);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	@Override
	public Categoria buscarCategoria(int idCategoria) {
		Categoria categoria = new Categoria();
		String query = "SELECT * FROM categoria WHERE id_categoria=?";

		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idCategoria); // setea el id Categoria
			rs = pstm.executeQuery();
			while (rs.next()) {

				categoria.setIdCategoria(rs.getInt("id_categoria"));
				categoria.setNombreCategoria(rs.getString("nombre_categoria"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoria;
	}
}
