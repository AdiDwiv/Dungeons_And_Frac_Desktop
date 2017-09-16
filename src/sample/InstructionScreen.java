package sample;

import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class InstructionScreen {

	 public static FlowPane getInstructions() {
		 FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
		 Text title = new Text();
	     title.setText("How To Play");
	     Text paragraph1 = new Text();
	     paragraph1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu mi fringilla, mattis metus at, vulputate ex. Phasellus ac sollicitudin dui. Nulla facilisi. Nullam at interdum felis. Nam laoreet nisl eu felis aliquam, porta rhoncus justo laoreet. Vestibulum tincidunt metus nec nibh rutrum commodo.");
	     paragraph1.wrappingWidthProperty().bind(flowPane.widthProperty());
	     flowPane.getChildren().addAll(title, paragraph1);
	     
		 return flowPane;
	 }
	
}
