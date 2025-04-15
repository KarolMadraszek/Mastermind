package junit4;

import org.mockito.Mockito;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;


public class MockitoTest {
    public static void main(String[] args) {
        String insertSql = "INSERT INTO masterminddb.highscores (name)"

        Connection connection1 = Mockito.mock(Connection.class);
        connection1.prepareStatement(insertSql);

        };

    }
}
