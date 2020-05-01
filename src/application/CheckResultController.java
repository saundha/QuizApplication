package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * This class getz Quiz data of the person who just fin.
 * @author Harpreet Saund
 * @author Sehajpreet Singh
 * @author Sarbjot Singh
 * @version 1.0, 2019-07-08
 */
public class CheckResultController {

	@FXML Label nameR;
	@FXML Label nameRR;
	@FXML Label date;
	@FXML Label scoreR;
	@FXML Label scoreRR;

	/**
	 * @return formattedDate
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
	public void initialize()
	{
		nameRR.setText(SearchController.name);
		nameR.setText(SearchController.name);
		date.setText(getCurrentDate());
		scoreR.setText(SearchController.scorep+"%");
		scoreRR.setText("Scored:"+SearchController.score+"/"+"15");
	}
}
