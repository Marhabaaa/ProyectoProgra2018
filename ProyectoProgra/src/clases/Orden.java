package clases;

import java.util.ArrayList;

public class Orden {
    
	private String description; //descripcion del problema del aparato
    private String dateIn;
    private String dateOut;
    private int clientRut;
    private int orderNumber = 0; //numero de orden asignado automaticamente
    private int tecNumber;
    private int price;
    private PartsList partsList;

    public Orden(){
        dateIn = "";  
        dateOut = "";
        clientRut = 0;
        tecNumber = 0;
        orderNumber = 0;
        price = 0;
        partsList = new PartsList();
    }

    public Orden(String dateIn, String dateOut, int clientRut, int tecNumber, int orderNumber, int price) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.clientRut = clientRut;
        this.tecNumber = tecNumber;
        this.orderNumber = orderNumber;
        this.price = price;
        this.partsList = new PartsList();
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateIn() {
		return dateIn;
	}

	public void setDateIn(String dateIn) {
		this.dateIn = dateIn;
	}

	public String getDateOut() {
		return dateOut;
	}

	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}

	public int getClientRut() {
		return clientRut;
	}

	public void setClientRut(int clientRut) {
		this.clientRut = clientRut;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getTecNumber() {
		return tecNumber;
	}

	public void setTecNumber(int tecNumber) {
		this.tecNumber = tecNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public PartsList getPartsList() {
		return partsList;
	}

	public void setPartsList(PartsList partsList) {
		this.partsList = partsList;
	}
	
	public int getNewOrderNumber() {
		orderNumber++;
		return orderNumber;
	}
	
	public void addPiece(Pieza part) {
		partsList.addPart(part);
	}
}
