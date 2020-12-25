package server.database;

import java.sql.*;

public class QueryHandler {

    private Statement statement;

    public QueryHandler() {
        try {
            statement = DatabaseConnector.getDatabaseConnector().createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void Insert(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void Update(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public ResultSet Select(String query) {
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return resultSet;
    }

    public void CloseConnection() {
        try {
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
