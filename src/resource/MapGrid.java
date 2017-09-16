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
    		State currentState = map[currentLocation.x][currentLocation.y].getState();
    		
    		while(xDistance!=0 && yDistance!=0) {
    		
    		if(xDistance>0) {
    			
    			for(int i = currentLocation.x + 1;currentState == State.VACANT && xDistance>0; i++) {
    				path.add(map[i][currentLocation.y]);
    				currentLocation.x++;
    				currentState = map[currentLocation.x][currentLocation.y].getState();
    			}
    			
    			if(yDistance>0) {
    				for(int i = currentLocation.y + 1;currentState == State.VACANT && yDistance>0; i++) {
        				path.add(map[currentLocation.x][i]);
        				currentLocation.y++;
        				currentState = map[currentLocation.x][currentLocation.y].getState();
        			}
    			}
    			
    			else {
    				for(int i = currentLocation.y - 1;currentState == State.VACANT && yDistance<0; i--) {
        				path.add(map[currentLocation.x][i]);
        				currentLocation.y--;
        				currentState = map[currentLocation.x][currentLocation.y].getState();
        			}
    			}
    			
    		}
    		
    		else {
    			for(int i = currentLocation.x + 1;currentState == State.VACANT && xDistance>0; i++) {
    				path.add(map[i][currentLocation.y]);
    				currentLocation.x++;
    				currentState = map[currentLocation.x][currentLocation.y].getState();
    			}
    			
    			if(yDistance>0) {
    				for(int i = currentLocation.y + 1;currentState == State.VACANT && yDistance>0; i++) {
        				path.add(map[currentLocation.x][i]);
        				currentLocation.y++;
        				currentState = map[currentLocation.x][currentLocation.y].getState();
        			}
    			}
    			
    			else {
    				for(int i = currentLocation.y - 1;currentState == State.VACANT && yDistance<0; i--) {
        				path.add(map[currentLocation.x][i]);
        				currentLocation.y--;
        				currentState = map[currentLocation.x][currentLocation.y].getState();
        			}
    			}
    		}
    		
    		}
    		
    		}
    		
    		return path;
    		
    }
    
}
