package clases;

public class Pieza {
	
	private int code;
    private String description;
    private int cant;

    public Pieza() {
    	code = 0;
        description = "";
        cant = 0;
    }

    public Pieza(int code, String name, int stock) {
    	this.code = code;
    	this.description = name;
        this.cant = stock;
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

