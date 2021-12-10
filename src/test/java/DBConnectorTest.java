import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorTest {
    @Test
    public void connectTest() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/","postgres", "password");
        Assertions.assertNotNull(connection);
        connection.close();
    }
}
