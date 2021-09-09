package cl.edutecno.model;

public class Producto {
	
	int idProducto;
	String nombreProducto;
	int precioProducto;
	String descripcionProducto;
	int idCategoria;
	
	
	public Producto(int IdProducto, String nombre_producto, int precio_producto, String descripcion_producto,
			int id_categoria) {
		super();
		this.idProducto = IdProducto;
		this.nombreProducto = nombre_producto;
		this.precioProducto = precio_producto;
		this.descripcionProducto = descripcion_producto;
		this.idCategoria = id_categoria;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int IdProducto) {
		this.idProducto = IdProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombre_producto) {
		this.nombreProducto = nombre_producto;
	}
	public int getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(int precio_producto) {
		this.precioProducto = precio_producto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcion_producto) {
		this.descripcionProducto = descripcion_producto;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int id_categoria) {
		this.idCategoria = id_categoria;
	}
	@Override
	public String toString() {
		return "Producto [IdProducto=" + idProducto + ", nombre_producto=" + nombreProducto + ", precio_producto="
				+ precioProducto + ", descripcion_producto=" + descripcionProducto + ", id_categoria=" + idCategoria
				+ "]";
	}
}
