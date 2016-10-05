package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class SearchFor extends OutputTable {
        
    ////===========Search for name of goods
        public void searchName(String name) throws ClassNotFoundException, SQLException {
		sum = 0;
                try {
                    connection();// create a database connection
                    //===========Search for name of goods
                    rs =statement.executeQuery("SELECT * FROM Goods WHERE name = '" + name + "'");
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
        
        ////===========Search for name_group of goods
	public void searchNemeByGroup(String group) throws ClassNotFoundException, SQLException {
                sum = 0;
                try {
                    connection();// create a database connection
                    //===========Search for name_group of goods
                    rs = statement.executeQuery("SELECT * FROM Goods WHERE name_group = '" + group + "'");
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
        
        ////===========Search for name_group of goods
        ////===========в планах заменить на механизм выборки поля name_group из коллекции обьектов
	public void tePrintSearchGroup() throws ClassNotFoundException, SQLException {

	
                try {
                    connection();// create a database connection
                    //===========Search for name_group of goods
                    rs = statement.executeQuery("SELECT DISTINCT name_group FROM Goods");
                    // вивод уникальных групп товара 
                    while (rs.next()) 
                        System.out.println(" name_group = " + rs.getString("name_group"));
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
        

        ////===========в планах заменить на механизм выборки поля name_group из коллекции обьектов
        public ResultSet searchGroup() throws ClassNotFoundException, SQLException {
                try {
                    connection();// create a database connection
                    //===========Search for name_group of goods
                    rs = statement.executeQuery("SELECT DISTINCT name_group FROM Goods");
                    
                    // вивод уникальных групп товара 
                    while (rs.next()) 
                        System.out.println(" name_group = " + rs.getString("name_group"));
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
                return rs;
        }
        

        public ArrayList searchSumByGroup() throws ClassNotFoundException, SQLException {
                ArrayList groupList = null;
                try {
                    connection();// create a database connection
                    //===========Search for name_group of goods
                    rs = statement.executeQuery("SELECT name_group, sum(count) as count, "
                                                + "sum(price*count) as cost FROM Goods\n" 
                                                +"group by name_group");
                    BdRowAndCollection groupCol = new BdRowAndCollection();
                    groupList = groupCol.bdGoupToCollection(rs);

                    // вивод уникальных групп товара 
                   // while (rsg.next()) 
                   //     System.out.println(" name_group = " + rsg.getString("name_group"));
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
                return groupList;
        }


        }
        
