package resource;

import java.util.LinkedList;

public class MapGrid {
    public CellState[][] map;
    CellState player;
    CellState exit;

    public MapGrid(int width, int height) {
        map = new CellState[height][width];
    }

	public CellState getPlayer() {
		return player;
	}

	public void setPlayer(CellState player) {
		this.player = player;
	}

	public LinkedList<CellState> getPath(Location start, Location end) {
    		LinkedList<CellState> path = new LinkedList<CellState>();
    		path.add(map[start.x][start.y]);
    		int xDistance = end.x - start.x;
    		int yDistance = end.y - start.y;
    		int LeftOrRight = ((end.x>start.x)?1:-1);
    		int UpOrDown = ((end.y>start.y)?1:-1);
    		Location currentLocation = start;
    		int loopCount = 0;
    		while(currentLocation.x!=end.x || currentLocation.y!=end.y) {
    			
    			for(int i = currentLocation.x + LeftOrRight;map[i][currentLocation.y].getState() == State.VACANT && xDistance!=0; i+=LeftOrRight) {
    				//System.out.println(xDistance);
    				path.add(map[i][currentLocation.y]);
    				currentLocation.x+=LeftOrRight;
    				xDistance-=LeftOrRight;
    				//System.out.println(currentLocation.x+" "+currentLocation.y); 
    			}
    			//System.out.println("Bleh" + currentLocation.x+" "+currentLocation.y);
    			
    			for(int i = currentLocation.y + UpOrDown;map[currentLocation.x][i].getState() == State.VACANT && yDistance!=0/*map[currentLocation.x+LeftOrRight][currentLocation.y].getState() != State.VACANT*/; i+=UpOrDown) {
    				path.add(map[currentLocation.x][i]);
    				currentLocation.y+=UpOrDown;
    				yDistance-=UpOrDown;
    				//System.out.println(currentLocation.x+" "+currentLocation.y);
    			}
    			loopCount++;
    			if(loopCount==1000) {
    				//System.out.println("Infinite fucking loop");
    				break;
    			}
    		}
    		return path;
    		
    }
    
}
