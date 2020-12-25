package server.entities;

import server.database.QueryHandler;
import server.model.RequestModel;
import server.runtime.RuntimeFields;

public class RequestEntity {

    //Entity properties
    private String prod_type;
    private int amount;

    private QueryHandler queryHandler;
    private static final String tableName = "default_schema.dbt_request";

    public RequestEntity(RequestModel requestModel) {

        this.prod_type = requestModel.prod_type;
        this.amount = requestModel.amount;
        queryHandler = new QueryHandler();
    }

    public void createRequest() {
        String query = "INSERT INTO " + tableName + "" +
                       "(prod_type, amount, datetime, choco_user) " +
                       "VALUES ('" + prod_type + "'," +
                       "        '" + amount + "', " +
                       "        '" + RuntimeFields.GetTimestamp() + "', " +
                       "        '" + RuntimeFields.user + "' )";

        queryHandler.Insert(query);
        queryHandler.CloseConnection();
    }
}
