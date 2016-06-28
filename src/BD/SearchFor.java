package BD;

import static BD.OutputTable.out;
import static BD.OutputTable.rs;
import static BD.OutputTable.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchFor extends OutputTable {
        
	public static void searchName() throws ClassNotFoundException, SQLException {
		sum = 0;
                try {
                    connection();// create a database connection
                    //===========Search for name of goods
                    rs =statement.executeQuery("SELECT * FROM Goods WHERE name = 'plum'");
                    out(rs); // вивод даних
		} catch (SQLException e) {
                    // if the error message is "out of memory",
                    // it probably means no database file is found
                    System.err.println(e.getMessage());
		} finally {
			try {
                            if (conn != null)
				conn.close();
                        } catch (SQLException e) {
                            // connection close failed.
                            System.err.println(e);
			}
		}
	}

	public static void searchGroup() throws ClassNotFoundException, SQLException {
                sum = 0;
                try {
                    connection();// create a database connection
                    //===========Search for name_group of goods
                    rs = statement.executeQuery("SELECT * FROM Goods WHERE name_group = 'fruits'");
                    out(rs); // вивод даних
		} catch (SQLException e) {
                    // if the error message is "out of memory",
                    // it probably means no database file is found
                    System.err.println(e.getMessage());
		} finally {
			try {
                            if (conn != null)
				conn.close();
                        } catch (SQLException e) {
                            // connection close failed.
                            System.err.println(e);
			}
		}
        }
}