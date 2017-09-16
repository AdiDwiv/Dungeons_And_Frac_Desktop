package sample;
import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import resource.CellState;
import resource.MapGrid;
import resource.State;

import javax.swing.text.View;

public class GridController {

    // MapGrid mapGrid;

    public static GridPane getGrid() {
        MapGrid mapGrid = new MapGrid(10, 10);
        CellState[][] map = mapGrid.map;
        GridPane gridPane = new GridPane();

        //Test
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = new CellState();
            }
        }

        for(int i = 6; i <= 8; i++) {
            for(int j = 3; j <= 5; j++) {
                map[i][j].setState(State.OBSTACLE);
            }
        }


        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                switch (map[i][j].getState()) {
                    case VACANT: map[i][j].setImageCode("GrassSample.jpg");
                        break;
                    case OBSTACLE: map[i][j].setImageCode("WaterSample.png");
                        break;
                    default:
                }
            }
        }

        //TEST
        map[1][2].setState(State.PLAYER);
        //

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                Image image = new Image("./resource/media/"+map[i][j].getImageCode());
                ImageView iv1 = new ImageView();
                iv1.setImage(image);
                iv1.setFitHeight(50);
                iv1.setFitWidth(50);

               if(map[i][j].getState() == State.PLAYER) {
                    //TEST
                    Image imP = new Image("./resource/media/circle.png");
                    ImageView iv2 = new ImageView();
                    iv2.setFitHeight(25);
                    iv2.setFitWidth(25);
                    iv2.setImage(imP);
                    //TEST END
                    StackPane sp = new StackPane();
                    sp.getChildren().addAll(iv1, iv2);
                    //Button button = new Button("Button "+i+" "+j);
                    gridPane.add(sp, j, i, 1, 1);
                    //gridPane.setGridLinesVisible(true);
                } else  {
                    gridPane.add(iv1, j, i, 1, 1);
                }
            }
        }


        return gridPane;
    }
}
