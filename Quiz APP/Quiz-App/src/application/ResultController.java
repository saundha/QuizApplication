package application;
/**
 * This class holds the controll of ResultHandler.fxml.
 * @author Harpreet Saund
 * @author Sehajpreet Singh
 * @author Sarbjot Singh
 * @version 1.0, 2019-07-08
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class ResultController {

	@FXML Label nameR;
	@FXML Label nameRR;
	@FXML Label date;
	@FXML Label scoreR;
	@FXML Label scoreRR;
	/**
	 * Provides system date
	 */
	public String getCurrentDate() {
		Date date = new Date();
		String strDateFormat = "yyyy/MM/dd";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate= dateFormat.format(date);
		return formattedDate;
	}
	/**
	 * Provides setOnAction for all the FXML Controls.
	 */
	public void initialize() throws IOException
	{
		int finalScore = QuizHandlerController.score+QuizHandler1Controller.score2;
		String fScore = Double.toString(finalScore);
		double finalScoreP = ((double)finalScore)/15;
		double finalP = finalScoreP*100;
		double finalR = Math.round(finalP*100.0)/100.0;
		String fScoreP = Double.toString(finalR);
		System.out.println(QuizHandlerController.score+" : "+QuizHandler1Controller.score2);
		System.out.println(finalR);
		nameRR.setText(QuizStarterController.player.get(QuizStarterController.player.size()-1).getFirstName()+" "
				+QuizStarterController.player.get(QuizStarterController.player.size()-1).getLastName());
		nameR.setText(QuizStarterController.player.get(QuizStarterController.player.size()-1).getFirstName()+" "
				+QuizStarterController.player.get(QuizStarterController.player.size()-1).getLastName());
		date.setText(getCurrentDate());
		scoreR.setText(fScoreP+"%");
		scoreRR.setText("Scored:"+fScore+"/"+"15.");
		Alert alr = new Alert(AlertType.INFORMATION);

		alr.setHeaderText("Your User ID:"+QuizStarterController.player.get(QuizStarterController.player.size()-1).getUserId());
		alr.showAndWait();

		FileWriter fr = new FileWriter("c:\\temp\\QuizResults.txt",true);
		BufferedWriter br = new BufferedWriter(fr);

		br.write(QuizStarterController.player.get(QuizStarterController.player.size()-1).getUserId()+","
				+QuizStarterController.player.get(QuizStarterController.player.size()-1).getFirstName()+","
				+QuizStarterController.player.get(QuizStarterController.player.size()-1).getLastName()+","+finalScore+","+finalR);
		br.newLine();
		br.close();
	}
}
