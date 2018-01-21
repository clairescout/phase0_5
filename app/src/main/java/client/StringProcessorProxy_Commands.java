package client;

import theseclasses.CommandData;
import theseclasses.IStringProcessor;
import theseclasses.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class StringProcessorProxy_Commands implements IStringProcessor {

    private ClientCommunicator clientCommunicator = new ClientCommunicator();
    private String host = "192.168.1.205";

    public Results toLowerCase(String s){

        String urlPath = "http://" + host + ":8080/command";
//        Command command = new Command("StringProcessor", "toLowerCase",
//                new Class<?>[]{String.class} ,
//                new String[] {s});
        CommandData commandData = new CommandData("toLowerCase", s);
        return clientCommunicator.send(urlPath, commandData);
    }

    public Results trim(String s){
        return new Results();
    }

    public Results parseInteger(String s){
        return new Results();
    }
}
