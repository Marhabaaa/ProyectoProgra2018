package clases;

import java.util.Hashtable;

public class ClientsMap {
	private Hashtable<String, Cliente> clientsMap;
	
	public ClientsMap() {
		clientsMap = new Hashtable<>();
	}

	public Hashtable<String, Cliente> getClientsMap() {
		return clientsMap;
	}

	public void setClientsMap(Hashtable<String, Cliente> clientsMap) {
		this.clientsMap = clientsMap;
	}
}
