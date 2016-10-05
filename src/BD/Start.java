package BD;

import BD.AddIntoTable;
import BD.OutputTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Start {

	public static void main(String[] args) throws ClassNotFoundException,
		SQLException {
		
            //OutputTable outable = new OutputTable();
            //outable.outAllItem();
                
            //AddIntoTable ad = new AddIntoTable("fruits", "plum", "якийсь фрукт", "Херрсон", "20", "100");
            //ad.addInfo();
            //AddIntoTable.addInfo("ftuits", "plum", "якийсь фрукт", "Херрсон", 20, 100);
            //DeleteRow.delete();
            //OutputTable.out();
		

            SearchFor search = new SearchFor();
            //search.searchGroup("fruits");
            //search.searchName("plum");
            //System.out.println("The sum of all goods = " + search.outSum());

               
            //search.searchNemeByGroup("fruits");
            // search.searchName("plum");
            // System.out.println("The sum of all goods = " + search.outSum());
                
            // ResultSet rsg = search.searchGroup();
            // while (rsg.next()) 
            //          System.out.println(" name_group = " + rsg.getString("name_group"));
                
            ArrayList group = search.searchSumByGroup();
            //displayAll(group);
            
            System.out.println(" name_group = " + group.toString());
            
            //  while (rsg.next()) 
            //           System.out.println(" name_group = " + rsg.getString("name_group") 
            //                           + " count = " + rsg.getString("count") 
            //                           + " costs = " + rsg.getString("costs"));
                
            
            

            //ResultSet rsg = search.searchSumByGroup();
            //BdRowAndCollection groupCollection = new BdRowAndCollection();
            //ArrayList group = groupCollection.bdGoupToCollection(rsg);
            
            //System.out.println(group.toString());

            //EditUpdeteName.edit();
	
        
        }

        
        //static void displayAll(Collection col) {
          //      Iterator itr = col.iterator();
          //      while (itr.hasNext()) {
          //          String str = (String) itr.next();
          //          System.out.print(str + " ");
          //      }
          //      System.out.println();
        //}
}