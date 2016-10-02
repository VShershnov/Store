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

/**
 *
 * @author user
 */

class BdRow {
    public int id;
    public String name_group;
    public String name;
    public String discribe;
    public String maker;
    public float price;
    public int count;
}

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
                row.name=rs.getString("name");
                row.discribe=rs.getString("discribe");
                row.maker=rs.getString("maker");
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
    

    



    
    
    
    private static final DateFormat date = new SimpleDateFormat();
    
    // возврат текущей даты
    private  String currentTime() {
		java.util.Date today = new java.util.Date();
		return date.format(today.getTime());
    }
    
    
}
