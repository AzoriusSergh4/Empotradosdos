package practica1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String name;
	private String surnames;
	private String nif;
	private int year_birth;
	private String country_birth;
	private String postal_address;
	private String email;
	private String phone;
	
	public Autor() {
		
	}
	
	public Autor(String name, String surnames, String nif, int year_birth, String country_birth, String postal_address,
			String email, String phone) {
		this.name = name;
		this.surnames = surnames;
		this.nif = nif;
		this.year_birth = year_birth;
		this.country_birth = country_birth;
		this.postal_address = postal_address;
		this.email = email;
		this.phone = phone;
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
	public int getYear_birth() {
		return year_birth;
	}
	public void setYear_birth(int year_birth) {
		this.year_birth = year_birth;
	}
	public String getCountry_birth() {
		return country_birth;
	}
	public void setCountry_birth(String country_birth) {
		this.country_birth = country_birth;
	}
	public String getPostal_address() {
		return postal_address;
	}
	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
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
