package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutputTable {

	public int sum;
        public Connection conn;
	public Statement statement;
	public ResultSet rs;

/**
 *
 * @author vshershnov
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
 */
	// --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
        //возвращает статус "База Подключена!"
	public void connection() throws ClassNotFoundException, SQLException{
           conn = null;
           Class.forName("org.sqlite.JDBC");
           conn = DriverManager.getConnection("jdbc:sqlite:Base.db");
           System.out.println("\n База Подключена!");
           
           statement = conn.createStatement();
           statement.setQueryTimeout(30); // set timeout to 30 sec.
           
	}
        
        public void out(ResultSet rs) throws ClassNotFoundException, SQLException{
            sum = 0;    
            while (rs.next()){
                // read the result set
			System.out.println("id = " + rs.getInt("id")
                        + " name_group = " + rs.getString("name_group")
                        + " name = " + rs.getString("name")
                        + " discribe = " + rs.getString("discribe")
                        + " maker = " + rs.getString("maker")
                        + " price = " + rs.getInt("price")
                        + " count = " + rs.getInt("count")
                        + " date = " + rs.getString("date"));
                // The sum of all goods
                sum += rs.getInt("count");
            }
            System.out.println("===============================");
            System.out.println("The sum of all goods = " + sum);
        }
        
        // The sum of all goods
        public int outSum() throws ClassNotFoundException, SQLException{
            sum = 0;
            try {
                connection();// create a database connection
                rs = statement.executeQuery("select * from Goods");
                while (rs.next())
                sum += rs.getInt("count") * rs.getInt("price");
                
            } catch (SQLException e) {
                // if the error message is "out of memory",
                // it probably means no database file is found
                System.err.println(e.getMessage());
            } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        // connection close failed.
                        System.err.println(e);
                    }
             }
        return sum;    
        }
        
    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
        public void outAllItem() throws ClassNotFoundException, SQLException {
            try {
                connection();// create a database connection
                rs = statement.executeQuery("select * from Goods");
                out(rs); // вивод даних
            } catch (SQLException e) {
                // if the error message is "out of memory",
                // it probably means no database file is found
                System.err.println(e.getMessage());
            } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        // connection close failed.
                        System.err.println(e);
                    }
             }
	}
        
    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @return rs ResultSet of select * from Goods 
     */
    public ResultSet outAllItemRs() throws ClassNotFoundException, SQLException {
            try {
                connection();// create a database connection
                rs = statement.executeQuery("select * from Goods");
                //out(rs); // вивод даних
                
            } catch (SQLException e) {
                // if the error message is "out of memory",
                // it probably means no database file is found
                System.err.println("outAllItemRs()");
            } 
          return rs;   
    }
        
	}
