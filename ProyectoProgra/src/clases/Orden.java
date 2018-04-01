package clases;

public class Orden {
    
    private String date_in;
    private String date_out;
    private int client_number;
    private int order_number;
    private int tec_number;
    private int price;
    private Pieza[] parts;

    public Orden(){
        date_in = "";  
        date_out = "";
        client_number = 0;
        tec_number = 0;
        order_number = 0;
        price = 0;
        parts = new Pieza[20];
    }

    public Orden(String date_in, String date_out, int client_number, int tec_number, int order_number, int price, Pieza[] parts) {
        this.date_in = date_in;
        this.date_out = date_out;
        this.client_number = client_number;
        this.tec_number = tec_number;
        this.order_number = order_number;
        this.price = price;
        this.parts = parts;
    }

	public String getDate_in() {
		return date_in;
	}

	public void setDate_in(String date_in) {
		this.date_in = date_in;
	}

	public String getDate_out() {
		return date_out;
	}

	public void setDate_out(String date_out) {
		this.date_out = date_out;
	}

	public int getClient_number() {
		return client_number;
	}

	public void setClient_number(int client_number) {
		this.client_number = client_number;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public int getTec_number() {
		return tec_number;
	}

	public void setTec_number(int tec_number) {
		this.tec_number = tec_number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Pieza[] getParts() {
		return parts;
	}

	public void setParts(Pieza[] parts) {
		this.parts = parts;
	}
}
