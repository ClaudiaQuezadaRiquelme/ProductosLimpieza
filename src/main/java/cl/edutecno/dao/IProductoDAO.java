package cl.edutecno.dao;

import java.util.List;

import cl.edutecno.model.Producto;

public interface IProductoDAO {

	public List<Producto> listarProducto();
	public Producto buscarProducto(int idProducto);
	public int agregarProducto(Producto producto);
	public Producto modificarProducto(Producto producto);
	public boolean eliminarProducto(int idProducto);
}
