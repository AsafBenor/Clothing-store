package Softwareengeeniring_finalproject;
public class Shoe extends Product{
	private int size;
	private String brand;
	private Boolean slides;
	private Boolean heels;
	private Boolean laces;
	
	// Constructor:
	
	public Shoe(String Name, String Gender, int Price, int Quantity, int Size, String Brand, Boolean Slides, Boolean Heels, Boolean Laces) {
	super(Name, Gender, Price, Quantity);
	this.size = Size;
	this.brand = Brand;
	this.slides = Slides;
	this.heels = Heels;
	this.laces = Laces;
	
	}
	// Getters:
	
	public int getSize() {
		return this.size;
	}

	public String getBrand() {
		return this.brand;
	}

	public Boolean isSlides() {
		return this.slides;
	}	
	
	public Boolean isHeels() {
		return this.heels;
	}

	public Boolean hasLaces() {
		return this.laces;
	}
	
	//setters:
	
	public void setSize(int Size) {
		this.size = Size;
	}
	
	public void setBrand(String Brand) {
		this.brand = Brand;
	}
	
	public void setSlides(Boolean Slides) {
		this.slides = Slides;
	}
	
	public void setHeels(Boolean Heels) {
		this.heels = Heels;
	}
	
	public void setLaces(Boolean Laces) {
		this.laces = Laces;
	}
	
	public String toString() {
		return "Shoe "+ super.toString() + "\nSize: " + this.size + "\nBrand: " + this.brand + "\nSlides: " + this.slides + "\nHeels: " + this.heels + "\nLaces: " + this.laces + "\n-----------"; 
	}
	
	
	
	
	
	
	
	
}


	
	