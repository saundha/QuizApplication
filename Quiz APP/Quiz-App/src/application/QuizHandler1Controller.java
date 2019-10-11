package application;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This class holds Quiz data of first page.
 * @author Harpreet Saund
 * @author Sehajpreet Singh
 * @author Sarbjot Singh
 * @version 1.0, 2019-07-08
 */
public class QuizHandler1Controller {

	public static int score2=0;
	/**
	 * These are the buttos and radio buttons used in the quiz window.
	 */
	@FXML RadioButton ans9;
	@FXML RadioButton ans10;
	@FXML RadioButton ans11;
	@FXML RadioButton ans12;
	@FXML RadioButton ans13;
	@FXML RadioButton ans14;
	@FXML RadioButton ans15;
	@FXML Button cancel;
	@FXML Button submit;

	static ArrayList <Player> sc2;
	/**
	 * Provides setOnAction for all the FXML Controls.
	 */
	public void initialize()
	{
		cancel.setOnAction(e -> cancelHandler());
		submit.setOnAction(e -> submitHandler());
		

	}

	/**
	 * Description: the methos adds up the scores and take the user to next page
	 */
	private void submitHandler() {

		if(ans9.isSelected())
			score2++;
		if(ans10.isSelected())
			score2++;
		if(ans11.isSelected())
			score2++;
		if(ans12.isSelected())
			score2++;
		if(ans13.isSelected())
			score2++;
		if(ans14.isSelected())
			score2++;
		if(ans15.isSelected())
			score2++;

		sc2 = new ArrayList<Player>();
		sc2.add(new Player(score2));
		try {
			AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Result.fxml"));
			Scene scene = new Scene(root1,900,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void cancelHandler() {

		score2=0;
		Platform.exit();
	}
}


