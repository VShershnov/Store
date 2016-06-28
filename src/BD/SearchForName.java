package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchForName {

	public static void search() throws ClassNotFoundException {
		{
			// load the sqlite-JDBC driver using the current class loader
			Class.forName("org.sqlite.JDBC");

			Connection connection = null;
			try {
				// create a database connection
				connection = DriverManager
						.getConnection("jdbc:sqlite:C:/Users/Trovich/workspace/BDSQLite/Base.db");
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.
				//===========Search for name_group of goods
				ResultSet rs;
				rs = statement
						.executeQuery("SELECT * FROM Goods WHERE name_group = 'fruits'");
				while (rs.next()) {
					String lastName = rs.getString("id");
					String name_group = rs.getString("name_group");
					String name = rs.getString("name");
					String count = rs.getString("count");
					String date = rs.getString("date");
					System.out.println(lastName + " " + name_group + " " + name
							+ " " + count + " " + date);
				}
				//===========Search for name of goods
				
				ResultSet rsName;
				
				rsName=statement.executeQuery("SELECT * FROM Goods WHERE name = 'plum'");
				while (rsName.next()) {
					String lastName = rsName.getString("id");
					String name_group = rsName.getString("name_group");
					String name = rsName.getString("name");
					String count = rsName.getString("count");
					String date = rsName.getString("date");
					System.out.println(lastName + " " + name_group + " " + name
							+ " " + count + " " + date);
				}
				

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
	}

	private static void searchGroup() {
		// TODO Auto-generated method stub
		
	}
}