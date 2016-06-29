package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AddIntoTable extends OutputTable {
	
	private  String name_group;
	private  String name;
        private String discribe;
        private String maker;
        private  String price;
	private String count;
	
           
	
	public AddIntoTable(String name_group, String name, String discribe, String maker, String price, String count) throws ClassNotFoundException{
		this.name_group=name_group;
		this.name=name;
		this.count=count;
                this.discribe=discribe;
                this.maker=maker;
                this.price=price;       
                
	}
	private static final DateFormat date = new SimpleDateFormat();

	public void addInfo() throws ClassNotFoundException {
		//String name_group, String name, String discribe, String maker, int price, int count
                
                String insertSQL = "INSERT INTO Goods VALUES"
				+ "(?, '"+ name_group+"' , '"+name+"', '"+discribe+"', '"+maker+"'," + count+","+ price+", " 
                        + "('" + currentTime() + "'))";
                
		try {
			connection();// create a database connection
			statement.executeUpdate(insertSQL);
                        outAllItem();
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

	private  String currentTime() {
		java.util.Date today = new java.util.Date();
		return date.format(today.getTime());
	}
}
