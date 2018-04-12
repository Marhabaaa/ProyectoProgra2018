package clases;

import java.sql.*;

import BDconnector.MySQLconnection;

public class SistemaServicioTecnico {

	private static MySQLconnection conn;
	private SMap stockMap;
	private SMap ordersMap;
	private SMap clientsMap;
	private SList techList;
	private int orderNumber = 0; //variable para asignacion de numero de orden
	
	public SistemaServicioTecnico() throws SQLException {
		stockMap = getStockMapFromDB();
		ordersMap = new SMap();
		clientsMap = new SMap();
		techList = new SList();
	}

	/*public SistemaServicioTecnico(StockMap stockMap, OrdersMap ordersMap, ClientsMap clientsMap, TechList techList,
			int orderNumber) {
		this.stockMap = stockMap;
		this.ordersMap = ordersMap;
		this.clientsMap = clientsMap;
		this.techList = techList;
		this.orderNumber = orderNumber;
	}*/
	
	public void showTest(int key) {
		System.out.println("Name: " + ((Pieza) stockMap.get(key)).getDescription());
	}
	
	public SMap getStockMap() {
		return stockMap;
	}
	
	public SMap getStockMapFromDB() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement = (PreparedStatement) connect.prepareStatement("SELECT * FROM inventario");
		ResultSet data = statement.executeQuery();
		SMap stockMap = new SMap();
		
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
			
			stockMap.add(code, aux);
		}
		
		return stockMap;
	}
	
	public SMap getOrdersMap() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement1 = (PreparedStatement) connect.prepareStatement("SELECT * FROM ordenes");
		PreparedStatement statement2 = (PreparedStatement) connect.prepareStatement("SELECT * FROM ");
		ResultSet data = statement1.executeQuery();
		SMap ordersMap = new SMap();
		
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
	
	public String[] getStockDescriptions() {
		int i = 0;
		SList list = stockMap.toSList();
		String[] s = new String[list.size()];
		
		while(i < list.size()) {
			s[i] = ((Pieza) list.get(i)).getDescription();
			i++;
		}
		
		return s;
	}
	
}
