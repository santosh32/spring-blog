package in.spring4buddies.application.helper;

public class Constants {

	private Constants() {
	}

	public static final String SQL_NEW_CUSTOMER = "INSERT INTO CUSTOMER(NAME, ADDRESS, CITY, STATE, ZIP_CD) VALUES(?,?,?,?,?)";
	public static final String SQL_UPDATE_CUSTOMER = "UPDATE CUSTOMER SET NAME = ?, ADDRESS = ?, CITY = ?, STATE = ?, ZIP_CD = ? WHERE CUST_ID = ?";
	public static final String SQL_DELETE_CUSTOMER = "DELETE FROM CUSTOMER WHERE CUST_ID = ?";
	public static final String SQL_FIND_ALL_CUSTOMERS = "SELECT * FROM CUSTOMER";
	public static final String SQL_FIND_BY_CUST_ID = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

}