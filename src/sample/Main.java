package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage pstage;

	@Override
    public void start(Stage primaryStage) throws Exception{
    	pstage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dungeons and Fractions");
        Scene launchScene = new Scene(LaunchScreen.getLaunch(this), 300, 275);
        primaryStage.setScene(launchScene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
    		launch(args);
    }
    

    public static Stage getPstage() {
		return pstage;
	}

}
