package com.ssdd.aeropuerto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidad Aeropuerto de base de datos. Almacena toda la información de los aeropuertos 
 * @author Sergio Lira Díaz. Sara Rodríguez Alarcón
 *
 */
@Entity
public class Aeropuerto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	private String codigo;
	private String nombre;
	
	public Aeropuerto() {}

	public Aeropuerto(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getId() {
		return id;
	}
}
