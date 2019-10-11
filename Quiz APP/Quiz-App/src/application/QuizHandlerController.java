package application;
/**
 * This class holds the controll of QuizHandler.fxml.
 * @author Harpreet Saund
 * @author Sehajpreet Singh
 * @author Sarbjot Singh
 * @version 1.0, 2019-07-08
 */
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class QuizHandlerController {

	public static  int score=0;
	public int s;
	@FXML RadioButton ans1;
	@FXML RadioButton ans2;
	@FXML RadioButton ans3;
	@FXML RadioButton ans4;
	@FXML RadioButton ans5;
	@FXML RadioButton ans6;
	@FXML RadioButton ans7;
	@FXML RadioButton ans8;
	@FXML Button cancel;
	@FXML Button next;
	@FXML Label player;

	static ArrayList <Player> sc1;

	/**
	 * Provides setOnAction for all the FXML Controls.
	 */
	public void initialize()
	{
		cancel.setOnAction(e -> cancelHandler());
		next.setOnAction(e -> nextHandler());
	}

	/**
	 * This method handles the action on next button
	 */
	private void nextHandler() {

		if(ans1.isSelected())
			score++;
		if(ans2.isSelected())
			score++;
		if(ans3.isSelected())
			score++;
		if(ans4.isSelected())
			score++;
		if(ans5.isSelected())
			score++;
		if(ans6.isSelected())
			score++;
		if(ans7.isSelected())
			score++;
		if(ans8.isSelected())
			score++;
		sc1 = new ArrayList<Player>();
		sc1.add(new Player(score));
		try {
			AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("QuizHandler1.fxml"));
			Scene scene = new Scene(root1,1209,923);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage3 = new Stage();
			stage3.setScene(scene);
			stage3.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

		s=score;
		System.out.println("Score 1: "+s);

	}

	private void cancelHandler() {

		score=0;
		Platform.exit();
	}
}
