package resource;

public class Player extends Character {

    int hp;

    public Player(String name,String display,String imageCode) {
        super(name, display, imageCode);
        hp = 0;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
