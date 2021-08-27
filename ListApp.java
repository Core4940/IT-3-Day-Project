import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ListApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		String appliances[] = 
          { "Chair - $10", "Table - $15", "Desk - $20", "Door - $25"}; 

		ComboBox<String> combo_box = new ComboBox<String>(FXCollections.observableArrayList(appliances)); 
		Label selected = new Label("select an item"); 

		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) { 
				selected.setText(combo_box.getValue() + " selected"); 
			} 
		}; 

		combo_box.setOnAction(event); 

		TilePane tile_pane = new TilePane(combo_box, selected); 

        Scene scene = new Scene(tile_pane, 500, 500);
        primaryStage.setTitle("ITC Project - Corey Barron");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);	
	}
}
