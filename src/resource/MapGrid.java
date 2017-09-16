package resource;

public class MapGrid {
    public CellState[][] map;
    CellState player;
    CellState exit;

    public MapGrid(int width, int height) {
        map = new CellState[height][width];
    }


}
