package resource;

public class CellState {
    State state;
    String imageCode;
    Location location;

    public CellState() {
        state = State.VACANT;
        imageCode = "";
        location = new Location();
    }

    public CellState(State cstate, String imageC, Location loc) {
        state = cstate;
        imageCode = imageC;
        location = loc;
    }
}
