package practica1.picture.soldPicture;

import practica1.author.Author;
import practica1.client.Client;
import practica1.picture.Picture;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class SoldPicture extends Picture {
	
	@OneToOne(cascade = CascadeType.ALL)
	private Client buyer;
	private Date saleDate;
	
	public SoldPicture(){
		super();
	}
	
	public SoldPicture(String title, String description, int endingYear, double width, double height, int price,
					   Author author, Client buyer, Date saleDate) {
		super(title, description, endingYear, width, height, price, author);
		this.buyer = buyer;
		this.saleDate = saleDate;
	}
	public Client getBuyer() {
		return buyer;
	}
	public void setBuyer(Client buyer) {
		this.buyer = buyer;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	
	
	
}
