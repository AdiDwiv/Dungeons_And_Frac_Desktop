package sample;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.stage.Stage;
import resource.Monster;
import resource.Player;

public class AttackController {
	
	static LinkedList<String> expressions;
	static Image monsterImg, playerImg;
	static int hpM, hpP;
	
	   public static BorderPane getPane(Monster monster, Player player) {
			expressions = monster.reducedExpressions;
			monsterImg = new Image("./resource/media/"+monster.getImageCode());
			playerImg = new Image("./resource/media/"+player.getImageCode());
			hpM = monster.getHp();
			hpP = player.getHp();
		   
	        BorderPane attackPane = new BorderPane();
	        attackPane.setPadding(new Insets(300, 100, 10, 70));

	        //battle image
	        attackPane.setStyle("-fx-background-image: url(\"./resource/media/GrassSample.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: repeat;");
	        
	        FlowPane playerBox = new FlowPane(Orientation.VERTICAL);
	        playerBox.setVgap(10);
	        ImageView playerView = new ImageView();
	        playerView.setFitHeight(100);
	        playerView.setFitWidth(100);
	        playerView.setImage(playerImg);
	        
	        StackPane healthBarP = new StackPane();
	        Rectangle bgP = new Rectangle();
	        bgP.setWidth(100);
	        bgP.setHeight(20); 
	        Rectangle healthP = new Rectangle();
	        healthP.setWidth(hpP);
	        healthP.setHeight(20); 
	        healthP.setFill(Color.RED);
	        healthBarP.getChildren().addAll(bgP, healthP);
	        playerBox.getChildren().addAll(healthBarP, playerView);
	        
	        attackPane.setCenter(playerBox);
	        
	        FlowPane monsterBox = new FlowPane(Orientation.VERTICAL);
	        monsterBox.setVgap(10);
	        ImageView monsterView = new ImageView();
	        monsterView.setFitHeight(100);
	        monsterView.setFitWidth(100);
	        monsterView.setImage(monsterImg);

	        StackPane healthBarM = new StackPane();
	        Rectangle bgM = new Rectangle();
	        bgM.setWidth(100);
	        bgM.setHeight(20);
	        Rectangle healthM = new Rectangle();
	        healthM.setWidth(hpM);
	        healthM.setHeight(20); 
	        healthM.setFill(Color.RED);
	        healthBarM.getChildren().addAll(bgM, healthM);
	        monsterBox.getChildren().addAll(healthBarM, monsterView);
	        
	        attackPane.setRight(monsterBox);
	        
	        HBox menu = new HBox();
	        menu.setStyle("-fx-background-color: white;");
	        Text text = new Text();
	        text.setText("Choose your attack:  ");
	        Button btn1 = new Button();
	        btn1.setText("1");
	        Button btn2 = new Button();
	        btn2.setText("2");
	        Button btn3 = new Button();
	        btn3.setText("3");
	        menu.getChildren().addAll(text, btn1, btn2, btn3);
	        attackPane.setBottom(menu);
	        return attackPane;
	    }
}
