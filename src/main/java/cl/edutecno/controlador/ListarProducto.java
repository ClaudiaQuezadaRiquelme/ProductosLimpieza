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
import cl.edutecno.dao.ProductoCategoriaDAOImp;
import cl.edutecno.model.ProductoCategoria;

@WebServlet("/ListarProducto")
public class ListarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductoCategoriaDAO categoriaDAO = new ProductoCategoriaDAOImp(); 
    
    public ListarProducto() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductoCategoria> listaPC = new ArrayList<ProductoCategoria>();
		listaPC = categoriaDAO.listarProductoCategoria();
		
		request.setAttribute("listaPC", listaPC);
		request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
