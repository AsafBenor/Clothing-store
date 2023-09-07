package Softwareengeeniring_finalproject;
public class Shirt extends Product{
    private String sleeveLen;
    private boolean slimFit;
    private boolean buttons;
    private boolean collar;

    //constructor:
    
	public Shirt(String Name, String Gender, int Price, int Quantity, String sleeveLen, Boolean slimFit, Boolean buttons, Boolean collar) {
	super(Name, Gender, Price, Quantity);
	this.sleeveLen = sleeveLen;
	this.slimFit = slimFit;
	this.buttons = buttons;
	this.collar = collar;
	}
    
    // Getters:
	
    public String getSleeveLen() {
        return this.sleeveLen;
    }

    public boolean isSlimFit() {
        return this.slimFit;
    }

    public boolean hasButtons() {
        return this.buttons;
    }

    public boolean hasCollar() {
        return this.collar;
    }

    // Setters:
    
    public void setSleeveLen(String sleeveLen) {
        this.sleeveLen = sleeveLen;
    }

    public void setSlimFit(boolean slimFit) {
        this.slimFit = slimFit;
    }

    public void setButtons(boolean buttons) {
        this.buttons = buttons;
    }

    public void setCollar(boolean collar) {
        this.collar = collar;
    }
    
	public String toString() {
		return "Shirt "+ super.toString() + "\nsleeve Length: " + this.sleeveLen + "\nslimFit: " + this.slimFit + "\nbuttons: " + this.buttons + "\ncollar: " + this.collar + "\n-----------"; 
	}
}
