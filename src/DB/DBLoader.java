import java.sql.SQLException;


public class DBLoader {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBConnection.connection();
		//DBConnection.createDB();
		DBConnection.writeDB();
		//DBConnection.readDB();
		DBConnection.closeDB();
	}
}
