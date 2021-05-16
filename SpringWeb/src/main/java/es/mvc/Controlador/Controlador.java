package es.mvc.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.mvc.Modelo.Producto;
import es.mvc.interfases.Productos;

@Controller
@ComponentScan("es.mvc.*")
@PropertySource("classpath:Datos.dat")
@RequestMapping
public class Controlador {

	@Autowired
	public Productos p;

	@RequestMapping
	public String obtenerProductos(Model modelo ) {
		
		modelo.addAttribute("productos", p.getProductos());

		return "ObtenerProductos";
	}

	@RequestMapping("/muestraFormularioInsertar")
	public String mustraFormularioInsertar(Model modelo) {
		Producto p = new Producto();
		
		modelo.addAttribute("producto", p);
		
		return "FormularioInsertar";
	}

	@RequestMapping("/insertarProductos")
	public String insertarProd(@ModelAttribute Producto prod, Model modelo) {
		p.InsertarProductos(prod);
		
		return obtenerProductos(modelo);

	}
	
	@RequestMapping("/cargarProductos")
	public String ActualizarUsuario(@RequestParam("id") String id,@RequestParam("nombre") String nombre,
									@RequestParam("precio") double precio,	@RequestParam("seccion") String seccion,Model modelo) {
		Producto prod  = new Producto();
		prod.setIdProductos(id);
		prod.setNombreProducto(nombre);
		prod.setPrecio(precio);
		prod.setSeccion(seccion);
	
		System.out.println(prod.toString());
		modelo.addAttribute("productos", prod);
		
		return "actualizarProductos";
	}
	
	@RequestMapping("/actuProductos")
	public String acutualizarProductos(@ModelAttribute Producto prod, Model modelo) {
		p.ActualizarProductos(prod);
		return obtenerProductos(modelo);
	}
}
