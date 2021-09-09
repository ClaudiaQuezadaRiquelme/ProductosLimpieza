package cl.edutecno.model;

public class Categoria {
	int idCategoria;
	String nombreCategoria;
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categoria(int id_categoria, String nombre_categoria) {
		super();
		this.idCategoria = id_categoria;
		this.nombreCategoria = nombre_categoria;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int id_categoria) {
		this.idCategoria = id_categoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombre_categoria) {
		this.nombreCategoria = nombre_categoria;
	}
	@Override
	public String toString() {
		return "Categoria [id_categoria=" + idCategoria + ", nombre_categoria=" + nombreCategoria + "]";
	}
}
