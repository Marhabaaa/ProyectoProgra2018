package clases;

import java.util.Hashtable;

public class OrdersMap {
	private Hashtable<String, Orden> ordersMap;
	
	public OrdersMap() {
		ordersMap = new Hashtable<>();
	}
	
	public int size() {
		return ordersMap.size();
	}
	
	public void addOrder(String key, Orden order) {
		ordersMap.put(key, order);
	}
}
