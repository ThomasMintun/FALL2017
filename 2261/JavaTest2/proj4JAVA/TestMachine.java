/* Name: Zyra De Los Reyes
 * Course: CmpSci 2261 - 001 
 * Instructor: Dr. Dhou
 * Project_4: Abstract and Inheritance
 * Date: 10/28/2017
 */
public class TestMachine {


	public static void main(String[] args) {
		
		//Creating an array of 10 objects from the Machine class
		Machine[] MachineTest = new Machine[10];
		
		MachineTest[0] = new Printer();
		MachineTest[0].set_machine_name("Canon imageClass LBP151dw");
		MachineTest[0].set_machine_description("This printer is a speedy, budget mono laser with above-average text.");
		MachineTest[0].set_machine_price(79.99);
		MachineTest[0].set_machine_weight(65);
		
		MachineTest[1] = new Printer();
		MachineTest[1].set_machine_name("Brother HL-L8360CDW");
		MachineTest[1].set_machine_description("This printer is a speedy with above-average text.");
		MachineTest[1].set_machine_price(374.02);
		MachineTest[1].set_machine_weight(32);
		
		MachineTest[2] = new Printer();
		MachineTest[2].set_machine_name("Dell Color Smart Multifunction Printer S3845cdn");
		MachineTest[2].set_machine_description("This printer is an excellent color laser all-in-one for your micro or small office.");
		MachineTest[2].set_machine_price(999.99);
		MachineTest[2].set_machine_weight(70);
	   
		MachineTest[3] = new Printer();
		MachineTest[3].set_machine_name("Epson WorkForce Pro WF-4720");
		MachineTest[3].set_machine_description("This printer has great speed, above-par output quality, and a wealth of connection choices.");
		MachineTest[3].set_machine_price(130);
		MachineTest[3].set_machine_weight(25);
		
		MachineTest[4] = new Scanner();
		MachineTest[4].set_machine_name("Canon CanoScan LiDE220 Color Image Scanner");
		MachineTest[4].set_machine_description("This scanner scans photographic prints and an occasional short text document.");
		MachineTest[4].set_machine_price(78.99);
		MachineTest[4].set_machine_weight(26);
		
		MachineTest[5] = new Scanner();
		MachineTest[5].set_machine_name("HP ScanJet Pro 4500 fn1 Network Scanner");
		MachineTest[5].set_machine_description("This scanner supports both Ethernet and Wi-Fi, and it scans and saves to searchable PDF.");
		MachineTest[5].set_machine_price(78.99);
		MachineTest[5].set_machine_weight(13);
		
		MachineTest[6] = new Scanner();
		MachineTest[6].set_machine_name("IRIScan Book 5 WiFi");
		MachineTest[6].set_machine_description("This Scanner scans directly from books, magazines, journals, and notebooks.");
		MachineTest[6].set_machine_price(301);
		MachineTest[6].set_machine_weight(1);
		
		MachineTest[7] = new Smartphone();
		MachineTest[7].set_machine_name("Apple iPhone 7 Plus");
		MachineTest[7].set_machine_description("This smartphone is the best iPhone you can buy, with more memory and dual cameras.");
		MachineTest[7].set_machine_price(769.99);
		MachineTest[7].set_machine_weight(0.6);
		
		MachineTest[8] = new Smartphone();
		MachineTest[8].set_machine_name("Google Pixel");
		MachineTest[8].set_machine_description("This smartphone has the latest Android software and cool new features ");
		MachineTest[8].set_machine_price(230);
		MachineTest[8].set_machine_weight(0.49);
		
		MachineTest[9] = new Smartphone();
		MachineTest[9].set_machine_name("Samsung Galaxy S8");
		MachineTest[9].set_machine_description(" This smartphone is a gorgeous big-screen phone with a comfortable single-handed feel.");
		MachineTest[9].set_machine_price(100);
		MachineTest[9].set_machine_weight(0.10);
		
		for(int i = 0; i < MachineTest.length; ++i) {
            System.out.println("Machine: " + (i + 1));
            System.out.println("Name: " + MachineTest[i].get_machine_name());
            System.out.println("Description: " + MachineTest[i].get_machine_description());
            System.out.println("Price: $" + MachineTest[i].get_machine_price());
            System.out.println("Weight: " + MachineTest[i].get_machine_weight() + " lbs");
           
            System.out.println("\n");
        }
    }
	
}

