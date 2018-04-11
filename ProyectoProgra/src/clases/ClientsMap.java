package clases;

import java.util.Hashtable;

public class ClientsMap {
	private Hashtable<String, Cliente> clientsMap;
	
	public ClientsMap() {
		clientsMap = new Hashtable<>();
	}

	public boolean clientsExist(String rut) {
		return clientsMap.containsKey(rut);
	}
	
	public boolean addClient(Cliente client) {
		clientsMap.put(client.getRut(), client);
		return true;
	}
	
	public boolean addOrderToClient(String rut, Orden order) {
		if(clientsMap.containsKey(rut)) {
			Cliente aux = (Cliente) clientsMap.get(rut);
			aux.addOrder(order);
			return true;
		}
		return false;
	}
	
}
