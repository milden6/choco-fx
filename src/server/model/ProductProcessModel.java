package server.model;

public class ProductProcessModel {

    public int id;
    public String datetime;
    public String party;
    public int temperature;
    public float speed;
    public float portion_size;
    public float volume;
    public String grinding_type;
    public float grinding_size;
    public String pack_type;
    public String party_output;
    public float whiping_time;
    public float whiping_intensity;
    public float cream_amount;
    public String taste;
    public String consistency;
    public float amount_per;
    public String respons_user;

    public ProductProcessModel(int id,
                               String datetime,
                               String party,
                               int temperature,
                               float speed,
                               float portion_size,
                               float volume,
                               String grinding_type,
                               float grinding_size,
                               String pack_type,
                               String party_output,
                               float whiping_time,
                               float whiping_intensity,
                               float cream_amount,
                               String taste,
                               String consistency,
                               float amount_per,
                               String respons_user) {

        this.id = id;
        this.datetime = datetime;
        this.party = party;
        this.temperature = temperature;
        this.speed = speed;
        this.portion_size = portion_size;
        this.volume = volume;
        this.grinding_type = grinding_type;
        this.grinding_size = grinding_size;
        this.pack_type = pack_type;
        this.party_output = party_output;
        this.whiping_time = whiping_time;
        this.whiping_intensity = whiping_intensity;
        this.cream_amount = cream_amount;
        this.taste = taste;
        this.consistency = consistency;
        this.amount_per = amount_per;
        this.respons_user = respons_user;

    }
}
