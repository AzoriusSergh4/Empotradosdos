package practica1.picture;

import practica1.author.Author;
import practica1.client.Client;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Picture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	private String title;
	private String description;
	private int endingYear;
	private double width;
	private double height;
	private int price;
	private Date saleDate;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Client buyer;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Author author;
	
	public Picture() {
		
	}
	
	public Picture(String title, String description, int endingYear, double width, double height, int price,
			Author author, Client buyer, Date saleDate) {
		this.title = title;
		this.description = description;
		this.endingYear = endingYear;
		this.width = width;
		this.height = height;
		this.price = price;
		this.author = author;
		this.buyer = buyer;
		this.saleDate = saleDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEndingYear() {
		return endingYear;
	}
	public void setEndingYear(int ending_year) {
		this.endingYear = ending_year;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
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
