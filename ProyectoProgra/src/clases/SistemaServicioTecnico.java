package clases;

import java.util.*;

public class SistemaServicioTecnico {

	private Hashtable<Integer, Pieza> StockMap;
	private Hashtable<Integer, Orden> OrdersMap;
	private Hashtable<Integer, Cliente> ClientsMap;
	private ArrayList<Tecnico> TecList;
	
	public SistemaServicioTecnico(Hashtable<Integer, Pieza> stockMap, Hashtable<Integer, Orden> ordersMap,
			Hashtable<Integer, Cliente> clientsMap, ArrayList<Tecnico> tecList) {
		StockMap = stockMap;
		OrdersMap = ordersMap;
		ClientsMap = clientsMap;
		TecList = tecList;
	}
	
	public SistemaServicioTecnico() {
		StockMap = new Hashtable<Integer, Pieza>();
		OrdersMap = new Hashtable<Integer, Orden>();
		ClientsMap = new Hashtable<Integer, Cliente>();
		TecList = new ArrayList<>();
	}

	public Hashtable<Integer, Pieza> getStockMap() {
		return StockMap;
	}

	public void setStockMap(Hashtable<Integer, Pieza> stockMap) {
		StockMap = stockMap;
	}

	public Hashtable<Integer, Orden> getOrdersMap() {
		return OrdersMap;
	}

	public void setOrdersMap(Hashtable<Integer, Orden> ordersMap) {
		OrdersMap = ordersMap;
	}

	public Hashtable<Integer, Cliente> getClientsMap() {
		return ClientsMap;
	}

	public void setClientsMap(Hashtable<Integer, Cliente> clientsMap) {
		ClientsMap = clientsMap;
	}

	public ArrayList<Tecnico> getTecList() {
		return TecList;
	}

	public void setTecList(ArrayList<Tecnico> tecList) {
		TecList = tecList;
	}
}
