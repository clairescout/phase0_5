package models;

/**
 * Created by clairescout on 1/13/18.
 */

public class Results {
    private boolean success;
    private String data;
    private String message;

    public Results(boolean success, String data, String message){
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public Results(){}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
