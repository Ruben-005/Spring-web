package es.mvc.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		System.out.println(p.toString());
		
		return obtenerProductos(modelo);

	}
}
