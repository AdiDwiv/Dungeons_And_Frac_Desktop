package resource;

public class CellState {
    State state;
    String imageCode;
    Location location;

    public Boolean isOccupied;
    GCharacter occupier;

    public CellState() {
        state = State.VACANT;
        imageCode = "";
        location = new Location();
        isOccupied = false;
        occupier = null;
    }

    public CellState(Location loc) {
        state = State.VACANT;
        imageCode = "";
        location = loc;
        isOccupied = false;
        occupier = null;
    }

    public CellState(State cstate, String imageC, Location loc) {
        state = cstate;
        imageCode = imageC;
        location = loc;
    }

    public State getState() {
        return state;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setState(State st) {
        state = st;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public void occupy(GCharacter c) {
        isOccupied = true;
        occupier = c;
    }

    public void unoccupy() {
        isOccupied = false;
        occupier = null;
    }

    public GCharacter getOccupier() {
        return occupier;
    }

    public Location getLocation() {
        return location;
    }
}
