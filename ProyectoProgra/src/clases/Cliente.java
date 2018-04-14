package clases;

public class Cliente extends Persona {
    
    private boolean isBusiness;
    private int maxOrders;	//maximo numero de ordenes permitidas por cliente segun tipo de cliente
    private SMap orders;

	public Cliente(int rut, String name, String phoneNumber, String eMail, boolean isBusiness) {
    	super(rut, name, phoneNumber, eMail);
    	this.setBusiness(isBusiness);
    	
    	maxOrders = 5;
        if(isBusiness)
            maxOrders = 20;
        
        orders = new SMap();
    }
	
    public boolean isBusiness() {
		return isBusiness;
	}
	public void setBusiness(boolean isBusiness) {
		this.isBusiness = isBusiness;
	}
	
	public int getMaxOrders() {
		return maxOrders;
	}

	public void setMaxOrders(int maxOrders) {
		this.maxOrders = maxOrders;
	}

	public SMap getOrders() {
		return orders;
	}

	public void setOrders(SMap orders) {
		this.orders = orders;
	}
	
	public boolean addOrder(Orden order) {
		if(orders.size() < maxOrders) {
			orders.put(order.getOrderNumber(), order);
			return true;
		}
		return false;
	}
	
	public void showReport() {
		
	}
}
