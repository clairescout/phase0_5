package client;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import theseclasses.Command;
import theseclasses.RequestData;
import theseclasses.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class Serializer {


    private Gson gson = new Gson();
    public Serializer(){}

    public Results decodeResults(String data){
        return gson.fromJson(data, Results.class);
    }

    public String encodeResults(Results r){
        return gson.toJson(r);
    }

    public String encodeRequestData(RequestData req){
        return gson.toJson(req);
    }
    public String encodeCommand(Command command){return gson.toJson(command);}

    public String encode(Object o){
        return gson.toJson(o);
    }

}
