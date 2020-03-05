package practica1;

import javax.persistence.Entity;

@Entity
public class CuadroEnVenta extends Cuadro{

	public CuadroEnVenta(String title, String description, int ending_year, double width, double height, int price,
			Autor author) {
		super(title, description, ending_year, width, height, price, author);
	}
	
	
}
