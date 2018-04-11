package clases;

import java.sql.*;
import java.util.*;

import BDconnector.MySQLconnection;

public class SistemaServicioTecnico {

	private static MySQLconnection conn;
	private List stockMap;
	private Map ordersMap;
	private Map clientsMap;
	private List techList;
	private int orderNumber = 0; //variable para asignacion de numero de orden
	
	public SistemaServicioTecnico() throws SQLException {
		stockMap = getStockMap();
		ordersMap = new Map();
		clientsMap = new Map();
		techList = new List();
	}

	/*public SistemaServicioTecnico(StockMap stockMap, OrdersMap ordersMap, ClientsMap clientsMap, TechList techList,
			int orderNumber) {
		this.stockMap = stockMap;
		this.ordersMap = ordersMap;
		this.clientsMap = clientsMap;
		this.techList = techList;
		this.orderNumber = orderNumber;
	}*/
	
	/*public void showTest(int key) {
		//System.out.println("Name: " + ((Pieza) stockMap.get(key)).getDescription());
		if(stockMap.contains(key))
			System.out.println("SI");
		else
			System.out.println("NO");
	}*/

	public List getStockMap() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement = (PreparedStatement) connect.prepareStatement("SELECT * FROM inventario");
		ResultSet data = statement.executeQuery();
		List stockMap = new List();
		
		int code, cant, price, complex;
		String description;
		
		while(data.next()) {
			System.out.println("Cod: " + data.getObject("codPieza") + "   Descripcion: " + data.getObject("descripcion") + "   Cantidad: " + data.getObject("cant"));
			code = Integer.parseInt(data.getObject("codPieza").toString());
			description = data.getObject("descripcion").toString();
			cant = Integer.parseInt((String)data.getObject("cant").toString());
			price = 0;
			complex = 0;
			
			Pieza aux = new Pieza(code, description, cant, price, complex);
			
			stockMap.add(aux);
		}
		
		return stockMap;
	}
	
	public Map getOrdersMap() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement1 = (PreparedStatement) connect.prepareStatement("SELECT * FROM ordenes");
		PreparedStatement statement2 = (PreparedStatement) connect.prepareStatement("SELECT * FROM ");
		ResultSet data = statement1.executeQuery();
		Map ordersMap = new Map();
		
		int code;
		String description;
		int cant;
		while(data.next()) {
			//System.out.println("Cod: " + data.getObject("codPieza") + "   Descripcion: " + data.getObject("descripcion") + "   Cantidad: " + data.getObject("cant"));
			code = Integer.parseInt(data.getObject("codPieza").toString());
			description = data.getObject("descripcion").toString();
			cant = Integer.parseInt((String)data.getObject("cant").toString());
			
			//Orden aux = new Orden(code, description, cant);
			
			//ordersMap.addPart(aux);
		}
		
		return ordersMap;
	}
	
}
