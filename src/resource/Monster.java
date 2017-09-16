package resource;

import java.util.LinkedList;

public class Monster extends Character {
    int hp;
    LinkedList<String> reducedExpressions;

    public Monster(String name,String display,String imageCode) {
       super(name, display, imageCode);
       reducedExpressions = new LinkedList<String >();
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void addReducedExpression(String redex) {
        reducedExpressions.add(redex);
        hp += 1;
    }
}
