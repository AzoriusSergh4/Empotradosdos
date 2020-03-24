package practica1.autor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import practica1.cuadro.Cuadro;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	private String nombre;
	private String apellidos;
	private String nif;
	private int anyoNacimiento;
	private String paisNacimiento;
	private String direccionPostal;
	private String email;
	private String telefono;
	
	@OneToMany(mappedBy = "autor")
	private List<Cuadro> cuadros;
	
	public Autor() {}
	
	public Autor(String nombre, String apellidos, String nif, int anyoNacimiento, String paisNacimiento, String direccionPostal,
			String email, String telefono) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.anyoNacimiento = anyoNacimiento;
		this.paisNacimiento = paisNacimiento;
		this.direccionPostal = direccionPostal;
		this.email = email;
		this.telefono = telefono;
	}

	public void actualizarAutor(Autor nuevoAutor){
		this.nombre = nuevoAutor.getNombre();
		this.apellidos = nuevoAutor.getApellidos();
		this.nif = nuevoAutor.getNif();
		this.anyoNacimiento = nuevoAutor.getAnyoNacimiento();
		this.paisNacimiento = nuevoAutor.getPaisNacimiento();
		this.direccionPostal = nuevoAutor.getDireccionPostal();
		this.email = nuevoAutor.getEmail();
		this.telefono = nuevoAutor.getTelefono();
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

	public int getAnyoNacimiento() {
		return anyoNacimiento;
	}

	public void setAnyoNacimiento(int anyoNacimiento) {
		this.anyoNacimiento = anyoNacimiento;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
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

	public List<Cuadro> getCuadros() {
		return cuadros;
	}

	public void setCuadros(List<Cuadro> cuadros) {
		this.cuadros = cuadros;
	}

	

	

}
