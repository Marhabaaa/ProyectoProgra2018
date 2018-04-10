package clases;

import java.util.*;

public class Cliente extends Persona {
    
    private int client_number;
    private int client_type;
    private int max_orders;	//maximo numero de ordenes por cliente segun tipo de cliente
    private ArrayList<Orden> orders;
            
    public Cliente(int client_type) {	//constructor nulo
    	super();
        client_number = 0;
        this.client_type = client_type;
        
        max_orders = 5;
        
        if(client_type == 1)
            max_orders = 20;
        
        orders = new ArrayList<Orden>(2);
    }
   
    public Cliente(String name, String phone_number, String e_mail, int client_number, int client_type, ArrayList<Orden> orders) {
    	super(name, phone_number, e_mail);
    	this.client_number = client_number;
    	this.client_type = client_type;
    	
        if(client_type == 1)
            max_orders = 20;
        
        this.orders = orders;
    }

	public int getClient_number() {
		return client_number;
	}

	public void setClient_number(int client_number) {
		this.client_number = client_number;
	}

	public int getClient_type() {
		return client_type;
	}

	public void setClient_type(int client_type) {
		this.client_type = client_type;
	}

	public int getMax_orders() {
		return max_orders;
	}

	public void setMax_orders(int max_orders) {
		this.max_orders = max_orders;
	}

	public ArrayList<Orden> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Orden> orders) {
		this.orders = orders;
	}
	
	
}
