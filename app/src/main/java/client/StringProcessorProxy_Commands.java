package client;

import models.CommandData;
import models.IStringProcessor;
import models.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class StringProcessorProxy_Commands implements IStringProcessor {

    private ClientCommunicator clientCommunicator = new ClientCommunicator();
    private String host = "10.24.69.119";
    private String urlPath = "http://" + host + ":8080/command";

    public Results toLowerCase(String s){
        CommandData commandData = new CommandData("toLowerCase", s);
        return clientCommunicator.send(urlPath, commandData);
    }

    public Results trim(String s){

        CommandData commandData = new CommandData("trim", s);
        return clientCommunicator.send(urlPath, commandData);
    }

    public Results parseInteger(String s){

        CommandData commandData = new CommandData("parseInteger", s);
        return clientCommunicator.send(urlPath, commandData);
    }
}
