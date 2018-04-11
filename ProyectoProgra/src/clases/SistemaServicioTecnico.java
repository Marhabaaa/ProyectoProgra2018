package clases;

import java.sql.*;
import java.util.*;

import BDconnector.MySQLconnection;

public class SistemaServicioTecnico {

	private static MySQLconnection conn;
	private StockMap stockMap;
	private OrdersMap ordersMap;
	private ClientsMap clientsMap;
	private TechList techList;
	private int orderNumber = 0; //variable para asignacion de numero de orden
	
	public SistemaServicioTecnico() throws SQLException {
		stockMap = getStockMap();
		ordersMap = new OrdersMap();
		clientsMap = new ClientsMap();
		techList = new TechList();
	}

	public SistemaServicioTecnico(StockMap stockMap, OrdersMap ordersMap, ClientsMap clientsMap, TechList techList,
			int orderNumber) {
		super();
		this.stockMap = stockMap;
		this.ordersMap = ordersMap;
		this.clientsMap = clientsMap;
		this.techList = techList;
		this.orderNumber = orderNumber;
	}

	public StockMap getStockMap() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement = (PreparedStatement) connect.prepareStatement("SELECT * FROM inventario");
		ResultSet data = statement.executeQuery();
		StockMap stockMap = new StockMap();
		
		int code;
		String description;
		int cant;
		while(data.next()) {
			//System.out.println("Cod: " + data.getObject("codPieza") + "   Descripcion: " + data.getObject("descripcion") + "   Cantidad: " + data.getObject("cant"));
			code = Integer.parseInt(data.getObject("codPieza").toString());
			description = data.getObject("descripcion").toString();
			cant = Integer.parseInt((String)data.getObject("cant").toString());
			
			Pieza aux = new Pieza(code, description, cant);
			
			stockMap.addPart(aux);
		}
		
		return stockMap;
	}
	
	public OrdersMap getOrdersMap() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement1 = (PreparedStatement) connect.prepareStatement("SELECT * FROM ordenes");
		PreparedStatement statement2 = (PreparedStatement) connect.prepareStatement("SELECT * FROM ");
		ResultSet data = statement1.executeQuery();
		OrdersMap ordersMap = new OrdersMap();
		
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
