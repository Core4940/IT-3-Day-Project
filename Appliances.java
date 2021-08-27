import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Appliances extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		/**
		double  wood = 5, steel = 8, plastic = 4;
		double tax = 0.07;
		double chair = 10, table = 15, desk = 20, door = 25;
		double TotalPrice = 0.00;
		**/
	
		Label app = new Label("0.00");
		Label mater = new Label("0.00");
		Label ship = new Label("0.00");
		Label quant = new Label("0");
		Label totalPrice = new Label("0.00");
		
		
		Label label = new Label(" Appliance Form ");
		label.setFont(new Font("Ariel", 30));
		label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		
								//BorderPane Top - Completed.
				
		String appliances[] = 
	          { "Chair - $10", "Table - $15", "Desk - $20", "Door - $25"}; 
		ComboBox<String> cb = new ComboBox<String>(FXCollections.observableArrayList(appliances));
		
					
		GridPane gpLeft = new GridPane();
		gpLeft.setVgap(20);
		gpLeft.add(new Label("Select an Appliance: "), 0, 1);
		gpLeft.add(cb, 0, 2);
		
									//BorderPane Left - Completed.
		
		Label lRight = new Label("Shipping: ");
		
		ToggleGroup group = new ToggleGroup();
		RadioButton ThreeDay = new RadioButton("3 days");
		ThreeDay.setToggleGroup(group);
		RadioButton WeekDay = new RadioButton("1 week");
		WeekDay.setToggleGroup(group);
		RadioButton WeekDays2 = new RadioButton("2 weeks");
		WeekDays2.setToggleGroup(group);
		VBox v = new VBox(ThreeDay, WeekDay, WeekDays2);
		
		GridPane gpRight = new GridPane();
		gpRight.setVgap(20);
		gpRight.setHgap(20);
		gpRight.add(lRight, 0, 1);
		gpRight.add(v, 0, 2);

									//BorderPane Right - Completed.
		
		String material[] = 
	          { "Wood - $5", "Steel - $8", "Plastic - $4"}; 
		ComboBox<String> cbMaterial = new ComboBox<String>(FXCollections.observableArrayList(material));
		
		Slider quantity = new Slider(1, 10, 1);
		quantity.setShowTickLabels(true);
		quantity.setShowTickMarks(true);
		quantity.setMinorTickCount(1);
		quantity.setMajorTickUnit(1);
		quantity.setBlockIncrement(1);
		quantity.setSnapToTicks(true);
		quantity.setMaxWidth(115);
		
		
							//ComboBox update attempt starts - SUCCESSFUL

		cb.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//APPLIANCE
		    	if(cb.getSelectionModel().getSelectedIndex() == 0) {
			    	app.setText("10.00");
		    	}else if(cb.getSelectionModel().getSelectedIndex() == 1) {
		    		app.setText("15.00");
		    	}else if(cb.getSelectionModel().getSelectedIndex() == 2) {
		    		app.setText("20.00");
		    	}else if(cb.getSelectionModel().getSelectedIndex() == 3) {
		    		app.setText("25.00");
		    	}
		    	
		    }
		});
		
		cbMaterial.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				//MATERIAL
		    	if(cbMaterial.getSelectionModel().getSelectedIndex() == 0) {
		    		mater.setText("5.00");
		    	}else if(cbMaterial.getSelectionModel().getSelectedIndex() == 1) {
		    		mater.setText("8.00");
		    	}else if(cbMaterial.getSelectionModel().getSelectedIndex() == 2) {
		    		mater.setText("4.00");
		    	}
			}
		});
	
							//ComboBox update attempt ends - SUCCESSFUL
		
		
							//Shipping update attempt start 
		
		ThreeDay.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		        if (isNowSelected) 
		        	ship.setText("8.00");
		    }
		});
		
		WeekDay.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		        if (isNowSelected) 
		        	ship.setText("5.00");
		    }
		});
		
		WeekDays2.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		        if (isNowSelected) 
		        	ship.setText("3.00");
		    }
		});
		
		
							//Shipping update attempt ends - SUCCESSFUL
							
							//Quantity update attempt starts
		
		quantity.valueProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<?> arg0, Object arg1, Object arg2) {
               quant.textProperty().setValue(String.valueOf((int) quantity.getValue()));
            }
        });
			
							//Quantity update attempt ends - SUCCESSFUL
		
							//TotalPrice update attempt starts


		totalPrice.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
            	
            	String appP = app.getText();
            	String matP = mater.getText();
            	String shipP = ship.getText();
            	String quantP = quant.getText();
            	
            	double appPrice = Double.parseDouble(appP);
            	double matPrice = Double.parseDouble(matP);
            	double shipPrice = Double.parseDouble(shipP);
            	double quantPrice = Double.parseDouble(quantP);
            	double Total = appPrice + matPrice + shipPrice + quantPrice * 0.07;
            	
            	String TotalPrice = String.valueOf(Total);
            	
            	totalPrice.setText(TotalPrice);
            
            }
        }); 

							//TotalPrice update attempt ends - FAILED Multiple Attempts
		 
		GridPane gpCenter = new GridPane();
		gpCenter.setAlignment(Pos.TOP_CENTER);
		gpCenter.setVgap(10);
		gpCenter.setPrefWidth(50);
		gpCenter.add(new Label("Material: "), 0, 0);
		gpCenter.add(cbMaterial, 0, 1);
		gpCenter.add(new Label("Quantity: "), 0, 2);
		gpCenter.add(quantity, 0, 3);
		gpCenter.add(new Label("Appliance:            $"), 0, 6);
		gpCenter.add(app, 1, 6);
		gpCenter.add(new Label("Material:               $"), 0, 7);
		gpCenter.add(mater, 1, 7);
		gpCenter.add(new Label("Shipping:              $"), 0, 8);
		gpCenter.add(ship, 1, 8);
		gpCenter.add(new Label("Quantity:              x"), 0, 9);
		gpCenter.add(quant, 1, 9);
		gpCenter.add(new Label("_____________________"), 0, 10);
		gpCenter.add(new Label("_______"), 1, 10);
		gpCenter.add(new Label("Total Price:           $"), 0, 11);
		gpCenter.add(totalPrice, 1, 11);
		
		
		//BorderPane Center - CLOSE.
		

		
		Button ConfirmBottom = new Button("Confirm");
		Button CancelBottom = new Button("Cancel");
		
		HBox hBottom = new HBox();
		hBottom.getChildren().addAll(ConfirmBottom, CancelBottom);
		hBottom.setSpacing(5);
		hBottom.setAlignment(Pos.CENTER_RIGHT);
		
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(20, 20, 20, 20));
		BorderPane.setMargin(gpCenter, new Insets(20, 20, 20, 20));
		bp.setLeft(gpLeft);
		bp.setTop(label);
		bp.setCenter(gpCenter);
		bp.setRight(gpRight);
		bp.setBottom(hBottom);
		BorderPane.setAlignment(hBottom, Pos.CENTER_RIGHT);
		BorderPane.setAlignment(label, Pos.CENTER);
		//BorderPane alignments
		
        Scene scene = new Scene(bp, 600, 450);
        primaryStage.setTitle("ITC Project - Corey Barron");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);	
	}
}