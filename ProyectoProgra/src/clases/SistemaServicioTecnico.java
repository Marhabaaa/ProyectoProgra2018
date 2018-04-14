package clases;

import java.sql.*;

import BDconnector.MySQLconnection;

public class SistemaServicioTecnico {

	private static MySQLconnection conn;
	private SMap stockMap;
	private SMap orderPartsMap;
	private SMap ordersMap;
	private SMap clientOrdersMap;
	private SMap techOrdersMap;
	private SMap clientsMap;
	private SMap techsMap;
	private int orderNumber;	//variable para asignacion de numero de orden
	private int techNumber;		//variable para asignacion de numero de tecnico
	
	public SistemaServicioTecnico() throws SQLException {
		stockMap = getStockMapFromDB();
		orderPartsMap = getOrderPartsMapFromDB();
		ordersMap = getOrdersMapFromDB();
		clientOrdersMap = getClientOrdersMap();
		techOrdersMap = getTechOrdersMap();
		clientsMap = getClientsMapFromDB();
		techsMap = getTechsMapFromDB();
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
			price = Integer.parseInt((String)data.getObject("precioUnit").toString());;
			complex = Integer.parseInt((String)data.getObject("complejidad").toString());;
			
			Pieza aux = new Pieza(code, description, cant, price, complex);
			
			stockMap.put(code, aux);
		}
		
		return stockMap;
	}
	
	public SMap getOrderPartsMapFromDB() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement = (PreparedStatement) connect.prepareStatement("SELECT * FROM orderParts");
		ResultSet data = statement.executeQuery();
		SMap orderPartsMap = new SMap();
		
		int orderNumber, pieceCode, cant;
		
		while(data.next()) {
			System.out.println("orderNumber: " + data.getObject("orderNumber") + "   pieceCode: " + data.getObject("codPieza") + "   Cantidad: " + data.getObject("cant"));
			orderNumber = Integer.parseInt(data.getObject("orderNumber").toString());
			pieceCode = Integer.parseInt(data.getObject("codPieza").toString());
			cant = Integer.parseInt((String)data.getObject("cant").toString());
			
			Pieza aux = (Pieza) stockMap.get(pieceCode);
			
			if(!orderPartsMap.contains(orderNumber)) {
				SList partsList = new SList();
				orderPartsMap.put(orderNumber, partsList);
			}
			
			if(aux != null) {
				aux.setCant(cant);
				((SList) orderPartsMap.get(orderNumber)).add(aux);
			}
		}
		
		return orderPartsMap;
	}
	
	public SMap getOrdersMapFromDB() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement1 = (PreparedStatement) connect.prepareStatement("SELECT * FROM ordenes");
		ResultSet data = statement1.executeQuery();
		SMap ordersMap = new SMap();
		
		int orderNumber, clientRut, techNumber, price, complex;
		String description, dateIn, dateOut;
		boolean checked, done;
		
		while(data.next()) {
			orderNumber = Integer.parseInt(data.getObject("orderNumber").toString());
			description = data.getObject("descripcion").toString();
			dateIn = data.getObject("dateIn").toString();
			dateOut = data.getObject("dateOut").toString();
			clientRut = Integer.parseInt(data.getObject("clientRut").toString());
			techNumber = Integer.parseInt(data.getObject("techNumber").toString());
			price = Integer.parseInt(data.getObject("precio").toString());
			complex = Integer.parseInt(data.getObject("complejidad").toString());
			checked = false;
			if(data.getObject("revisada").toString() == "true")
				checked = true;
			done = false;
			if(data.getObject("terminada").toString() == "true")
				done = true;
			
			SList partsList = (SList) orderPartsMap.get(orderNumber);
			Orden aux = new Orden(orderNumber, description, dateIn, dateOut, clientRut, techNumber, price, partsList, complex, checked, done);
			
			ordersMap.put(orderNumber, aux);
		}
		
		return ordersMap;
	}
	
	public SMap getClientOrdersMap() {
		int i = 0;
		SList ordersList = ordersMap.toSList();
		Orden aux;
		SMap clientOrdersMap = new SMap();
		
		while(i < ordersList.size()) {
			aux = (Orden) ordersList.get(i);
			
			if(!clientOrdersMap.contains(aux.getClientRut())) {
				SList auxL = new SList();
				clientOrdersMap.put(aux.getClientRut(), auxL);
			}
			
			((SList) clientOrdersMap.get(aux.getClientRut())).add(aux);
			i++;
		}
		
		return clientOrdersMap;
	}
	
	public SMap getTechOrdersMap() {
		int i = 0;
		SList ordersList = ordersMap.toSList();
		Orden aux;
		SMap techOrdersMap = new SMap();
		
		while(i < ordersList.size()) {
			aux = (Orden) ordersList.get(i);
			
			if(!techOrdersMap.contains(aux.getTechNumber())) {
				SList auxL = new SList();
				techOrdersMap.put(aux.getTechNumber(), auxL);
			}
			
			((SList) techOrdersMap.get(aux.getTechNumber())).add(aux);
			i++;
		}
		
		return techOrdersMap;
	}
	
	public SMap getClientsMapFromDB() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement1 = (PreparedStatement) connect.prepareStatement("SELECT * FROM clientes");
		ResultSet data = statement1.executeQuery();
		SMap clientsMap = new SMap();
		
		int rut;
		String name, phoneNumber, eMail;
		boolean isBusiness;
		
		while(data.next()) {
			rut = Integer.parseInt(data.getObject("rut").toString());
			name = data.getObject("nombre").toString();
			phoneNumber = data.getObject("telefono").toString();
			eMail = data.getObject("eMail").toString();
			isBusiness = false;
			if(data.getObject("esEmpresa").toString() == "true")
				isBusiness = true;
			
			SList orders = (SList) clientOrdersMap.get(rut);
			if(orders == null) {
				orders = new SList();
			}
			Cliente aux = new Cliente(rut, name, phoneNumber, eMail, isBusiness, orders);
			
			clientsMap.put(rut, aux);
		}
		
		return clientsMap;
	}
	
	public SMap getTechsMapFromDB() throws SQLException {
		conn  = new MySQLconnection();
		Connection connect = conn.getConnection();
		PreparedStatement statement1 = (PreparedStatement) connect.prepareStatement("SELECT * FROM tecnicos");
		ResultSet data = statement1.executeQuery();
		SMap techsMap = new SMap();
		
		int rut, techNumber, dwh, workload;
		String name, phoneNumber, eMail;
		
		while(data.next()) {
			rut = Integer.parseInt(data.getObject("rut").toString());
			name = data.getObject("nombre").toString();
			phoneNumber = data.getObject("telefono").toString();
			eMail = data.getObject("eMail").toString();
			techNumber = Integer.parseInt(data.getObject("tecNumber").toString());
			dwh = Integer.parseInt(data.getObject("dwh").toString());
			workload = Integer.parseInt(data.getObject("workload").toString());
			
			SList orders = (SList) techOrdersMap.get(techNumber);
			if(orders == null) {
				orders = new SList();
			}
			Tecnico aux = new Tecnico(rut, name, phoneNumber, eMail, techNumber, dwh, orders, workload);
			
			techsMap.put(rut, aux);
		}
		
		return techsMap;
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
		SList techsList = techsMap.toSList();
		if(techsList.isEmpty())
			return null;
		
		int i = 1, least, auxLeast;
		Tecnico aux = (Tecnico) techsList.get(0);
		least = aux.getWorkload();
		
		while(i < techsList.size()) {
			auxLeast = ((Tecnico) techsList.get(i)).getWorkload();
			if(auxLeast < least) {
				least = auxLeast;
				aux = (Tecnico) techsList.get(i);
			}
			i++;
		}
		
		return aux;
	}
	
	public int getNewOrderNumber() {
		orderNumber++;
		return orderNumber;
	}
	
	public int getNewTechNumber() {
		techNumber++;
		return techNumber;
	}
}
