package resource;

import java.util.LinkedList;

public class Monster extends GCharacter {
    int hp;

	/*public LinkedList<String> reducedExpressions;
	public LinkedList<String> attacks;*/
    private Question q;

	public Monster(String name,String display,String imageCode, Question q) {
       super(name, display, imageCode);
       this.q = q;
       //reducedExpressions = new LinkedList<String >();
    }
    
    public int getHp() {
		return hp;
	}

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Question getQ() {
		return q;
	}
    
    public void addReducedExpression(String redex) {
        //reducedExpressions.add(redex);
        hp += 1;
    }
}
