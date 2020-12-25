package server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnector {

    private static String url = "jdbc:postgresql://localhost:5432/choco_database?" +
                                "user=postgres&password=1234";
    private static Connection connection;

    public static Connection getDatabaseConnector() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return connection;
    }
}
