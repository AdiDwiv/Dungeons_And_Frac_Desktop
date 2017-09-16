package sample;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.stage.Stage;
import resource.Monster;
import resource.Player;

public class AttackController {
	
	LinkedList<String> expressions;
	Image monsterImg, playerImg;
	
	public AttackController(Monster monster, Player player) {
		expressions = monster.reducedExpressions;
		monsterImg = new Image("./resource/media/"+monster.getImageCode());
		playerImg = new Image("./resource/media/"+player.getImageCode());
	}
	
	   public BorderPane getPane() {
	        BorderPane attackPane = new BorderPane();
	        //battle image
	        attackPane.setStyle("-fx-background-image: url(\"./resource/media/GrassSample.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
	        ImageView playerView = new ImageView();
	        attackPane.setCenter(playerView);
	        playerView.setFitHeight(25);
	        playerView.setFitWidth(25);
	        playerView.setImage(playerImg);
	        attackPane.setCenter(playerView);
	        ImageView monsterView = new ImageView();
	        monsterView.setFitHeight(25);
	        monsterView.setFitWidth(25);
	        monsterView.setImage(monsterImg);
	        attackPane.setCenter(monsterView);
	        HBox hbox = new HBox();
	        hbox.setStyle("-fx-background-color: white;");
	        Text text = new Text();
	        text.setText("Choose your attack:  ");
	        Button btn1 = new Button();
	        btn1.setText("1");
	        Button btn2 = new Button();
	        btn2.setText("2");
	        Button btn3 = new Button();
	        btn3.setText("3");
	        hbox.getChildren().addAll(text, btn1, btn2, btn3);
	        attackPane.setBottom(hbox);
	        return attackPane;
	    }
}
