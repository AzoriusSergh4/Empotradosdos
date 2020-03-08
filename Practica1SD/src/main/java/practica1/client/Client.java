package practica1.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	private String name;
	private String surnames;
	private String nif;
	private String postalAddress;
	private String email;
	private String phone;
	
	public Client() {
		
	}
	
	public Client(String name, String surnames, String nif, String postalAddress, String email, String phone) {
		this.name = name;
		this.surnames = surnames;
		this.nif = nif;
		this.postalAddress = postalAddress;
		this.email = email;
		this.phone = phone;
	}

	public void updateClient(Client newClient){
		this.name = newClient.getName();
		this.surnames = newClient.getSurnames();
		this.nif = newClient.getNif();
		this.postalAddress = newClient.getPostalAddress();
		this.email = newClient.getEmail();
		this.phone = newClient.getPhone();
	}

	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurnames() {
		return surnames;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
