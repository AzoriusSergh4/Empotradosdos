package practica1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cuadro {
	
	@Id
	private String title;
	private String description;
	private int ending_year;
	private double width;
	private double height;
	private int price;
	private Autor author;
	public Cuadro(String title, String description, int ending_year, double width, double height, int price,
			Autor author) {
		this.title = title;
		this.description = description;
		this.ending_year = ending_year;
		this.width = width;
		this.height = height;
		this.price = price;
		this.author = author;
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
	public int getEnding_year() {
		return ending_year;
	}
	public void setEnding_year(int ending_year) {
		this.ending_year = ending_year;
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
	public Autor getAuthor() {
		return author;
	}
	public void setAuthor(Autor author) {
		this.author = author;
	}
	
	
	
}
