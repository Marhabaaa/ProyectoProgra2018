package clases;

import java.sql.*;
import java.util.Hashtable;

import BDconnector.MySQLconnection;

public class Main {

	static MySQLconnection conn;
	public static void main(String[] args) throws SQLException {
		
		SistemaServicioTecnico B = new SistemaServicioTecnico();
		
		//B.setStockMap(getStockMap());
		
		//System.out.println("Name: " + B.getStockMap().get(00004).getDescription());
		
	}
	
	public void newOrder() {
		String descripcion;
		String rut;
	
	}
	
	public static Hashtable<Integer, Pieza> getStockMap() throws SQLException {
		conn = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement = (PreparedStatement) connect.prepareStatement("SELECT * FROM stock");
		ResultSet data = statement.executeQuery();
		Hashtable<Integer, Pieza> StockMap = new Hashtable<Integer, Pieza>();
		
		int code;
		String description;
		int cant;
		while(data.next()) {
			//System.out.println("Cod: " + data.getObject("codPieza") + "   Descripcion: " + data.getObject("descripcion") + "   Cantidad: " + data.getObject("cant"));
			code = Integer.parseInt(data.getObject("codPieza").toString());
			description = data.getObject("descripcion").toString();
			cant = Integer.parseInt((String)data.getObject("cant").toString());
			
			Pieza aux = new Pieza(code, description, cant);
			
			StockMap.put(code, aux);
		}
		
		return StockMap;
	}
}
