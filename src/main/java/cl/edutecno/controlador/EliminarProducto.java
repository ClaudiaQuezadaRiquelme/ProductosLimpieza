package cl.edutecno.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.edutecno.dao.IProductoCategoriaDAO;
import cl.edutecno.dao.IProductoDAO;
import cl.edutecno.dao.ProductoCategoriaDAOImp;
import cl.edutecno.dao.ProductoDAOImp;
import cl.edutecno.model.ProductoCategoria;

@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IProductoCategoriaDAO categoriaProductoDAO = new ProductoCategoriaDAOImp();
    private IProductoDAO productoDAO = new ProductoDAOImp();

    public EliminarProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductoCategoria> listaPC = new ArrayList<ProductoCategoria>();
		listaPC = categoriaProductoDAO.listarProductoCategoria();
		request.setAttribute("listaPC", listaPC);
		request.getRequestDispatcher("eliminarProducto.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productoDAO.eliminarProducto(Integer.parseInt(request.getParameter("id_producto")));
		doGet(request,response);
	}

}
