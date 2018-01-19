package client;

import theseclasses.IStringProcessor;
import theseclasses.RequestData;
import theseclasses.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class StringProcessorProxy_NoCommands implements IStringProcessor {

    private ClientCommunicator clientCommunicator = new ClientCommunicator();
    private String host = "10.37.17.222";
    private RequestData requestData = new RequestData();

    public Results toLowerCase(String s){
        requestData.setData(s);
        String urlPath = "http://" + host + ":8080/lower";
        return clientCommunicator.send(urlPath, requestData);
    }


    public Results trim(String s){
        requestData.setData(s);
        String urlPath = "http://" + host + ":8080/trim";
        return clientCommunicator.send(urlPath, requestData);
    }


    public Results parseInteger(String s){
        requestData.setData(s);
        String urlPath = "http://" + host + ":8080/parse";
        return clientCommunicator.send(urlPath, requestData);
    }

}
