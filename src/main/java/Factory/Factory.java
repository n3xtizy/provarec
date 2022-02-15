package Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}