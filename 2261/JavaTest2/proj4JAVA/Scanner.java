// Child class
public class Scanner extends Machine  {

	private static final double default_price = 80;
	private static final double default_weight = 10;
	public Scanner() {
		//System.out.println("This is the constructor of the Scanner class");
	}
	
	/// These were the abstract methods from Machine.java
	public void set_machine_price(double price){
		if(price >= 60 && price <= 300){
			this.price = price;
		} else {
			this.price = default_price;
		}
	}
	
	public void set_machine_weight(double weight){
		if(weight >= 2 && weight <= 25){
			this.weight = weight;
		} else {
			this.weight = default_weight;
			
		}
	}		
}


