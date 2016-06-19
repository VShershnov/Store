package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AddIntoTable {
	
	private String name_group;
	private String name;
	private int count;
	
	
	AddIntoTable(String name_group, String name, int count){
		this.name_group=name_group;
		this.name=name;
		this.count=count;
	}
	private static final DateFormat date = new SimpleDateFormat();

	public static void addInfo() throws ClassNotFoundException {
		// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;

		String insertSQL = "INSERT INTO Goods VALUES"
				+ "(?,'name_group','name',count, " + "('" + getCurrentTimeStamp()
				+ "'))";
		try {
			// create a database connection
			connection = DriverManager
					.getConnection("jdbc:sqlite:C:/Users/Trovich/workspace/BDSQLite/Base.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate(insertSQL);
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
	}

	private static String getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return date.format(today.getTime());
	}
}
