package server.model;

public class RequestModel {

    public String prod_type;
    public int amount;

    public RequestModel(String prod_type,
                        int amount) {
        this.prod_type = prod_type;
        this.amount = amount;
    }

}
