package BDconnector;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLconnection {
	
	private static Connection conn = null;
	private static final String driver = "com.mysql.jdbc.Driver";
	/*
	 * private static final String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10232157";
	 * private static final String user = "sql10232157";
	 * private static final String pass = "1PnqXRpAyj";
	*/
	
	/*
	 * private static final String url = "jdbc:mysql://db4free.net:3307/proyectoprogra18";
	 * private static final String user = "marhaba";
	 * private static final String pass = "gatitos476";
	*/
	
	private static final String url = "jdbc:mysql://proyectoprogra2018.ml:3306/natural1_proyect";
	private static final String user = "natural1";
	private static final String pass = "ssk2Qw580Q";
	
	public MySQLconnection() {
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, pass);
			
			//if(conn != null)
				//System.out.println("Conexion con BD exitosa");
			
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
