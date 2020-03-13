package practica1.cuadro;

import practica1.autor.Autor;
import practica1.cliente.Cliente;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Cuadro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	private String titulo;
	private String descripcion;
	private int anyoFinalizacion;
	private double anchura;
	private double altura;
	private int precio;
	private Date fechaVenta;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Cliente comprador;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Autor autor;
	
	public Cuadro() {
		
	}


	public Cuadro(String titulo, String descripcion, int anyoFinalizacion, double anchura, double altura,
			int precio, Autor autor, Cliente comprador, Date fechaVenta) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.anyoFinalizacion = anyoFinalizacion;
		this.anchura = anchura;
		this.altura = altura;
		this.precio = precio;
		this.fechaVenta = fechaVenta;
		this.comprador = comprador;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAnyoFinalizacion() {
		return anyoFinalizacion;
	}

	public void setAnyoFinalizacion(int anyoFinalizacion) {
		this.anyoFinalizacion = anyoFinalizacion;
	}

	public double getAnchura() {
		return anchura;
	}

	public void setAnchura(double anchura) {
		this.anchura = anchura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public long getId() {
		return id;
	}
	

	
	
}
