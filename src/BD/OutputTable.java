package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutputTable {

	private static int sum;

	public static void out() throws ClassNotFoundException {
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

				ResultSet rs = statement.executeQuery("select * from Goods");
				while (rs.next()) {
					// read the result set
					System.out.println("id = " + rs.getInt("id"));
					System.out.println("name_group = "
							+ rs.getString("name_group"));
					System.out.println("name = " + rs.getString("name"));
					System.out.println("count = " + rs.getInt("count"));
					System.out.println("date = " + rs.getString("date"));
					// The sum of all goods
					sum += rs.getInt("count");
				}
				System.out.println("===============================");
				System.out.println("The sum of all goods = " + sum);
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
}