package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutputTable {

	static int sum;
        public static Connection conn;
	public static Statement statement;
	public static ResultSet rs;

/**
 *
 * @author user
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
 */
	// --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
	public static void connection() throws ClassNotFoundException, SQLException{
           conn = null;
           Class.forName("org.sqlite.JDBC");
           conn = DriverManager.getConnection("jdbc:sqlite:Base.db");
           System.out.println("\n База Подключена!");
           
           statement = conn.createStatement();
           statement.setQueryTimeout(30); // set timeout to 30 sec.
           
	}
        
        static void out(ResultSet rs) throws ClassNotFoundException, SQLException{
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
        public static int outSum() throws ClassNotFoundException, SQLException{
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
        public static void outAllItem() throws ClassNotFoundException, SQLException {
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
}