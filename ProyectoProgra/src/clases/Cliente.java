package clases;

import java.util.*;

public class Cliente extends Persona {
    
    private int clientType;
    private int maxOrders;	//maximo numero de ordenes por cliente segun tipo de cliente
    private Map orders;
            
    public Cliente(int clientType) {	//constructor nulo
    	super();
        this.clientType = clientType;
        
        maxOrders = 5;
        
        if(clientType == 1)
            maxOrders = 20;
        
        orders = new Map();
    }
   
    public Cliente(String name, String rut, String phoneNumber, String eMail, int clientType) {
    	super(name, rut, phoneNumber, eMail);
    	this.clientType = clientType;
    	
        if(clientType == 1)
            maxOrders = 20;
        orders = new Map();
    }

	public int getClientType() {
		return clientType;
	}

	public void setClientType(int clientType) {
		this.clientType = clientType;
	}

	public int getMaxOrders() {
		return maxOrders;
	}

	public void setMaxOrders(int maxOrders) {
		this.maxOrders = maxOrders;
	}

	public Map getOrders() {
		return orders;
	}

	public void setOrders(Map orders) {
		this.orders = orders;
	}
	
	public boolean addOrder(Orden order) {
		if(orders.size() < maxOrders) {
			orders.add(order.getOrderNumber(), order);
			return true;
		}
		return false;
	}
	
	public void showReport() {
		
	}
}
