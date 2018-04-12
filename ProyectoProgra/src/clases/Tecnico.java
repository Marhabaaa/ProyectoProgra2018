package clases;

public class Tecnico extends Persona {
	
    private int tecNumber;
    private int workload;	//cantidad de trabajo asignada al momento
    private SList orders;

    public Tecnico() {
		super();
		tecNumber = getNewTechNumber();
		workload = 0;
		orders = new SList();
	}
    
    public Tecnico(String name, int rut, String phoneNumber, String eMail, int tecNumber, int workload) {
		super(name, rut, phoneNumber, eMail);
		this.tecNumber = tecNumber;
		this.workload = workload;
		this.orders = new SList();
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
	
	public SList getOrders() {
		return orders;
	}
	
	public void setOrders(SList orders) {
		this.orders = orders;
	}
	
	public int getNewTechNumber() {
		tecNumber++;
		return tecNumber;
	}
	
}
