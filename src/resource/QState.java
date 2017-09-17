package resource;

public class QState {
	public int correct;
	public String nextReduced;
	public String[][] options;
	
	public QState(int correct, String nextReduced, String[][] options) {
		this.correct = correct;
		this.nextReduced = nextReduced;
		this.options = options;
	}
}
