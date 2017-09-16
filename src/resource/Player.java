package resource;

<<<<<<< HEAD
public class Player extends Character {

    int hp;

    public Player(String name,String display,String imageCode) {
        super(name, display, imageCode);
        hp = 0;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
=======
public class Player {
	int hp;
	
	public Player() {
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

>>>>>>> 6b4049381da9bf55617e781c1ee358089af01a96
}
