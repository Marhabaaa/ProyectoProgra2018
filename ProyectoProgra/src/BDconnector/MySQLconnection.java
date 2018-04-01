package BDconnector;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLconnection {
	
	private static Connection conn = null;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/inventario";
	private static final String user = "root";
	private static final String pass = "";
	
	public MySQLconnection() {
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, pass);
			
			if(conn != null)
				System.out.println("Conexion con BD exitosa");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el Driver");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("ERROR -> No se pudo establecer conexion");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void disconnection() {
		conn = null;
		
		if(conn == null)
			System.out.println("Conexion terminada");
	}
}
