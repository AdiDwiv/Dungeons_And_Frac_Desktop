package sample;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.stage.Stage;
import resource.Monster;
import resource.Player;
import resource.QState;

public class AttackController {
	
	static Image monsterImg, playerImg;
	static int hpM, hpP;
	static LinkedList<QState> states;
    static QState current;
    static String eqText = "";
    static String commentText = "Choose your attack:  ";

    
    private static void adjustHp(int option, Monster m, Player p) {
    	if (option == current.correct) {
    		m.setHp((int) (m.getHp() - (Math.ceil((100/(m.getQ().steps))))));
    		if (states.size() >= 1) states.pop();
    		eqText = current.nextReduced;
    	}
    	else {
    		p.setHp(p.getHp() - 10);
    	}
    	commentText = current.options[option][1];
    }
	
	   public static BorderPane getPane(Monster monster, Player player) {
			//expressions = monster.reducedExpressions;
			monsterImg = new Image("./resource/media/"+monster.getImageCode());
			playerImg = new Image("./resource/media/"+player.getSideImageCode());
			hpM = monster.getHp();
			hpP = player.getHp();
			if (states == null) {
				states = monster.getQ().states;
			}
			if (states.size() >= 1) current = states.peek();
		   
	        BorderPane attackPane = new BorderPane();
	        attackPane.setPadding(new Insets(300, 100, 80, 70));

	        //battle image
	        attackPane.setStyle("-fx-background-image: url(\"./resource/media/battleBg.png\");-fx-background-size: cover;-fx-background-repeat: no-repeat;");
	        
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
	        
	        
	        //healthBarM.setAlignment(healthM, Pos.TOP_RIGHT);
	        Text qText = new Text();
	        qText.setFont(Font.font ("Verdana", 30));
	        qText.setFill(Color.BLACK);
	        if (eqText == "") { 
	        	qText.setText(monster.getQ().equation);
	        }
	        else {
	        	qText.setText(eqText);
	        }
	        monsterBox.getChildren().addAll(healthBarM, monsterView, qText);
	        attackPane.setRight(monsterBox); 
	        
	        HBox menu = new HBox(5);
	        menu.setStyle("-fx-background-color: white;");
	        Text comment = new Text();
	        comment.setText(commentText);
	        Button btn1 = new Button();
	        btn1.setText(current.options[0][0]);
	        Button btn2 = new Button();
	        btn2.setText(current.options[1][0]);
	        Button btn3 = new Button();
	        btn3.setText(current.options[2][0]);
	        
	        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() { 
	            @Override 
	            public void handle(ActionEvent e) { 
	         	   if (e.getSource()==btn1) {
	         		   adjustHp(0, monster, player);
	         	      }
	                else  if (e.getSource()==btn2) {
	                	adjustHp(1, monster, player);
	                  }
	                else if (e.getSource()==btn3){
	                	adjustHp(2, monster, player);
	                }
	         	   qText.setText(eqText);
	         	   System.out.println(monster.getHp());
	         	   Main.pstage.setScene(new Scene(getPane(monster, player)));
	         	   if (player.getHp() <= 0) {
	         		  Main.pstage.setScene(new Scene(EndScreen.getEndScreen(false)));
	         	   }
	         	  if (monster.getHp() <= 0) {
	         		  Main.pstage.setScene(new Scene(GridController.getGrid()));
	         	   }
	         	   }     
	         }; 
	        
	         btn1.setOnAction(eventHandler);
	         btn2.setOnAction(eventHandler);
	         btn3.setOnAction(eventHandler);
	        
	        menu.getChildren().addAll(comment, btn1, btn2, btn3);
	        attackPane.setBottom(menu);
	        return attackPane;
	    }
}
