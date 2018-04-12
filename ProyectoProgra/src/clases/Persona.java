package clases;

public class Persona {
	
    protected String name;
    protected int rut;
    protected String phoneNumber;
    protected String eMail;
    
    public Persona() {
		name = "";
		rut = 0;
		phoneNumber = "";
		eMail = "";
	}
    
    public Persona(String name, int rut, String phoneNumber, String eMail) {
		this.name = name;
		this.rut = rut;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phone_number) {
		this.phoneNumber = phone_number;
	}

	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
}
