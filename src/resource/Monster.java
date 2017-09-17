package resource;

import java.util.LinkedList;

public class Monster extends GCharacter {
    int hp;

	public LinkedList<String> reducedExpressions;

    public Monster(String name,String display,String imageCode) {
       super(name, display, imageCode);
       reducedExpressions = new LinkedList<String >();
    }
    
    public int getHp() {
		return hp;
	}

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void addReducedExpression(String redex) {
        reducedExpressions.add(redex);
        hp += 1;
    }
}
