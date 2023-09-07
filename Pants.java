package Softwareengeeniring_finalproject;
public class Pants extends Product {
    private int length;
    private boolean formal;
    private boolean jeans;

    //constructor:
    
	public Pants(String Name, String Gender, int Price, int Quantity, int length, boolean formal, boolean jeans) {
	super(Name, Gender, Price, Quantity);
	this.length = length;
	this.formal = formal;
	this.jeans = jeans;
	}
    
    
    // Getters:
  
    public int getLength() {
        return this.length;
    }

    public boolean isFormal() {
        return this.formal;
    }

    public boolean isJeans() {
        return this.jeans;
    }

    // Setters:
    
    public void setLength(int length) {
        this.length = length;
    }

    public void setFormal(boolean formal) {
        this.formal = formal;
    }

    public void setJeans(boolean jeans) {
        this.jeans = jeans;
    }
    
    
	public String toString() {
		return "Pants "+ super.toString() + "\nLength: " + this.length + "\nFormal: " + this.formal + "\nJeans: " + this.jeans + "\n-----------" ; 
	}
}
