package models;

/**
 * Created by clairescout on 1/19/18.
 */

public class RequestData {
    private String data;

    public RequestData(String data){
        this.data = data;
    }

    public RequestData(){}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
