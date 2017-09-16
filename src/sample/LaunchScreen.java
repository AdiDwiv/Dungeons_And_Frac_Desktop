package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LaunchScreen {
	public static GridPane getLaunch(Main m) {
		
		Stage ps = m.getPstage();

		GridPane logoGrid = new GridPane();
		logoGrid.setAlignment(Pos.TOP_CENTER);
		logoGrid.setHgap(10);
        logoGrid.setVgap(10);
        logoGrid.setPadding(new Insets(25, 25, 25, 25));
		
        GridPane buttonGrid = new GridPane();
        buttonGrid.setAlignment(Pos.CENTER);
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);
        buttonGrid.setPadding(new Insets(25, 25, 25, 25));
        buttonGrid.setStyle("-fx-background-color: #000000;");
        
        Image logo = new Image("./resource/media/GrassSample.jpg");
        ImageView logoView = new ImageView();
        logoView.setImage(logo);
        logoView.setFitWidth(100);
        logoView.setFitHeight(50);
        buttonGrid.add(logoView, 1, 0);

        Button newGame = new Button("New Game");
        newGame.setAlignment(Pos.CENTER);
        newGame.setStyle("-fx-background-color: #C0C0C0;");
        buttonGrid.add(newGame, 1, 1);
        

        Button loadGame = new Button("Load Game");
        loadGame.setAlignment(Pos.CENTER);
        loadGame.setStyle("-fx-background-color: #C0C0C0;");
        buttonGrid.add(loadGame, 1, 2);
        
        Button howToPlay = new Button("How to Play");
        howToPlay.setAlignment(Pos.CENTER);
        howToPlay.setStyle("-fx-background-color: #C0C0C0;");
        buttonGrid.add(howToPlay, 1, 3);
        
        newGame.setMinWidth(100);
        loadGame.setMinWidth(100);
        howToPlay.setMinWidth(100);
       
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() { 
           @Override 
           public void handle(ActionEvent e) { 
        	   if (e.getSource()==newGame) {
                   ps.setScene(new Scene(GridController.getGrid(), 300, 275));
        	   }
               else {
               }   
        	   }     
        };  
        
        newGame.setOnAction(eventHandler);
        
        return buttonGrid;
	}
	
	
}
