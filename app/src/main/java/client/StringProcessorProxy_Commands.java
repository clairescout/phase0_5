package client;

import theseclasses.Command;
import theseclasses.IStringProcessor;
import theseclasses.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class StringProcessorProxy_Commands implements IStringProcessor {

    private ClientCommunicator clientCommunicator = new ClientCommunicator();
    private String host = "10.37.17.222";

    public Results toLowerCase(String s){

        String urlPath = "http://" + host + ":8080/command";
        Command command = new Command("StringProcessor", "toLowerCase",
                new Class<?>[]{String.class} ,
                new String[] {s});
        return clientCommunicator.send(urlPath, command);
    }

    public Results trim(String s){
        return new Results();
    }

    public Results parseInteger(String s){
        return new Results();
    }
}
