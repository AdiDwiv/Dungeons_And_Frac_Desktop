package sample;
import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.stage.Stage;

public class GridController {
    public static GridPane getGrid() {
        GridPane gridPane = new GridPane();
        Image image = new Image("./resource/media/GrassSample.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        gridPane.add(iv1, 0, 0, 1, 1);
        return gridPane;
    }
}
