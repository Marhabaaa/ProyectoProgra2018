package clases;

public class Tecnico extends Persona {
	private String rut;
    private int tec_number;
    private int orders_num;	//cantidad de ordenes asignadas al momento
    private Orden[] orders;

    public Tecnico() {
		super();
		rut = "";
		tec_number = -1;
		setOrders_num(0);
		orders = new Orden[5];	//5 es la cantidad maxima de ordenes que se le asigna a un tecnico
	}
    
    public Tecnico(String name, String phone_number, String e_mail, String rut, int tec_number, int orders_num, Orden[] orders) {
		super(name, phone_number, e_mail);
		this.rut = rut;
		this.tec_number = tec_number;
		this.setOrders_num(orders_num);
		this.orders = orders;
	}
    
	public String getRut() {
		return rut;
	}
	
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public int getTec_number() {
		return tec_number;
	}
	
	public void setTec_number(int tec_number) {
		this.tec_number = tec_number;
	}
	
	public int getOrders_num() {
		return orders_num;
	}

	public void setOrders_num(int orders_num) {
		this.orders_num = orders_num;
	}
	
	public Orden[] getOrders() {
		return orders;
	}
	
	public void setOrders(Orden[] orders) {
		this.orders = orders;
	}
}
