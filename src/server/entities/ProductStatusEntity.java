package server.entities;

import server.database.QueryHandler;
import server.model.ProductStatusModel;

public class ProductStatusEntity {

    //Entity properties
    private int id;
    private String status;
    private String status_txt;

    private QueryHandler queryHandler;
    private static final String tableName = "default_schema.dbt_product_stat";

    public enum Status {
        E0001("Подготовка"), E0002("Утверд. орех"),
        E0003("Наполн. шок."), E0004("Взбив. сливок"),
        E0005("Упаковка");

        public final String status_text;

        Status(String status_text){
            this.status_text = status_text;
        }
    }

    public ProductStatusEntity(ProductStatusModel productStatusModel) {
        this.id = productStatusModel.id;
        this.status = productStatusModel.status;
        this.status_txt = productStatusModel.status_txt;

        queryHandler = new QueryHandler();
    }

    public void createStatus() {
        String query = "INSERT INTO " + tableName + "" +
                "(id, status, status_txt) " +
                "VALUES ('" + id + "'," +
                "        '" + status + "', " +
                "        '" + status_txt + "' )";

        queryHandler.Insert(query);
        queryHandler.CloseConnection();
    }

    public void updateStatus() {

        String query = "UPDATE " + tableName + "" +
                " SET status = '" + status + "', " +
                " status_txt = '" + status_txt + "'" +
                " WHERE id = " + id + "";

        queryHandler.Update(query);
        queryHandler.CloseConnection();
    }

}
