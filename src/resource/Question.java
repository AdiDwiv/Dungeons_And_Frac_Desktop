package resource;

import java.util.LinkedList;

public class Question {
	
	String equation;
	public LinkedList<QState> states;
	
	public Question(String equation, LinkedList<QState> states) {
		this.equation = equation;
		this.states = states;
	}
	
}
