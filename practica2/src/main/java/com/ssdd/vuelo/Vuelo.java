package com.ssdd.vuelo;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ssdd.aeropuerto.Aeropuerto;
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
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Aeropuerto origen;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Aeropuerto destino;
	
	public Vuelo() {
		
	}

	public Vuelo(String codigo, Date fechaSalida, Time horaSalida, int duracion, int precio, Compania compania, Aeropuerto origen, Aeropuerto destino) {
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

	public Aeropuerto getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public Time getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Compania getCompaniaId() {
		return compania;
	}

	public void setCompaniaId(Compania compania) {
		this.compania = compania;
	}
	
	
	
	
}
