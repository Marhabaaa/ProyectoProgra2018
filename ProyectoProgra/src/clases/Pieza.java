package clases;

public class Pieza {
    
	private String code;
    private String name;
    private int stock;

    public Pieza() {
    	code = "";
        name = "";
        stock = 0;
    }

    public Pieza(String code, String name, int stock) {
    	this.code = code;
    	this.name = name;
        this.stock = stock;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}

