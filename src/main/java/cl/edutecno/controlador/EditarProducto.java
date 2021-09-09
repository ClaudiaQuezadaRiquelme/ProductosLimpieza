package cl.edutecno.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.edutecno.dao.CategoriaDAOImp;
import cl.edutecno.dao.IProductoCategoriaDAO;
import cl.edutecno.dao.IProductoDAO;
import cl.edutecno.dao.ProductoCategoriaDAOImp;
import cl.edutecno.dao.ProductoDAOImp;
import cl.edutecno.model.Categoria;
import cl.edutecno.model.Producto;
import cl.edutecno.model.ProductoCategoria;

@WebServlet("/EditarProducto")
public class EditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductoCategoriaDAO categoriaProductoDAO = new ProductoCategoriaDAOImp();
    private IProductoDAO productoDAO = new ProductoDAOImp();
    private CategoriaDAOImp categoriaDAO = new CategoriaDAOImp();
       
    public EditarProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> listaCat = new ArrayList<Categoria>();
		listaCat = categoriaDAO.listarCategoria();
		request.setAttribute("listaCat", listaCat);
		
		List<ProductoCategoria> listaPC = new ArrayList<ProductoCategoria>();
		listaPC = categoriaProductoDAO.listarProductoCategoria();
		request.setAttribute("listaPC", listaPC);
		request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto prod = new Producto();
		prod.setIdProducto(Integer.parseInt(request.getParameter("id_producto")));
		prod.setIdCategoria(Integer.parseInt(request.getParameter("categoria_producto")));
		prod.setNombreProducto(request.getParameter("nombre_producto"));
		prod.setDescripcionProducto(request.getParameter("descripcion_producto"));
		prod.setPrecioProducto(Integer.parseInt(request.getParameter("precio_producto")));
		productoDAO.modificarProducto(prod);
		request.getRequestDispatcher("ListarProducto").forward(request, response);
	}

}
