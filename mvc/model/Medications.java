package model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Entity;

@SuppressWarnings("deprecation")
@Entity
@DynamicUpdate
public class Medications {
	private String name, ingredients, manufacturer;
	private int quantity, price;
	
	public Medications() {}
	
	public Medications(String name, String ingredients, String manufacturer, int quantity, int price) {
		this.name = name;
		this.ingredients = ingredients;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
