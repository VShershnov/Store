package BD;

import BD.AddIntoTable;
import static BD.OutputTable.sum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		OutputTable.outAllItem();
                
                AddIntoTable ad = new AddIntoTable("ftuits", "plum", "якийсь фрукт", "Херрсон", "20", "100");
		ad.addInfo();
                //AddIntoTable.addInfo("ftuits", "plum", "якийсь фрукт", "Херрсон", 20, 100);
		//DeleteRow.delete();
		//OutputTable.out();
		SearchFor.searchName();
                SearchFor.searchGroup();
                System.out.println("The sum of all goods = " + SearchFor.outSum());
		//EditUpdeteName.edit();
	}
}
