package junit4;

import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseTest {

    @Test
    public void connect() {
        String insertSql = "INSERT INTO masterminddb.highscores (name)";

        Connection connection1 = Mockito.mock(Connection.class);
        try {
            connection1.prepareStatement(insertSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
