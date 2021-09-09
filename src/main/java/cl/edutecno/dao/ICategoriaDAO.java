package cl.edutecno.dao;

import java.util.List;

import cl.edutecno.model.Categoria;

public interface ICategoriaDAO {
	public List<Categoria> listarCategoria();
	public Categoria buscarCategoria(int idCategoria);
}
