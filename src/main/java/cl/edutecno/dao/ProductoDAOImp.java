package cl.edutecno.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.edutecno.conexionDB.ProcesaConexionDB;
import cl.edutecno.model.Categoria;
import cl.edutecno.model.Producto;

public class ProductoDAOImp extends ProcesaConexionDB implements IProductoDAO {

	@Override
	public List<Producto> listarProducto() {
		String query = "SELECT * FROM producto";
		// hacemosun recorrido
		List<Producto> productos = new ArrayList<Producto>();
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(rs.getInt("id_producto"));
				producto.setNombreProducto(rs.getString("nombre_producto"));
				producto.setPrecioProducto(rs.getInt("precio_producto"));
				producto.setDescripcionProducto(rs.getString("descripcion_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				productos.add(producto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;

	}

	@Override
	public Producto buscarProducto(int idProducto) {
		Producto producto = new Producto();
		String query = "SELECT * FROM producto WHERE id_producto=?";

		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idProducto); // setea el id producto
			rs = pstm.executeQuery();// Consulyta BBDD (SELECT)
			while (rs.next()) {

				producto.setIdProducto(rs.getInt("id_producto"));
				producto.setNombreProducto(rs.getString("nombre_producto"));
				producto.setPrecioProducto(rs.getInt("precio_producto"));
				producto.setDescripcionProducto(rs.getString("descripcion_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public int agregarProducto(Producto producto) {

		String query = "insert into producto values(NULL,?,?,?,?)";
		int result = 0;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, producto.getNombreProducto());
			pstm.setInt(2, producto.getPrecioProducto());
			pstm.setString(3, producto.getDescripcionProducto());
			pstm.setInt(4, producto.getIdCategoria());
			result = pstm.executeUpdate();// Ejecuta una acutalizacion en la BASE DE DATOS
			if (result == 1) {
				System.out.println("Producto agregado");
			} else {
				System.out.println("Producto NO agregado");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		String query = "UPDATE producto SET nombre_producto =?, precio_producto =?, descripcion_producto =?,id_categoria=? WHERE id_producto =?";
		// UPDATE categoria SET nombre_categoria='Hogar' WHERE id_categoria=1;
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, producto.getNombreProducto());
			pstm.setInt(2, producto.getPrecioProducto());
			pstm.setString(3, producto.getDescripcionProducto());
			pstm.setInt(4, producto.getIdCategoria());
			pstm.setInt(5, producto.getIdProducto());
			int result = pstm.executeUpdate();// Ejecuta una acutalizacion en la BASE DE DATOS
			// Execute query: consulta BBDD,EXECUTE UPDATE: Actualiza o elimina algun
			// registro en la BBDD
			if (result == 1) {
				System.out.println("Producto agregado");
			} else {
				System.out.println("Producto NO agregado");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean eliminarProducto(int idProducto) {
		String query = "delete from producto where id_producto=?";
		boolean resultado = false;
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idProducto);// Aca asigno el Id de la query
			int result = pstm.executeUpdate();// ejecicion de la query
			if (result == 1) { //verificiacion del resultado de la query
				resultado = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;

	}

}
