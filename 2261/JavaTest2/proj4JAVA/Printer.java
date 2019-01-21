// Child class
public class Printer extends Machine {

	//Constant declaration
	//To avoid default price and weight values of printer from being re-assigned
	private static final double default_price = 90;
	private static final double default_weight = 25;
	public Printer() {
	//	System.out.println("This is the constructor of the Printer class");
	}
	
	// These were the abstract methods from Machine.java
	public void set_machine_price(double price){
		if(price >= 40 && price <= 200){
			this.price = price;
		} else {
			this.price = default_price;
		}
	}
	
	public void set_machine_weight(double weight){
		if(weight < 50 && weight > 0){
			this.weight = weight;
		} else {
			this.weight = default_weight;
			
		}
	}
}
