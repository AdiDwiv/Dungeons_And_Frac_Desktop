package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class LaunchScreenController {
	public static GridPane getLaunch() {
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button newGame = new Button("New Game");
        grid.add(newGame, 1, 1);

        Button loadGame = new Button("Load Game");
        grid.add(loadGame, 1, 2);
        
        Button howToPlay = new Button("How to Play");
        grid.add(howToPlay, 1, 3);
        
        return grid;
	}

public static void main(String[] args) {
	
}

}
