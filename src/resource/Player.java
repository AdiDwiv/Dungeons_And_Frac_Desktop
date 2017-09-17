package resource;


public class Player extends GCharacter {

    int hp;
    String sideImageCode;

    public Player(String name,String display,String imageCode) {
        super(name, display, imageCode);
        hp = 100;
    }
    
    public int getHp() {
		return hp;
	}

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getSideImageCode() {
        return sideImageCode;
    }

    public void setSideImageCode(String sideImageCode) {
        this.sideImageCode = sideImageCode;
    }
}

