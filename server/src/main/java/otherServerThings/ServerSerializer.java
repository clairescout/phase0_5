package otherServerThings;

import theseclasses.Command;
import theseclasses.RequestData;
import theseclasses.Results;
import com.google.gson.Gson;

/**
 * Created by clairescout on 1/15/18.
 */

public class ServerSerializer {

    private Gson gson = new Gson();

    public ServerSerializer(){

    }

    public String encodeResults(Results r){
        return gson.toJson(r);
    }

    public RequestData decodeRequestData(String req){
        return gson.fromJson(req, RequestData.class);
    }

    public Command decodeCommand(String command){
        return gson.fromJson(command, Command.class);
    }
}
