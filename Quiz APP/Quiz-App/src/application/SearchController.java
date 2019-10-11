package application;
/**
 * This class holds the controll of ResultHandler.fxml.
 * @author Harpreet Saund
 * @author Sehajpreet Singh
 * @author Sarbjot Singh
 * @version 1.0, 2019-07-08
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
 *Thsi method controls the search button
 *
 */
public class SearchController {

	@FXML Button find;
	@FXML Button exit;

	@FXML TextField fName;
	@FXML TextField lName;

	static String name;
	static String score, scorep;
	boolean val;

	public void initialize()
	{
		find.setOnAction(e -> findHandler());
		exit.setOnAction(e -> Platform.exit());
	}

	/**
	 * This method finds the user from the file
	 */
	private void findHandler() {
		int c=0;
		try {
			File f = new File("c:\\temp\\QuizResults.txt");
			Scanner in = new Scanner(f);

			while(in.hasNextLine()) {
				ArrayList <String> fields = new ArrayList<String>();
				fields.add(in.nextLine());
				System.out.println(fields.get(c));
				String [] ff = fields.get(c).split(",\\s*");
				if(ff[1].equalsIgnoreCase(fName.getText()) || ff[2].equalsIgnoreCase(lName.getText()))
				{
					try{

						name = ff[1]+" "+ff[2];
						score = ff[3];
						scorep = ff[4];
						val = true;

					}

					catch(Exception e)
					{
						e.getMessage();
					}

				}

			}
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();


		}

		if(val)
		{
			try {
				AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("CheckResult.fxml"));
				Scene scene = new Scene(root1,900,600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage stage2 = new Stage();
				stage2.setScene(scene);
				stage2.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else{
			Alert al = new Alert(AlertType.ERROR);
			al.setHeaderText("Not found!!");
			al.show();
		}

	}

}




