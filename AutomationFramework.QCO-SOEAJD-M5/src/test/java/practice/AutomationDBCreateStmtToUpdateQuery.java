package practice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class AutomationDBCreateStmtToUpdateQuery {
	public static void main(String[] args) {

		Driver driver = new Driver();

		// Step 1: Register the driver
		DriverManager.registerDriver(driver);

		// Step 2: Get Connection with Database -- provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");

		// Step 3: issue create statement
		Statement state = con.createStatement();

		// Step 4: execute a query -- provide table name
		String query = "insert into table empinfo values('Spiderman','london',5);";
		int result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data added successfully");
		}
		
		//Step 5: close db
		con.close();
}}
