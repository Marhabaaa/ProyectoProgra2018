package clases;

public class Tecnico extends Persona {
	
    private int tecNumber;
    private int workload;	//cantidad de trabajo asignada al momento
    private List orders;

    public Tecnico() {
		super();
		tecNumber = getNewTechNumber();
		workload = 0;
		orders = new List();
	}
    
    public Tecnico(String name, String rut, String phoneNumber, String eMail, int tecNumber, int workload) {
		super(name, rut, phoneNumber, eMail);
		this.tecNumber = tecNumber;
		this.workload = workload;
		this.orders = new List();
	}
    
	public int getTecNumber() {
		return tecNumber;
	}
	
	public void setTecNumber(int tec_number) {
		this.tecNumber = tec_number;
	}
	
	public int getWorkload() {
		return workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
	}
	
	public List getOrders() {
		return orders;
	}
	
	public void setOrders(List orders) {
		this.orders = orders;
	}
	
	public int getNewTechNumber() {
		tecNumber++;
		return tecNumber;
	}
	
}
