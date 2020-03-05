package practica1;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CuadroVendido extends Cuadro{
	
	@Id
	private Cliente buyer;
	private Date sale_date;
	public CuadroVendido(String title, String description, int ending_year, double width, double height, int price,
			Autor author, Cliente buyer, Date sale_date) {
		super(title, description, ending_year, width, height, price, author);
		this.buyer = buyer;
		this.sale_date = sale_date;
	}
	public Cliente getBuyer() {
		return buyer;
	}
	public void setBuyer(Cliente buyer) {
		this.buyer = buyer;
	}
	public Date getSale_date() {
		return sale_date;
	}
	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}
	
	
	
}
