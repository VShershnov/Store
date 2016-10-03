package BD;

import BD.AddIntoTable;
import BD.OutputTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Start {

	public static void main(String[] args) throws ClassNotFoundException,
		SQLException {
		
               OutputTable outable = new OutputTable();
               outable.outAllItem();
                
                AddIntoTable ad = new AddIntoTable("fruits", "plum", "якийсь фрукт", "Херрсон", "20", "100");
                ad.addInfo();
                //AddIntoTable.addInfo("ftuits", "plum", "якийсь фрукт", "Херрсон", 20, 100);
		//DeleteRow.delete();
		//OutputTable.out();
		
<<<<<<< Updated upstream
                SearchFor search = new SearchFor();
                search.searchGroup("fruits");
                search.searchName("plum");
                System.out.println("The sum of all goods = " + search.outSum());
=======
               SearchFor search = new SearchFor();
                //search.searchNemeByGroup("fruits");
               // search.searchName("plum");
               // System.out.println("The sum of all goods = " + search.outSum());
                
              // ResultSet rsg = search.searchGroup();
              // while (rsg.next()) 
              //          System.out.println(" name_group = " + rsg.getString("name_group"));
                
             // ResultSet rsg = search.searchSumByGroup();
             //  while (rsg.next()) 
             //           System.out.println(" name_group = " + rsg.getString("name_group") 
             //                           + " count = " + rsg.getString("count") 
             //                           + " costs = " + rsg.getString("costs"));
                
             ResultSet rsg = search.searchSumByGroup();
             BdRowAndCollection groupCollection = new BdRowAndCollection();
             ArrayList group = groupCollection.bdGoupToCollection(rsg);
            //System.out.println(group.toString());
>>>>>>> Stashed changes
		//EditUpdeteName.edit();
	}
}
