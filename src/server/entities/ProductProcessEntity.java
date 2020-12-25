package server.entities;

import server.database.QueryHandler;
import server.model.ProductProcessModel;
import server.runtime.RuntimeFields;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductProcessEntity {

    //Entity properties
    private String party;
    private int temperature;
    private float speed;
    private float portion_size;
    private float volume;
    private String grinding_type;
    private float grinding_size;
    private String pack_type;
    private String party_output;
    private float whiping_time;
    private float whiping_intensity;
    private float cream_amount;
    private String taste;
    private String consistency;
    private float amount_per;

    private QueryHandler queryHandler;
    private static final String tableName = "default_schema.dbt_product_proc";

    public ProductProcessEntity(ProductProcessModel productProcessModel) {

        this.party = productProcessModel.party;
        this.temperature = productProcessModel.temperature;
        this.speed = productProcessModel.speed;
        this.portion_size = productProcessModel.portion_size;
        this.volume = productProcessModel.volume;
        this.grinding_type = productProcessModel.grinding_type;
        this.grinding_size = productProcessModel.grinding_size;
        this.pack_type = productProcessModel.pack_type;
        this.party_output = productProcessModel.party_output;
        this.whiping_time = productProcessModel.whiping_time;
        this.whiping_intensity = productProcessModel.whiping_intensity;
        this.cream_amount = productProcessModel.cream_amount;
        this.taste = productProcessModel.taste;
        this.consistency = productProcessModel.consistency;
        this.amount_per = productProcessModel.amount_per;

        queryHandler = new QueryHandler();

    }

    public ProductProcessEntity() {

        queryHandler = new QueryHandler();
    }

    public void createProductProcess() {

        String query = "INSERT INTO " + tableName + "" +
                "(id, datetime, party, temperature, speed, portion_size," +
                " volume, grinding_type, grinding_size, pack_type, party_output," +
                " whiping_time, whiping_intensity, cream_amount, taste, consistency," +
                " amount_per, respons_user) " +
                "VALUES ('" + getNextId() + "'," +
                "        '" + RuntimeFields.GetTimestamp() + "', " +
                "        '" + party + "', " +
                "        '" + temperature + "', " +
                "        '" + speed + "', " +
                "        '" + portion_size + "', " +
                "        '" + volume + "', " +
                "        '" + grinding_type + "', " +
                "        '" + grinding_size + "', " +
                "        '" + pack_type + "', " +
                "        '" + party_output + "', " +
                "        '" + whiping_time + "', " +
                "        '" + whiping_intensity + "', " +
                "        '" + cream_amount + "', " +
                "        '" + taste + "', " +
                "        '" + consistency + "', " +
                "        '" + amount_per + "', " +
                "        '" + RuntimeFields.user + "' )";

        queryHandler.Insert(query);
        queryHandler.CloseConnection();
    }

    public int getNextId() {

        String query = "SELECT MAX( id ) FROM " + tableName + "";
        ResultSet resultSet = queryHandler.Select(query);
        int nextNumber = 0;

        try {
            while (resultSet.next()) {
                nextNumber = resultSet.getInt("max");
            }
            resultSet.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return nextNumber + 1;
    }

    public void updateProductProcess(int id) {

        String query = "UPDATE " + tableName + "" +
                "SET datetime = '" + RuntimeFields.GetTimestamp() + "', " +
                " party = '" + party + "', " +
                " temperature = " + temperature + ", " +
                " speed = " + speed + ", " +
                " portion_size = " + portion_size + ", " +
                " volume = " + volume + ", " +
                " grinding_type = '" + grinding_type + "', " +
                " grinding_size = " + grinding_size + ", " +
                " pack_type = '" + pack_type + "', " +
                " party_output = '" + party_output + "', " +
                " whiping_time = " + whiping_time + ", " +
                " whiping_intensity = " + whiping_intensity + ", " +
                " cream_amount = " + cream_amount + ", " +
                " taste = '" + taste + "', " +
                " consistency = " + consistency + ", " +
                " amount_per = " + amount_per + "" +
                " WHERE id = " + id + "";

        queryHandler.Update(query);
        queryHandler.CloseConnection();
    }

    public ArrayList<ProductProcessModel> getProductProcesses() {

        ArrayList<ProductProcessModel> productProcessModels = new ArrayList<>();
        ProductProcessModel productProcessModel = null;

        String query = "SELECT * FROM " + tableName + "";
        ResultSet resultSet = queryHandler.Select(query);

        try {
            while (resultSet.next()) {
                productProcessModel = new ProductProcessModel(
                        resultSet.getInt("id"),
                        resultSet.getString("datetime"),
                        resultSet.getString("party"),
                        resultSet.getInt("temperature"),
                        resultSet.getFloat("speed"),
                        resultSet.getFloat("portion_size"),
                        resultSet.getFloat("volume"),
                        resultSet.getString("grinding_type"),
                        resultSet.getFloat("grinding_size"),
                        resultSet.getString("pack_type"),
                        resultSet.getString("party_output"),
                        resultSet.getFloat("whiping_time"),
                        resultSet.getFloat("whiping_intensity"),
                        resultSet.getFloat("cream_amount"),
                        resultSet.getString("taste"),
                        resultSet.getString("consistency"),
                        resultSet.getFloat("amount_per"),
                        resultSet.getString("respons_user")
                );

                productProcessModels.add(productProcessModel);
            }
            resultSet.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        queryHandler.CloseConnection();
        return productProcessModels;
    }

}
