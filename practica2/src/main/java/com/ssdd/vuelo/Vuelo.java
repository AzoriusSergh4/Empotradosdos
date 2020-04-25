package com.ssdd.vuelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vuelo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	

	
	public Vuelo() {
		
	}
	
}
