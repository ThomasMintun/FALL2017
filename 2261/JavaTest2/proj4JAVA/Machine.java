//This is my parent class
public abstract class Machine {

	private String name, description;
	protected double price;
	protected double weight;
	
	//Constructor
	public Machine() 
	{
		//System.out.println("This is the constructor of the Machine class");
	}
	
	// Machine class has 8 methods, 2 of which are abstract
	public String get_machine_name() 
	{
		return name;
	}
	
	public void set_machine_name(String mName)
	{
		name = mName;
	}
	
	public String get_machine_description() 
	{
		return description;
	}
	
	public void set_machine_description(String mDescription)
	{
		description = mDescription;
	}
	
	public double get_machine_price() 
	{
		return price;		
	}
	public double get_machine_weight() 
	{
		return weight;
	}
	
	// Abstract methods do not contain a body and so I must
	// implement them within the child class
	public abstract void set_machine_price(double price);
	public abstract void set_machine_weight(double weight);
	
	
}
