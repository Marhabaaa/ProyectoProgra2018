package clases;

public class Pieza {
	
	private int code;
    private String description;
    private int cant;
    private int price;
    private int complex;

    public Pieza() {
    	code = 0;
        description = "";
        cant = 0;
        price = 0;
        complex = 0;
    }

    public Pieza(int code, String name, int stock, int price, int complex) {
    	this.code = code;
    	this.description = name;
        this.cant = stock;
        this.price = price;
        this.complex = complex;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int stock) {
		this.cant = stock;
	}
	
}

