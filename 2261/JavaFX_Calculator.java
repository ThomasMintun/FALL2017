import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Financial_Calculator extends Application {
	Label l1,l2,l3,l4;
	TextField money, years, interest, finalWorth;
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) // Stage object primaryStage is window
	{
		l1 = new Label("Money used in investment: ");
		l2 = new Label("Years: ");
		l3 = new Label("Annual Interest Rate: ");
		l4 = new Label("Final financial worth: ");
		//Set text field for each label
		money = new TextField();
		money.setAlignment(Pos.CENTER_RIGHT);
		years = new TextField();
		years.setAlignment(Pos.CENTER_RIGHT);
		interest = new TextField();
		interest.setAlignment(Pos.CENTER_RIGHT);
		finalWorth = new TextField();
		finalWorth.setAlignment(Pos.CENTER_RIGHT);
		finalWorth.setEditable(false);  // user cannot type into the field
		
		//The contents will be layed out within the insets of HBox
		HBox hBox = new HBox();
		Button calculate_button = new Button("Calculate");
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(calculate_button);
		GridPane grid = new GridPane(); //layout that lays out child compnets on a grid; holds labels, textfields, and button
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(11.5,12.5,13.5,14.5));
		grid.setHgap(5.5);
		grid.setVgap(5.5);
		
		//Place nodes in the pane
		grid.add(l1, 0, 0);
		grid.add(money, 1, 0);
		grid.add(l2, 0, 1);
		grid.add(years, 1, 1);
		grid.add(l3, 0, 2);
		grid.add(interest, 1, 2);
		grid.add(l4, 0, 3);
		grid.add(finalWorth, 1, 3);
		grid.add(calculate_button, 1, 4);
		GridPane.setHalignment(calculate_button, HPos.RIGHT);
		
		//set a scene
		Scene scene = new Scene(grid, 350, 250);
		primaryStage.setTitle("Financial Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		calculate_button.setOnAction(e -> finalCalculation());
	}
	private void finalCalculation(){ // take the values entered by user and store it in local variables
		double investedMoney = Double.parseDouble(money.getText());
		int investYears = Integer.parseInt(years.getText());
		double annualRate = Double.parseDouble(interest.getText());
		double monthlyRate = annualRate/1200;
		double finalFinancialWorth = investedMoney*(Math.pow((1+monthlyRate), (investYears*12)));
		finalWorth.setText("$"+ String.format("%.2f",finalFinancialWorth));
		
	}
	public static void main(String[] args){
		Application.launch(args);  // is a static method defined in the Application class
	}
}