package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LaunchScreen {
	public static GridPane getLaunch() {
		
		Stage ps = Main.pstage;

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
        
        FlowPane main = new FlowPane(Orientation.VERTICAL);
        
        FlowPane logo = new FlowPane();
        Image logoImg = new Image("./resource/media/dnf.png");
        ImageView logoView = new ImageView();
        logoView.setImage(logoImg);
        logoView.prefWidth(100);
        logoView.prefHeight(50);
        logo.getChildren().add(logoView);
        
        main.getChildren().add(logo);
        //buttonGrid.add(logo, 1, 0);
        
        GridPane buttonGrid2 = new GridPane();
        buttonGrid2.setHgap(10);
        buttonGrid2.setVgap(10);
        buttonGrid2.setPadding(new Insets(25, 100, 25, 350));
        Button newGame = new Button("New Game");
        newGame.setAlignment(Pos.CENTER_RIGHT);
        newGame.setStyle("-fx-background-color: #C0C0C0;");
        buttonGrid2.add(newGame, 1, 1);
        

        Button loadGame = new Button("Load Game");
        loadGame.setAlignment(Pos.CENTER);
        loadGame.setStyle("-fx-background-color: #C0C0C0;");
        buttonGrid2.add(loadGame, 1, 2);
        
        Button howToPlay = new Button("How to Play");
        howToPlay.setAlignment(Pos.CENTER);
        howToPlay.setStyle("-fx-background-color: #C0C0C0;");
        buttonGrid2.add(howToPlay, 1, 3);
        main.getChildren().add(buttonGrid2);
        
        buttonGrid.add(main, 1, 0);
        
        newGame.setMinWidth(100);
        loadGame.setMinWidth(100);
        howToPlay.setMinWidth(100);
       
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() { 
           @Override 
           public void handle(ActionEvent e) { 
        	   if (e.getSource()==newGame) {
                   ps.setScene(new Scene(GridController.getGrid(), 1000, 750));
        	      }
               else  if (e.getSource()==howToPlay) {
            	   ps.setScene(new Scene(InstructionScreen.getInstructions(), 800, 800));
                   }
        	   }     
        };  
        
        newGame.setOnAction(eventHandler);
        howToPlay.setOnAction(eventHandler);
        
        return buttonGrid;
       // return main;
	}
	
	
}
