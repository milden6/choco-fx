package server.runtime;

import server.database.QueryHandler;
import server.exceptions.AuthorizationException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Authorization {

    private String user;
    private String password;

    private QueryHandler queryHandler;
    private String tableName = "default_schema.dbt_users";

    public Authorization(String user, String password) {
        this.user = user;
        this.password = password;

        queryHandler = new QueryHandler();
    }

    public void Login() throws AuthorizationException{

        String query = "SELECT choco_user FROM " + tableName + "" +
                       " WHERE choco_user = '" + user + "'" +
                       "   AND password = '" + password + "'";

        ResultSet resultSet = queryHandler.Select(query);

        try {
            if(resultSet.next()) {
                RuntimeFields.user = resultSet.getString("choco_user");
            }else {
                throw new AuthorizationException("No user");
            }
            resultSet.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
