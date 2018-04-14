package clases;

public class Cliente extends Persona {
    
    private boolean isBusiness;
    private int maxOrders;	//maximo numero de ordenes permitidas por cliente segun tipo de cliente
    private SList orders;

    
	public Cliente(int rut, String name, String phoneNumber, String eMail, boolean isBusiness, SList orders) {
		super(rut, name, phoneNumber, eMail);
		this.isBusiness = isBusiness;
		this.maxOrders = calculateMaxOrders(isBusiness);
		this.orders = orders;
	}

	public Cliente(int rut, String name, String phoneNumber, String eMail, boolean isBusiness) {
    	super(rut, name, phoneNumber, eMail);
    	this.setBusiness(isBusiness);
        this.maxOrders = calculateMaxOrders(isBusiness);
        orders = new SList();
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

	public SList getOrders() {
		return orders;
	}

	public void setOrders(SList orders) {
		this.orders = orders;
	}
	
	public int calculateMaxOrders(boolean isBusiness) {
		int max = 5;
        if(isBusiness)
            max = 20;
        
        return max;
	}
}