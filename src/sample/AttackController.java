package sample;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.layout.*;
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
	        
	        Rectangle statusP = new Rectangle();
	        statusP.setWidth(100);
	        statusP.setHeight(20); 
	        playerBox.getChildren().addAll(statusP, playerView);
	        
	        attackPane.setCenter(playerBox);
	        
	        FlowPane monsterBox = new FlowPane(Orientation.VERTICAL);
	        monsterBox.setVgap(10);
	        ImageView monsterView = new ImageView();
	        monsterView.setFitHeight(100);
	        monsterView.setFitWidth(100);
	        monsterView.setImage(monsterImg);

	        Rectangle statusM = new Rectangle();
	        statusM.setWidth(100);
	        statusM.setHeight(20);
	        monsterBox.getChildren().addAll(statusM, monsterView);
	        
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
