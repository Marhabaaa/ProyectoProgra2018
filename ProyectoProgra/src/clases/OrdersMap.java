package clases;

import java.util.Hashtable;

public class OrdersMap {
	private Hashtable<Integer, Orden> ordersMap;
	
	public OrdersMap() {
		ordersMap = new Hashtable<>();
	}
	
	public int size() {
		return ordersMap.size();
	}
	
	public void addOrder(Orden order) {
		ordersMap.put(order.getNewOrderNumber(), order);
	}
	
}
