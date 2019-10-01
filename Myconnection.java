package cms;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author JORDAN TYPE
 */
public class Myconnection {
    public static Connection getConnection(){
    
     Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cms","root","");
            
        } catch (Exception ex) {
           System.out.println(ex.getMessage()) ;
        }
     return conn;
    }
    
}
