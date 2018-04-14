package clases;

import java.sql.*;

import BDconnector.MySQLconnection;

public class SistemaServicioTecnico {

	private static MySQLconnection conn;
	private SMap stockMap;
	private SMap ordersMap;
	private SMap clientsMap;
	private SMap clientOrdersMap;
	private SMap techOrdersMap;
	private SMap OrderPartsMap;
	private SList techList;
	private int orderNumber;	//variable para asignacion de numero de orden
	private int techNumber;		//variable para asignacion de numero de tecnico
	
	public SistemaServicioTecnico() throws SQLException {
		stockMap = getStockMapFromDB();
		ordersMap = new SMap();
		setClientsMap(new SMap());
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
	
	public SMap getClientsMap() {
		return clientsMap;
	}

	public void setClientsMap(SMap clientsMap) {
		this.clientsMap = clientsMap;
	}
	
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
			
			stockMap.put(code, aux);
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
	
	public Tecnico leastWorkload() {
		if(techList.isEmpty())
			return null;
		
		int i = 1, least, auxLeast;
		Tecnico aux = (Tecnico) techList.get(0);
		least = aux.getWorkload();
		
		while(i < techList.size()) {
			auxLeast = ((Tecnico) techList.get(i)).getWorkload();
			if(auxLeast < least) {
				least = auxLeast;
				aux = (Tecnico) techList.get(i);
			}
			i++;
		}
		
		return aux;
	}
	
	public int getNewOrderNumber() {
		orderNumber++;
		return orderNumber;
	}
}
