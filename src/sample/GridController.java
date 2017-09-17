package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.util.Timer;
import java.util.TimerTask;

import javafx.stage.Stage;
import resource.*;

import javax.swing.text.View;
import java.lang.Character;
import java.util.LinkedList;

public class GridController {

    static MapGrid mapGrid;
    static GridPane gridPane;
    static CellState moveTo;

    static Stage ps = Main.pstage;

    public static GridPane getGrid() {
        mapGrid = new MapGrid(15, 15);
        CellState[][] map = mapGrid.map;
        gridPane = new GridPane();

        //Test Default level
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = new CellState(new Location(i,j));
                map[i][j].setImageCode("GrassBoi.png");
            }
        }

        for(int i = 0; i <= 5; i++) {
            for(int j = 6; j <= 8; j++) {
                map[i][j].setState(State.OBSTACLE);
                map[i][j].setImageCode("waterwhite.png");
            }
        }

        for(int i = 8; i < map.length; i++) {
            for(int j = 6; j <= 8; j++) {
                map[i][j].setState(State.OBSTACLE);
                map[i][j].setImageCode("waterwhite.png");
            }
        }

//        for(int i = 0; i < map.length; i++) {
//            for(int j = 0; j < map[0].length; j++) {
//                switch (map[i][j].getState()) {
//                    case VACANT: map[i][j].setImageCode("GrassBoi.png");
//                        break;
//                     case OBSTACLE: map[i][j].setImageCode("waterwhite.png");
//                     //case OBSTACLE: map[i][j].setImageCode("WaterSample.jpg");
//                        break;
//                    default:
//                }
//            }
//        }

        //Occupying this
        Player pl = new Player("Boi", "bitch", "player.png");
        pl.setSideImageCode("playerSide.png");
        map[1][1].occupy(pl);
        mapGrid.setPlayer(map[1][1]);
        map[7][8].occupy(new Monster("Mon", "bitchshah", "monster.png"));
        //Test END


//        class DataStackPane extends StackPane{
//            private int x, y;
//
//            public DataStackPane(int x, int y) {
//                this.x = x;
//                this.y = y;
//            }
//        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
//                Image image = new Image("./resource/media/"+map[i][j].getImageCode());
//                ImageView iv1 = new ImageView();
//                iv1.setImage(image);
//                iv1.setFitHeight(50);
//                iv1.setFitWidth(50);
//
//                DataStackPane sp = new DataStackPane(i,j);
//                if(map[i][j].isOccupied) {
//                    System.out.println("Bitch "+i+" "+j+" "+map[i][j].getOccupier().getImageCode());
//                    Image imP = new Image("./resource/media/"+map[i][j].getOccupier().getImageCode());
//                    ImageView iv2 = new ImageView();
//                    iv2.setFitHeight(25);
//                    iv2.setFitWidth(25);
//                    iv2.setImage(imP);
//                    //TEST END
//                    sp.getChildren().addAll(iv1, iv2);
//                    gridPane.add(sp, j, i, 1, 1);
//                } else  {
//                   sp.getChildren().addAll(iv1);
//                    gridPane.add(sp, j, i, 1, 1);
//                }
//
//               sp.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//            	    @Override
//            	    public void handle(MouseEvent mouseEvent) {
//            	    	switch (map[sp.x][sp.y].getState()) {
//            	    	 case VACANT:
//            	    	 //TODO: move player
//                             System.out.println("click");
//                             Location playerLoc = mapGrid.getPlayer().getLocation();
//                             System.out.println(playerLoc.x+" "+playerLoc.y+" "+" click: "+sp.x+" "+sp.y);
//                             LinkedList<CellState> path = mapGrid.getPath(playerLoc, map[sp.x][sp.y].getLocation());
//                             System.out.println(path.size());
//                             System.out.println(playerLoc.x+" "+playerLoc.y+" "+" click: "+sp.x+" "+sp.y);
//               	    	 break;
//            	    	 case OBSTACLE:
//            	    	 //nothing for now
//                   	     break;
//                       	 default:
//                       	//nothing for now
//                       	 break;
//            	    	}
//            	    }
//            	});
                populateCell(i, j);
            }
        }
        return gridPane;
    }


    public static void populateCell(int i, int j) {
        CellState[][] map = mapGrid.map;

        class DataStackPane extends StackPane{
            private int x, y;

            public DataStackPane(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        Image image = new Image("./resource/media/"+map[i][j].getImageCode());
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitHeight(50);
        iv1.setFitWidth(50);

        DataStackPane sp = new DataStackPane(i,j);
        if(map[i][j].isOccupied) {
            System.out.println("Bitch "+i+" "+j+" "+map[i][j].getOccupier().getImageCode());
            Image imP = new Image("./resource/media/"+map[i][j].getOccupier().getImageCode());
            ImageView iv2 = new ImageView();
            iv2.setFitHeight(25);
            iv2.setFitWidth(25);
            iv2.setImage(imP);
            //TEST END
            sp.getChildren().addAll(iv1, iv2);
            gridPane.add(sp, j, i, 1, 1);
        } else  {
            sp.getChildren().addAll(iv1);
            gridPane.add(sp, j, i, 1, 1);
        }

        sp.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                switch (map[sp.x][sp.y].getState()) {
                    case VACANT:
                        //TODO: move player
                        System.out.println("click");
                        Location playerLoc = mapGrid.getPlayer().getLocation();
                        //System.out.println(playerLoc.x+" "+playerLoc.y+" "+" click: "+sp.x+" "+sp.y);
                        //LinkedList<CellState> path = mapGrid.getPath(new Location(playerLoc.x, playerLoc.y), map[sp.x][sp.y].getLocation());
                        //path.removeFirst();
                        //System.out.println(path.size());
                        System.out.println(playerLoc.x+" "+playerLoc.y+" "+" click: "+sp.x+" "+sp.y);
                        moveTo = map[sp.x][sp.y];
                        if(playerLoc.x == sp.x && playerLoc.y == sp.y)
                            break;
                        if(moveTo != null)
                            GridController.moveCell();
                        try {
                            ps.setScene(new Scene(GridController.gridPane, 800, 800));
                        } catch(Exception e) {
                            System.out.println(e.getStackTrace());
                         }
                        break;
                    case OBSTACLE:
                        //nothing for now
                        break;
                    default:
                        //nothing for now
                        break;
                }
            }
        });
    }

    public static void moveCell() {
        boolean flag = false;
        GCharacter monster = null;
        if(moveTo.isOccupied) {
            flag = true;
            monster = moveTo.getOccupier();
        }

        System.out.println("Enter move");
        CellState playerOri = mapGrid.getPlayer();
        GCharacter p = playerOri.getOccupier();
        playerOri.unoccupy();
        moveTo.occupy(p);
        mapGrid.setPlayer(moveTo);
        System.out.println("PlayerOri: "+playerOri.getLocation().x+" "+playerOri.getLocation().y);
        System.out.println("MoveTo: "+moveTo.getLocation().x+" "+moveTo.getLocation().y);
        populateCell(playerOri.getLocation().x, playerOri.getLocation().y);
        populateCell(moveTo.getLocation().x, moveTo.getLocation().y);
        System.out.println("Exit move");

        if(flag) {
            ps.setScene(new Scene(AttackController.getPane((Monster) monster, (Player) p), 800, 800));
        }
    }

}
