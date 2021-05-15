package es.mvc.Modelo;

public class Producto {
	private String idProductos;
	private String nombreProducto;
	private double Precio;
	private String seccion;

	public String getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(String idProductos) {
		this.idProductos = idProductos;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

}
