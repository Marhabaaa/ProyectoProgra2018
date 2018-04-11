package clases;

public class Tecnico extends Persona {
	
    private int tecNumber;
    private int ordersNum;	//cantidad de ordenes asignadas al momento
    private Orden[] orders;

    public Tecnico() {
		super();
		tecNumber = -1;
		setOrdersNum(0);
		orders = new Orden[5];	//5 es la cantidad maxima de ordenes que se le asigna a un tecnico
	}
    
    public Tecnico(String name, String rut, String phoneNumber, String eMail, int tecNumber, int ordersNum, Orden[] orders) {
		super(name, rut, phoneNumber, eMail);
		this.tecNumber = tecNumber;
		this.setOrdersNum(ordersNum);
		this.orders = orders;
	}
    
	public int getTecNumber() {
		return tecNumber;
	}
	
	public void setTecNumber(int tec_number) {
		this.tecNumber = tec_number;
	}
	
	public int getOrdersNum() {
		return ordersNum;
	}

	public void setOrdersNum(int orders_num) {
		this.ordersNum = orders_num;
	}
	
	public Orden[] getOrders() {
		return orders;
	}
	
	public void setOrders(Orden[] orders) {
		this.orders = orders;
	}
}
