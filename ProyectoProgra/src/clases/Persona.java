package clases;

public class Persona {
	
    protected String name;
    protected String rut;
    protected String phoneNumber;
    protected String eMail;
    
    public Persona() {
		name = "";
		rut = "";
		phoneNumber = "";
		eMail = "";
	}
    
    public Persona(String name, String rut, String phoneNumber, String eMail) {
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
	
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
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
