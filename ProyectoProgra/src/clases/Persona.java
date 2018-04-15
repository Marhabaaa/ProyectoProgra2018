package clases;

public class Persona {
	
	protected int 	 rut;
    protected String name;
    protected String phoneNumber;
    protected String eMail;
    
    public Persona(int rut, String name, String phoneNumber, String eMail) {
    	this.rut 		 = rut;
    	this.name 		 = name;
		this.phoneNumber = phoneNumber;
		this.eMail 		 = eMail;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
