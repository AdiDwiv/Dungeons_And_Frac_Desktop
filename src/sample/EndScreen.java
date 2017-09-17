package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EndScreen {
	
	static Stage ps = Main.pstage;
	
	public static FlowPane getEndScreen(boolean won) {
		 FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
		 flowPane.setStyle("-fx-background-color: #000000;");
		 Text statusText = new Text();
		 if (won) {
			 statusText.setText("Congratulations! You defeated the monster!"); 
		 } 
		 else { 
			 statusText.setText("You have died.");
		 }
		 
		 Button playAgain = new Button("Play Again?");
		 Button menu = new Button("Return to Main Menu");
		 
		 EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() { 
	           @Override 
	           public void handle(ActionEvent e) { 
	        	   if (e.getSource()==playAgain) {
	                   ps.setScene(new Scene(GridController.getGrid(), 800, 800));
	        	      }
	               else  if (e.getSource()==menu) {
	            	   ps.setScene(new Scene(LaunchScreen.getLaunch(), 800, 800));
	                   }
	        	   }     
	        }; 
	        
	        playAgain.setOnAction(eventHandler);
	        menu.setOnAction(eventHandler);
	        
	        flowPane.getChildren().addAll(statusText, playAgain, menu);
		 
		 return flowPane;
	}
	
}
