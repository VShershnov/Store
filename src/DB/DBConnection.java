package DB;

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
	
		
	// --------Заполнение таблицы--------
	public static void writeDB() throws ClassNotFoundException, SQLException
	{
			statmt = conn.createStatement();
		   statmt.execute("INSERT INTO 'Wherehouse' ('PrGroup', 'Product', 'PrDiscribe', 'PrMaker', 'PrQnt', 'PrPrice') " +
		   		"VALUES ('Непродовольчі', 'Лампочка60', '60 Вт', 'Максус', 4, 12); ");
		  
		   statmt.execute("INSERT INTO 'Wherehouse' ('PrGroup', 'Product', 'PrDiscribe', 'PrMaker', 'PrQnt', 'PrPrice') " +
	   		"VALUES ('Непродовольчі', 'Лампочка100', '100 Вт', 'Максус', 4, 18); ");
		   
		   statmt.execute("INSERT INTO 'Wherehouse' ('PrGroup', 'Product', 'PrDiscribe', 'PrMaker', 'PrQnt', 'PrPrice') " +
	   		"VALUES ('Непродовольчі', 'Лампочка40', '40 Вт', 'Максус', 4, 9); ");
		   
		   statmt.execute("INSERT INTO 'Wherehouse' ('PrGroup', 'Product', 'PrDiscribe', 'PrMaker', 'PrQnt', 'PrPrice') " +
	   		"VALUES ('Непродовольчі', 'Запальничка', 'проста', 'Крікетс', 20, 10); ");
		   
		   statmt.execute("INSERT INTO 'Wherehouse' ('PrGroup', 'Product', 'PrDiscribe', 'PrMaker', 'PrQnt', 'PrPrice') " +
	   		"VALUES ('Продовольчі', 'БорошноВГ', 'вищий гатунок', 'Злагода', 10, 40); ");
		   
		   statmt.execute("INSERT INTO 'Wherehouse' ('PrGroup', 'Product', 'PrDiscribe', 'PrMaker', 'PrQnt', 'PrPrice') " +
	   		"VALUES ('Продовольчі', 'БорошноПГ', 'перший гатунок', 'Злагода', 10, 30); ");
		   
		   statmt.execute("INSERT INTO 'Wherehouse' ('PrGroup', 'Product', 'PrDiscribe', 'PrMaker', 'PrQnt', 'PrPrice') " +
	   		"VALUES ('Продовольчі', 'Хліб Житній', '', 'КиївХліб', 10, 9); ");
		   
		   statmt.execute("INSERT INTO 'Wherehouse' ('PrGroup', 'Product', 'PrDiscribe', 'PrMaker', 'PrQnt', 'PrPrice') " +
	   		"VALUES ('Продовольчі', 'Хліб Батон', '', 'КиївХліб', 10, 11); ");
		   
		   statmt.execute("INSERT INTO 'Wherehouse' ('PrGroup', 'Product', 'PrDiscribe', 'PrMaker', 'PrQnt', 'PrPrice') " +
	   		"VALUES ('Продовольчі', 'Булочки Студент', '', 'КиївХліб', 10, 16); ");
		  
		   System.out.println("Таблица заполнена");
	}
	
	/*/ -------- Вывод таблицы--------
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
	*/
		// --------Закрытие--------
		public static void closeDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			//resSet.close();
			
			System.out.println("Соединения закрыты");
		   }

}
