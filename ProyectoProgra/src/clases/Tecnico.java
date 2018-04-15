package clases;

public class Tecnico extends Persona {
	
    private int 	techNumber;
    private int 	dwh;	//daily working hours; horas de trabajo diario de tecnico segun contrato
    private SList 	orders;
    private int 	workload;	//cantidad de trabajo asignada al momento

    
    public Tecnico(int rut, String name, String phoneNumber, String eMail, int tecNumber, int dwh, SList orders, int workload) {
		super(rut, name, phoneNumber, eMail);
		this.techNumber = tecNumber;
		this.dwh 		= dwh;
		this.orders 	= orders;
		this.workload 	= workload;
	}

	public Tecnico(int rut, String name, String phoneNumber, String eMail, int tecNumber, int dwh) {
		super(rut, name, phoneNumber, eMail);
		this.techNumber = tecNumber;
		this.dwh 		= dwh;
		this.orders 	= new SList();
		this.workload 	= 0;
	}
    
	public int getTechNumber() {
		return techNumber;
	}
	
	public void setTechNumber(int tec_number) {
		this.techNumber = tec_number;
	}
	
	public int getDwh() {
		return dwh;
	}

	public void setDwh(int dwh) {
		this.dwh = dwh;
	}

	public int getWorkload() {
		return workload;
	}

	public void setWorkload() {
		this.workload = calculateWorkload();
	}
	
	public SList getOrders() {
		return orders;
	}
	
	public void setOrders(SList orders) {
		this.orders = orders;
	}
	
	public int getNewTechNumber() {
		techNumber++;
		return techNumber;
	}
	
	public void addOrder(Orden order) {	//agrega orden y a la vez retorna dias de retraso de entrega de esta
		orders.add(order);
		setWorkload();
	}
	
	public int calculateWorkload() {
		int i = 0, sum = 0;
		
		while(i < orders.size()) {
			sum += ((Orden) orders.get(i)).getComplex();
			i++;
		}
		
		return sum;
	}
	
	public int estimateDateOut(int orderComplexity) {
		int delay = 0, sum = workload + orderComplexity;
		
		while(sum / dwh > 1) {
			delay++;
			sum -= dwh;
		}
		
		return delay;
	}
}
