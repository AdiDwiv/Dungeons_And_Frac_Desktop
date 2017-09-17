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
import java.util.Arrays;
import java.util.LinkedList;

public class GridController {

    static MapGrid mapGrid;
    static GridPane gridPane;
    static CellState moveTo;
    static CellState[][] map;

    static Stage ps = Main.pstage;

    public static GridPane getGrid() {
//        mapGrid = new MapGrid(15, 15);
//        map = mapGrid.map;
        gridPane = new GridPane();
        levelMake1();
//
//
////        for(int i = 0; i < map.length; i++) {
////            for(int j = 0; j < map[0].length; j++) {
////                switch (map[i][j].getState()) {
////                    case VACANT: map[i][j].setImageCode("GrassBoi.png");
////                        break;
////                     case OBSTACLE: map[i][j].setImageCode("waterwhite.png");
////                     //case OBSTACLE: map[i][j].setImageCode("WaterSample.jpg");
////                        break;
////                    default:
////                }
////            }
////        }
//
//        String[][] options11 = new String[3][2];
//        options11[0][0] = "Add 4";
//        options11[0][1] = "Powerful move! You hit monster for 50 hp!";
//        options11[1][0] = "Subtract 4";
//        options11[1][1] = "Not very effective - this does not simplify the equation any further. The monster dodges your attack.";
//        options11[2][0] = "Divide by 7";
//        options11[2][1] = "Not very effective - not necessary to introduce fractions. The monster dodges your attack.";
//        QState state11 = new QState(0, "7x = 28", options11);
//
//        String[][] options12 = new String[3][2];
//        options12[0][0] = "Multiply by 2";
//        options12[0][1] = "Not very effective - this does not simplify the equation any further. The monster dodges your attack.";
//        options12[1][0] = "Subtract 28";
//        options12[1][1] = "Not very effective - this does not simplify the equation any further. The monster dodges your attack.";
//        options12[2][0] = "Divide by 7";
//        options12[2][1] = "Powerful move! You hit monster for 50 hp!";
//        QState state12 = new QState(0, "x = 4", options12);
//
//        Question question1 = new Question("7x -4 = 28", new LinkedList<QState>(Arrays.asList(state11, state12)));
//
//        String[][] options21 = new String[3][2];
//        options21[0][0] = "Find squareroot";
//        options21[0][1] = "Too early! The attack missed";
//        options21[1][0] = "Find square";
//        options21[1][1] = "That was counter-productive. The monster grew stronger.";
//        options21[2][0] = "Subtract 2";
//        options21[2][1] = "Strong move! You cut the monster's arm off for 50 hp";
//        QState state21 = new QState(2, "(x+1)^2 = 9", options21);
//
//        String[][] options22 = new String[3][2];
//        options22[0][0] = "Multiply by 5";
//        options22[0][1] = "Unneccesary move. The monster is unaffected";
//        options22[1][0] = "Find squareroot";
//        options22[1][1] = "Wham! The monster shrunk in half";
//        options22[2][0] = "Subtract 1";
//        options22[2][1] = "Too early! The attack missed";
//        QState state22 = new QState(1, "(x+1)=3", options22);
//
//        String[][] options23 = new String[3][2];
//        options23[0][0] = "Add 1";
//        options23[0][1] = "That was counter-productive. The monster grew stronger.";
//        options23[1][0] = "Subtract 1";
//        options23[1][1] = "Pow! The monster was knocked out!";
//        options23[2][0] = "Find squareroot";
//        options23[2][1] = "Too late! The monster dodged!";
//        QState state23 = new QState(1, "x=2", options23);
//
//        Question question2 = new Question("(x + 1)^2 + 2 = 11", new LinkedList<QState>(Arrays.asList(state21, state22, state23)));
//
//        //Occupying this
//        Player pl = new Player("Boi", "bitch", "player.png");
//        pl.setSideImageCode("playerSide.png");
//        map[1][1].occupy(pl);
//        mapGrid.setPlayer(map[1][1]);
//        map[7][8].occupy(new Monster("Mon", "bitchshah", "monster.png", question1));
//        //Test END
//

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
                populateCell(i, j);
            }
        }
        return gridPane;
    }


    public static void populateCell(int i, int j) {
        map = mapGrid.map;

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


    public static void levelMake1() {
        mapGrid = new MapGrid(20, 15);
        map = mapGrid.map;
        map = mapGrid.map;
        //Test Default level
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = new CellState(new Location(i,j));
                map[i][j].setImageCode("GrassBoi.png");


                //Thingy
                //Water
                if(j >= 6 && j <= 8) {
                    if((i <=5) || ( i>= 8 && i < map.length)) {
                        map[i][j].setState(State.OBSTACLE);
                        map[i][j].setImageCode("waterwhite.png");
                    } else {
                        map[i][j].setImageCode("BridgeCompNew.png"); //Bridge
                    }
                }
                if(j >= 9) {
                    if((i <= 2) || (i >=13)) {
                        map[i][j].setState(State.OBSTACLE);
                        map[i][j].setImageCode("bushel.png");
                    }
                }
                if(j >= 15) {
                    if((i <= 3) || (i <10)) {
                        map[i][j].setState(State.OBSTACLE);
                        map[i][j].setImageCode("bushel.png");
                    }
                }

                //
            }
        }

//        for(int i = 0; i <= 5; i++) {
//            for(int j = 6; j <= 8; j++) {
//                map[i][j].setState(State.OBSTACLE);
//                map[i][j].setImageCode("waterwhite.png");
//            }
//        }

//        System.out.println("Test");
//        for(int i = 6; i <= 7; i++) {
//            for(int j = 6; j <= 8; j++) {
//                System.out.println("Testatat");
//                map[i][j].setImageCode("BridgeCompNew.png");
//            }
//        }

//        for(int i = 8; i < map.length; i++) {
//            for(int j = 6; j <= 8; j++) {
//                map[i][j].setState(State.OBSTACLE);
//                map[i][j].setImageCode("waterwhite.png");
//            }
//        }

//        for(int i = 0; i < 3; i++) {
//            for(int j = 10; j < map[0].length; j++) {
//                map[i][j].setState(State.OBSTACLE);
//                map[i][j].setImageCode("bushel.png");
//            }
//        }

    //Questions and stuff
        String[][] options11 = new String[3][2];
        options11[0][0] = "Add 4";
        options11[0][1] = "Powerful move! You hit monster for 50 hp!";
        options11[1][0] = "Subtract 4";
        options11[1][1] = "Not very effective - this does not simplify the equation any further. The monster dodges your attack.";
        options11[2][0] = "Divide by 7";
        options11[2][1] = "Not very effective - not necessary to introduce fractions. The monster dodges your attack.";
        QState state11 = new QState(0, "7x = 28", options11);

        String[][] options12 = new String[3][2];
        options12[0][0] = "Multiply by 2";
        options12[0][1] = "Not very effective - this does not simplify the equation any further. The monster dodges your attack.";
        options12[1][0] = "Subtract 28";
        options12[1][1] = "Not very effective - this does not simplify the equation any further. The monster dodges your attack.";
        options12[2][0] = "Divide by 7";
        options12[2][1] = "Powerful move! You hit monster for 50 hp!";
        QState state12 = new QState(0, "x = 4", options12);

        Question question1 = new Question("7x -4 = 28", new LinkedList<QState>(Arrays.asList(state11, state12)));

        String[][] options21 = new String[3][2];
        options21[0][0] = "Find squareroot";
        options21[0][1] = "Too early! The attack missed";
        options21[1][0] = "Find square";
        options21[1][1] = "That was counter-productive. The monster grew stronger.";
        options21[2][0] = "Subtract 2";
        options21[2][1] = "Strong move! You cut the monster's arm off for 50 hp";
        QState state21 = new QState(2, "(x+1)^2 = 9", options21);

        String[][] options22 = new String[3][2];
        options22[0][0] = "Multiply by 5";
        options22[0][1] = "Unneccesary move. The monster is unaffected";
        options22[1][0] = "Find squareroot";
        options22[1][1] = "Wham! The monster shrunk in half";
        options22[2][0] = "Subtract 1";
        options22[2][1] = "Too early! The attack missed";
        QState state22 = new QState(1, "(x+1)=3", options22);

        String[][] options23 = new String[3][2];
        options23[0][0] = "Add 1";
        options23[0][1] = "That was counter-productive. The monster grew stronger.";
        options23[1][0] = "Subtract 1";
        options23[1][1] = "Pow! The monster was knocked out!";
        options23[2][0] = "Find squareroot";
        options23[2][1] = "Too late! The monster dodged!";
        QState state23 = new QState(1, "x=2", options23);

        Question question2 = new Question("(x + 1)^2 + 2 = 11", new LinkedList<QState>(Arrays.asList(state21, state22, state23)));
        

        		String[][] options31 = new String[3][2];
        		        options31[0][0] = "Apply distributive law";
        		        options31[0][1] = "Whoosh! A gust blew to reveal that the giant monster was in fact 2 smaller ones.";
        		        options31[1][0] = "Subtract 1";
        		        options31[1][1] = "The monster deflected the attack. No loss of HP!";
        		        options31[2][0] = "Find Square root";
        		        options31[2][1] = "That was dangerous. The monster became bigger in size";
        		        QState state31 = new QState(0, "y = ((cosec^2(x)-1)(sec^2(x)-1))", options31);

        		String[][] options32 = new String[3][2];
        		        options32[0][0] = "Divide by sec^2(x) - 1";
        		        options32[0][1] = "That move had no effect.";
        		        options32[1][0] = "Subtract 1";
        		        options32[1][1] = "The monster easily dodged the attack! Not effective.";
        		        options32[2][0] = "Apply Pythagorean identity";
        		        options32[2][1] = "Boom! The monster took 33 HP damage!";
        		        QState state32 = new QState(2, "y = cot^2(x)*tan^2(x)", options32);

        		String[][] options33 = new String[3][2];
        		        options33[0][0] = "Apply reciprocal identity";
        		        options33[0][1] = "Powerful blow. The monster was knocked out!";
        		        options33[1][0] = "Apply Pythagorean theorem";
        		        options33[1][1] = "The monster dodged. Never repeat your moves!";
        		        options33[2][0] = "Add tan^2(x)";
        		        options33[2][1] = "That had no effect on the monster.";
        		        QState state33 = new QState(0, "y = 1", options33);
        		        
        	    Question question3 = new Question("y = cosec^2(x)sec^2(x)\n - cosec^2(x) - sec^2(x) + 1", new LinkedList<QState>(Arrays.asList(state31, state32, state33)));

        //Occupying this
        Player pl = new Player("Boi", "bitch", "player.png");
        pl.setSideImageCode("playerSide.png");
        map[1][1].occupy(pl);
        mapGrid.setPlayer(map[1][1]);
        map[11][17].occupy(new Monster("Mon", "bitchshah", "monster.png", question3));
        //Test END


    }

}
