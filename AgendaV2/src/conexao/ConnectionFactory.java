package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConnectionFactory {
   private static final String URL = "jdbc:mysql://localhost/agenda?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
   private static final String USER   = "myuser";
   private static final String PASS   = "Gmg05m08";
    
   	static {
   		try {
   			Class.forName("com.mysql.cj.jdbc.Driver");
   		} catch (ClassNotFoundException e) {
   			throw new RuntimeException(e);
   		}
   	}
    
   
   public static Connection getConnection() throws SQLException {
    	
    	return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC&user=myuser&password=Gmg05m08");
        
//        try {
//           Class.forName(DRIVER);
//           return DriverManager.getConnection(URL, USER, PASS);
//           
//        } catch (ClassNotFoundException e) {
//           throw new RuntimeException(e);           
//       }
//        
    }
  
}
