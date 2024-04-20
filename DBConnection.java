import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Connection;
import java.util.logging.Logger;

public class DBConnection {
    private Connection con;
    private String url = "jdbc:mysql://localhost:3307/supplychainmanagement";
    private String user = "root";
    private String pass = "";

    public Connection makeDatabase() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
