package models;

/**
 * Created by clairescout on 1/20/18.
 */

public class CommandData {
    private String data;
    private String methodType;

    public CommandData(){}

    public CommandData(String methodType, String data){
        this.methodType = methodType;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }
}
