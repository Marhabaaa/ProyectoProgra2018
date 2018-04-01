package clases;

public class Persona {
    protected String name;
    protected String phone_number;
    protected String e_mail;
	
    public Persona() {
		name = "";
		phone_number = "";
		e_mail = "";
	}
    
    public Persona(String name, String phone_number, String e_mail) {
		this.name = name;
		this.phone_number = phone_number;
		this.e_mail = e_mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}  
}
