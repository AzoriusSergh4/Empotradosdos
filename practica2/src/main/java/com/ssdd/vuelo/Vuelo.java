package com.ssdd.vuelo;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ssdd.aeropuerto.Aeropuerto;

@Entity
public class Vuelo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	private String codigo;
	
	private Date fechaSalida;
	
	private int duracion;
	
	private int precio;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Aeropuerto origen;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Aeropuerto destino;
	
	public Vuelo() {
		
	}
	
}
