package practica1.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	private String nombre;
	private String apellidos;
	private String nif;
	private String direccionPostal;
	private String email;
	private String telefono;
	
	
	public Cliente() {}

	public Cliente(String nombre, String apellidos, String nif, String direccionPostal, String email,
			String telefono) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.direccionPostal = direccionPostal;
		this.email = email;
		this.telefono = telefono;
	}

	public void actualizarCliente(Cliente nuevoCliente){
		this.nombre = nuevoCliente.getNombre();
		this.apellidos = nuevoCliente.getApellidos();
		this.nif = nuevoCliente.getNif();
		this.direccionPostal = nuevoCliente.getDireccionPostal();
		this.email = nuevoCliente.getEmail();
		this.telefono = nuevoCliente.getTelefono();
	}
	
	public long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getDireccionPostal() {
		return direccionPostal;
	}
	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	


}
