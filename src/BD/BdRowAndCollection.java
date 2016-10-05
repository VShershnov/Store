/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author user
 */




public class BdRowAndCollection extends OutputTable {
    
    /**
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public ArrayList bdAllRowToCollection ()throws ClassNotFoundException, SQLException {
    
        ArrayList<BdRow> bdCollection = new ArrayList<BdRow>();
        try {
            ResultSet rsc = outAllItemRs();
            while(rsc.next()){
                BdRow row = new BdRow();
                row.id=rsc.getInt("id");
                row.name_group=rsc.getString("name_group");
                row.name=rsc.getString("name");
                row.discribe=rsc.getString("discribe");
                row.maker=rsc.getString("maker");
                row.price=rsc.getFloat("count");
                row.count=rsc.getInt("count");
                bdCollection.add(row);
            }
	
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
    return bdCollection;
    }
    
    public ArrayList bdAllRowToCollection (ResultSet rs)throws ClassNotFoundException, SQLException {
    
        ArrayList<BdRow> bdCollection = new ArrayList<BdRow>();
        try {
            while(rs.next()){
                BdRow row = new BdRow();
                row.id=rs.getInt("id");
                row.name_group=rs.getString("name_group");
                row.name=rs.getString("name");
                row.discribe=rs.getString("discribe");
                row.maker=rs.getString("maker");
                row.price=rs.getFloat("count");
                row.count=rs.getInt("count");
                bdCollection.add(row);
            }
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
    return bdCollection;
    }
    
    public ArrayList bdGoupToCollection (ResultSet rs)throws ClassNotFoundException, SQLException {
    
        ArrayList<BdGroup> groupCol = new ArrayList<BdGroup>();
        try {
            while(rs.next()){
                BdGroup row = new BdGroup();
                row.name_group=rs.getString("name_group");
                row.count=rs.getInt("count");
                row.cost=rs.getFloat("cost");
                groupCol.add(row);
            }
            
	} catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
	} 
        return groupCol;
    }
    

static void displayAll(Collection col) {
      Iterator itr = col.iterator();
      while (itr.hasNext()) {
         String str = (String) itr.next();
         System.out.print(str + " ");
      }
      System.out.println();
   }

    
    
    
    private static final DateFormat date = new SimpleDateFormat();
    
    // возврат текущей даты
    private  String currentTime() {
		java.util.Date today = new java.util.Date();
		return date.format(today.getTime());
    }
    
    
}


    
    



