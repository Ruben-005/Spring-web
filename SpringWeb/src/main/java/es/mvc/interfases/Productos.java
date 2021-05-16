package es.mvc.interfases;

import java.util.ArrayList;

import es.mvc.Modelo.Producto;

public interface Productos {

	public ArrayList<Producto> getProductos();
	public void InsertarProductos(Producto p);
	void ActualizarProductos(Producto prod);
	public void eliminarProductos(String id);
	
}
