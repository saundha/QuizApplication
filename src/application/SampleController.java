package application;
/**
 * This class holds the controll of ResultHandler.fxml.
 * @author Harpreet Saund
 * @author Sehajpreet Singh
 * @author Sarbjot Singh
 * @version 1.0, 2019-07-08
 */

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SampleController {
	@FXML Button launchQuiz;
	@FXML Button exit;
	@FXML Button checkR;
	String name;
	double score;
	public void initialize()
	{
		launchQuiz.setOnAction(e -> quizHandler());
		checkR.setOnAction(e ->CheckQuizHandler());
		exit.setOnAction(e -> Platform.exit());
	}

	private void quizHandler() {
		try {
			AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("QuizStarter.fxml"));
			Scene scene = new Scene(root1,540,644);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	private void CheckQuizHandler() {

		try {
			AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Search.fxml"));
			Scene scene = new Scene(root1,435,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
