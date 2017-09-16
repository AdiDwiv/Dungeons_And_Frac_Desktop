/*package resource;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import sample.GridController;

public class MapGridTest {

    @Test
    public void test() {
        Location start = new Location(2,5);
        Location end = new Location(5,5);
        LinkedList<CellState> list = new LinkedList<CellState>();
        
        MapGrid mapGrid = new MapGrid(10, 10);
        CellState[][] map = mapGrid.map;
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
                    // case OBSTACLE: map[i][j].setImageCode("WaterSample.jpg");
                        break;
                    default:
                }
            }
        }
        map[1][2].setState(State.PLAYER);
        
        list.add(map[2][5]);
        list.add(map[3][5]);
        list.add(map[4][5]);
        list.add(map[5][5]);
        
        assertEquals(mapGrid.getPath(start, end), list);
    }

}
*/