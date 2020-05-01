package application;
/**
 * @author Harpreet Saund
 * @author Sehajpreet Singh
 * @author Sarbjot Singh
 *@version 1.0 2019-08-07
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *Description class is the controller class for the Quizstarter.fxml
 *
 */

public class QuizStarterController {

	@FXML Button startQuiz;
	@FXML TextField fName;
	@FXML TextField lName;
	@FXML Button exitQuiz;

	static ArrayList <Player> player;

	/**
	 * Description: declaring alert box object.
	 */
	Alert alr = new Alert(AlertType.ERROR);

	/**
	 * Provides setOnAction for all the FXML Controls.
	 */
	public void initialize()
	{
		startQuiz.setOnAction(e -> {
			try {
				QuizStarter();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		exitQuiz.setOnAction(e -> Platform.exit());
	}
	/**
	 * Description this method handles the quiz page.
	 */
	private void QuizStarter() throws IOException {
		Random rd = new Random();
		int userID = rd.nextInt(9000000) + 1000000;
		String firstName = fName.getText();
		String lastName = lName.getText();
		String id = Integer.toString(userID);
		player = new ArrayList<Player>();
		player.add(new Player(firstName.toString(),lastName.toString(),id));
		boolean check = true;
		String message="";
		for(int i = 0 ; i< firstName.length(); i++)
			{
				if(Character.isDigit(firstName.charAt(i)))
						{
							check= false;
							message = "There cannot be any digit in the name";
						}
				if(Character.isDigit(firstName.charAt(i)))
				{
					check= false;
					message = "There cannot be any digit or special char.. in the name";
				}
			}
		if(check == false)
		{
			alr.setHeaderText(message);
			alr.show();
		}
		else if(firstName.length()==0||lastName.length()==0)
		{
			alr.setHeaderText("Fields cannot be left blank!!");
			alr.show();
		}
		else
		{
			FileWriter fw = new FileWriter("c:\\temp\\QuizTakers.txt",true);
			BufferedWriter br = new BufferedWriter(fw);
			br.write(userID+","+firstName+","+lastName);
			br.newLine();
			br.close();
			try {
				AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("QuizHandler.fxml"));
				Scene scene = new Scene(root1,1209,923);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage stage2;
				stage2 = new Stage();
				stage2.setScene(scene);
				stage2.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
