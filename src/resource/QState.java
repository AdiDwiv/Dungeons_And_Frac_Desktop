package resource;

public class QState {
	private int correct;
	private String nextReduced;
	private String[][] options;
	
	public QState(int correct, String nextReduced, String[][] options) {
		this.correct = correct;
		this.nextReduced = nextReduced;
		this.options = options;
	}
}
