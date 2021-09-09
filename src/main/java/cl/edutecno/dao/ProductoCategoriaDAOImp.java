package cl.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import cl.edutecno.model.Producto;
import cl.edutecno.model.ProductoCategoria;

public class ProductoCategoriaDAOImp implements IProductoCategoriaDAO {

	@Override
	public List<ProductoCategoria> listarProductoCategoria() {
		List<ProductoCategoria> listaProductoCategoria = new ArrayList<ProductoCategoria>();
		List<Producto> listaProducto = new ArrayList<Producto>();
		
		try {
			ProductoDAOImp productoDAO = new ProductoDAOImp();
			CategoriaDAOImp categoriaDAO = new CategoriaDAOImp();
			listaProducto = productoDAO.listarProducto();
			
			for (Producto productoTemp : listaProducto) {
				ProductoCategoria productoCategoria = new ProductoCategoria();
				productoCategoria.setProducto(productoTemp);
				productoCategoria.setCategoria( categoriaDAO.buscarCategoria( productoTemp.getIdCategoria() ) );
				listaProductoCategoria.add(productoCategoria);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProductoCategoria;
	}
	
}
