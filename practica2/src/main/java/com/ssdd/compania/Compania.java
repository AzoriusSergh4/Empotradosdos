package com.ssdd.compania;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidad Compañia de base de datos. Almacena toda la información de las compañías de vuelos 
 * @author Sergio Lira Díaz. Sara Rodríguez Alarcón
 *
 */
@Entity
public class Compania {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	private String nombre;
	private String codigo;
	private String web;
	private String telefono;
	private double valoracion;
	
	public Compania() {
		
	}
	
	public Compania(String nombre, String codigo, String web, String telefono, double valoracion) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.web = web;
		this.telefono = telefono;
		this.valoracion = valoracion;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
	
	
}
