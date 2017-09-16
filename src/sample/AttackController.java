package sample;
import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.stage.Stage;

public class AttackController {
	   public static BorderPane getPane() {
	        BorderPane attackPane = new BorderPane();
	        //battle image
	        attackPane.setStyle("-fx-background-image: url(\"./resource/media/GrassSample.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
	        ImageView playerImg = new ImageView();
	        attackPane.setCenter(playerImg);
	        ImageView monsterImg = new ImageView();
	        attackPane.setCenter(playerImg);
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
