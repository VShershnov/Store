import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	
	// --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
	public static void connection() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:StoreLineDBv1.db");
		   
		   System.out.println("База Подключена!");
	   }
	
	// --------Создание таблицы--------
	public static void createDB() throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
		
		System.out.println("Таблица создана или уже существует.");
	   }
	
	// --------Заполнение таблицы--------
	public static void writeDB() throws SQLException
	{
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");
		  
		   System.out.println("Таблица заполнена");
	}
	
	// -------- Вывод таблицы--------
	public static void readDB() throws ClassNotFoundException, SQLException
	   {
		resSet = statmt.executeQuery("SELECT * FROM users");
		
		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String  name = resSet.getString("name");
			String  phone = resSet.getString("phone");
	         System.out.println( "ID = " + id + " name = " + name  + " phone = " + phone );
		}	
		
		System.out.println("Таблица выведена");
	    }
	
		// --------Закрытие--------
		public static void closeDB() throws ClassNotFoundException, SQLException
		   {
			//conn.close();
			statmt.close();
			resSet.close();
			
			System.out.println("Соединения закрыты");
		   }

}
