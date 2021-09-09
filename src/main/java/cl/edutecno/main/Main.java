package cl.edutecno.main;

import java.util.List;

import cl.edutecno.dao.CategoriaDAOImp;
import cl.edutecno.model.Categoria;

public class Main {

	public static void main(String[] args) {
		CategoriaDAOImp pruebaCategoriaDAO = new CategoriaDAOImp();
		List<Categoria> list = pruebaCategoriaDAO.listarCategoria();
		System.out.println(list);
	}

}
