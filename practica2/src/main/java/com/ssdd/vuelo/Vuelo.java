package com.ssdd.vuelo;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ssdd.compania.Compania;


@Entity
public class Vuelo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	private String codigo;
	
	private Date fechaSalida;
	
	private Time horaSalida;
	
	private int duracion;
	
	private int precio;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Compania compania;
	
	//private String compania;
	
	private String origen;
	
	private String destino;
	
	public Vuelo() {
		
	}

	public Vuelo(String codigo, Date fechaSalida, Time horaSalida, int duracion, int precio, Compania compania, String origen, String destino) {
		super();
		this.codigo = codigo;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.duracion = duracion;
		this.precio = precio;
		this.origen = origen;
		this.destino = destino;
		this.compania = compania;
	}

	public long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Time getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}






	
	
	
}
