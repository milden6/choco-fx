package server.model;

public class ProductStatusModel {

    public int id;
    public String status;
    public String status_txt;

    public ProductStatusModel(int id,
                               String status,
                               String status_txt) {
        this.id = id;
        this.status = status;
        this.status_txt = status_txt;
    }

}
