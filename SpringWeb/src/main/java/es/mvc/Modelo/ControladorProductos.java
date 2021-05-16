package es.mvc.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import es.mvc.interfases.Productos;

@Component
public class ControladorProductos implements Productos{
	
	@Value("${url}")
	private String url;
	
	@Value("${user}")
	private String user;
	
	@Value("${pass}")
	private String pass;
	
	private String sql;
	
	private Connection con;
	private ResultSet rs;
	private Statement st;
	
	@PostConstruct
	private void iniciarBean() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	private void destruirBean() {
		try {
			rs = null;
			st = null;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Producto> getProductos() {
		// TODO Auto-generated method stub
		rs = null;
		st = null;
		ArrayList<Producto> prod = new ArrayList<Producto>();
		sql = "select * from productos";
		try {
			st  = con.createStatement();
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Producto p  = new Producto();
				p.setIdProductos(rs.getString(1));
				p.setNombreProducto(rs.getString(2));
				p.setPrecio(rs.getDouble(3));
				p.setSeccion(rs.getString(4));
				prod.add(p);
			}
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return null;
		}
		
		return prod;
	}

	@Override
	public void InsertarProductos(Producto prod) {
		// TODO Auto-generated method stub
		sql = "insert into productos(idProducto, nombreProducto, Precio, Seccion) value (?,?,?,?)";
		try {
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, prod.getIdProductos());
			ps.setString(2, prod.getNombreProducto());
			ps.setDouble(3, prod.getPrecio());
			ps.setString(4, prod.getSeccion());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void ActualizarProductos(Producto prod) {
		// TODO Auto-generated method stub
		sql = "UPDATE productos set nombreProducto = ?, Precio = ?, Seccion = ? where idProducto = ?";
		try {
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, prod.getNombreProducto());
			ps.setDouble(2, prod.getPrecio());
			ps.setString(3, prod.getSeccion());
			
			ps.setString(4, prod.getIdProductos());
			
			ps.executeUpdate();
			
			System.out.println(prod.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
