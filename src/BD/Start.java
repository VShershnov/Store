package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {

	public  static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		OutputTable.outAllItem();
		//AddIntoTable.addInfo();
		//DeleteRow.delete();
		//OutputTable.out();
		SearchFor.searchName();
                SearchFor.searchGroup();
		//EditUpdeteName.edit();
	}
}
