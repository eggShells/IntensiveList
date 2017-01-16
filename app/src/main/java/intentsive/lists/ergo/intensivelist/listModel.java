package intentsive.lists.ergo.intensivelist;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ericd_000 on 1/2/2017.
 */

public class listModel {

    private UUID farmID;
    private String farm_name;
    private String farm_address;
    private String farm_owner;
    private String farm_type;
    private String farm_city;
    private ArrayList product_list;


    public void listModel(){
        farmID = UUID.randomUUID();
    }

    public void listModel(String inString){
        farmID = UUID.randomUUID();
        farm_name = inString;
    }

    public UUID getListID() {
        return farmID;
    }

    public String getfarm_name() {
        return farm_name;
    }

    public void setfarm_name(String lItem) {
        this.farm_name = lItem;
    }

    public String getFarm_address() {
        return farm_address;
    }

    public void setFarm_address(String farm_address) {
        this.farm_address = farm_address;
    }

    public String getFarm_owner() {
        return farm_owner;
    }

    public void setFarm_owner(String farm_owner) {
        this.farm_owner = farm_owner;
    }

    public String getFarm_type() {
        return farm_type;
    }

    public void setFarm_type(String farm_type) {
        this.farm_type = farm_type;
    }

    public String getFarm_city() {
        return farm_city;
    }

    public void setFarm_city(String farm_city) {
        this.farm_city = farm_city;
    }

    public ArrayList getProduct_list() {
        return product_list;
    }

    public void setProduct_list(ArrayList product_list) {
        this.product_list = product_list;
    }
}
