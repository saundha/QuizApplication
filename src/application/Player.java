package application;

/**
 * This class holds player data.
 * @author Harpreet Saund
 * @author Sehajpreet Singh
 * @author Sarbjot Singh
 * @version 1.0, 2019-07-08
 */

public class Player {


	/** firstName holds the players first name*/
	private String firstName;
	/** lastName holds the players last name*/
	private String LastName;
	/** userID holds the players user id*/
	private String userId;
	/** sc1 holds score of window 1*/
	private int sc1;
	/** sc2 holds score of window 2*/
	private int sc2;
	/** total holds score of window 1 and window 2 added*/
	private int total;


	public int getSc1() {
		return sc1;
	}


	/**
	 * @param sc1
	 * this methods sets the score1
	 */
	public void setSc1(int sc1) {
		this.sc1 = sc1;
	}


	/**
	 * @return sc2
	 */
	public int getSc2() {
		return sc2;
	}


	/**
	 * @param sc2
	 */
	public void setSc2(int sc2) {
		this.sc2 = sc2;
	}


	/**
	 * @return
	 */
	public int getTotal() {
		return total;
	}


	/**
	 *
	 */
	public void CalcTotal() {
		total = sc1+sc2;
	}


	/**
	 * @param firstName
	 * @param lastName
	 * @param userId
	 */
	public Player(String firstName, String lastName, String userId) {
		setFirstName(firstName);
		setLastName(lastName);
		setUserId(userId);
	}


	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param sc1
	 */
	public Player(int sc1) {
		super();
		this.sc1 = sc1;
	}


	/**
	 * @param sc2
	 */
	public Player(int sc2, String empty) {
		super();
		this.sc2 = sc2;
	}


	/**
	 * @return lastname
	 */
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userID) {
		this.userId = userID;
	}


	/**
	 * @param row
	 */
	public Player(String row) {
		String[] fiedls = row.split(",\\s*");

		setFirstName(fiedls[0]);
		setLastName(fiedls[1]);
		setUserId(fiedls[2]);
	}
}
