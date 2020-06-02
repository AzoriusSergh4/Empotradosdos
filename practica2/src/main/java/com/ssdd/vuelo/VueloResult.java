package com.ssdd.vuelo;

/**
 * Clase de datos que almacena los vuelos de ida y de vuelta, y el precio total, aplicando descuento si es necesario
 *
 */
public class VueloResult {

	private Vuelo vueloIda;
	private Vuelo vueloVuelta;
	private int precioTotal;
	
	
	
	public VueloResult(Vuelo vueloIda, Vuelo vueloVuelta) {
		super();
		this.vueloIda = vueloIda;
		this.vueloVuelta = vueloVuelta;
		
		if(this.vueloVuelta != null) {
			this.precioTotal = this.vueloIda.getPrecio() + this.vueloVuelta.getPrecio();
			//Descuento
			if(this.getVueloIda().getNombreCompania().equals(this.getVueloVuelta().getNombreCompania())) {
				this.precioTotal = (this.precioTotal * 80) / 100;
			}
		}else {
			this.precioTotal = this.vueloIda.getPrecio();
		}
		
	}
	
	public Vuelo getVueloIda() {
		return vueloIda;
	}
	public void setVueloIda(Vuelo vueloIda) {
		this.vueloIda = vueloIda;
	}
	public Vuelo getVueloVuelta() {
		return vueloVuelta;
	}
	public void setVueloVuelta(Vuelo vueloVuelta) {
		this.vueloVuelta = vueloVuelta;
	}
	public int getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
}
