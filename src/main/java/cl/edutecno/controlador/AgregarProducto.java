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
import cl.edutecno.dao.ProductoDAOImp;
import cl.edutecno.model.Categoria;
import cl.edutecno.model.Producto;


@WebServlet("/AgregarProducto")
public class AgregarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAOImp categoriaDAO = new CategoriaDAOImp();
	private ProductoDAOImp productoDAO = new ProductoDAOImp();
       
    public AgregarProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		listaCategoria = categoriaDAO.listarCategoria();
		request.setAttribute("listaCategoria", listaCategoria);
		request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto prod = new Producto();
		prod.setIdProducto(0);
		prod.setNombreProducto(request.getParameter("nombre_producto"));
		prod.setPrecioProducto(Integer.parseInt( request.getParameter("precio_producto") ) );
		prod.setDescripcionProducto(request.getParameter("descripcion_producto"));
		prod.setIdCategoria(Integer.parseInt( request.getParameter("categoria_producto") ) );
		int retorno = productoDAO.agregarProducto(prod);
		if (retorno == 1) { // éxito
			request.getRequestDispatcher("ListarProducto").forward(request, response);
		}
	}

}
