package resource;

import java.util.LinkedList;

public class MapGrid {
    public CellState[][] map;
    CellState player;
    CellState exit;

    public MapGrid(int width, int height) {
        map = new CellState[height][width];
    }


    public LinkedList<CellState> getPath(Location start, Location end) {
    		LinkedList<CellState> path = new LinkedList<CellState>();
    		int xDistance = end.x - start.x;
    		int yDistance = end.y - start.y;
    		Location currentLocation = start;
    		while(currentLocation!=end) {
    			
    		if(xDistance>0) {
    			
    			for(int i = currentLocation.x + 1;map[i][currentLocation.y].getState() == State.VACANT && xDistance>0; i++) {
    				path.add(map[i][currentLocation.y]);
    				currentLocation.x++;
    			}
    			
    			if(yDistance>0) {
    				for(int j = currentLocation.y + 1;map[currentLocation.x][j].getState() == State.VACANT && yDistance>0; j++) {
        				path.add(map[currentLocation.x][j]);
        				currentLocation.y++;
        			}
    			}
    			
    			else {
    				for(int j = currentLocation.y - 1;map[currentLocation.x][j].getState() == State.VACANT && yDistance<0; j--) {
        				path.add(map[currentLocation.x][j]);
        				currentLocation.y--;
        			}
    			}
    			
    		}
    		
    		else {
    			for(int i = currentLocation.x - 1;map[i][currentLocation.y].getState() == State.VACANT && xDistance<0; i--) {
    				path.add(map[i][currentLocation.y]);
    				currentLocation.x--;
    			}
    			
    			if(yDistance>0) {
    				for(int j = currentLocation.y + 1;map[currentLocation.x][j].getState() == State.VACANT && yDistance>0; j++) {
        				path.add(map[currentLocation.x][j]);
        				currentLocation.y++;
        			}
    			}
    			
    			else {
    				for(int j = currentLocation.y - 1;map[currentLocation.x][j].getState() == State.VACANT && yDistance<0; j--) {
        				path.add(map[currentLocation.x][j]);
        				currentLocation.y--;
        			}
    			}
    		}
    		
    		}
    		
    		
    		return path;
    		
    }
    
}
