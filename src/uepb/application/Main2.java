package uepb.application;

import uepb.view.Tela;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main2 extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Tela().start(primaryStage);	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
