package client;

import com.google.gson.Gson;

import models.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class Serializer {


    private Gson gson = new Gson();
    public Serializer(){}

    public Results decodeResults(String data){
        return gson.fromJson(data, Results.class);
    }

    public String encode(Object o){
        return gson.toJson(o);
    }

}
