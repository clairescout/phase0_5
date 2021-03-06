package handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import otherServerThings.ServerSerializer;
import otherServerThings.Command;
import models.CommandData;
import models.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class ExecCommandHandler extends HandlerBase {

    private ServerSerializer serverSerializer = new ServerSerializer();

    @Override
    public void handle(com.sun.net.httpserver.HttpExchange exchange) throws IOException{
        System.out.println("in command handler");

        boolean success = true;
        try{
            if(exchange.getRequestMethod().toLowerCase().equals("post")){
                Command command = getCommand(exchange);
                Results r = command.execute();
                String respData = serverSerializer.encodeResults(r);
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                OutputStream respBody = exchange.getResponseBody();
                writeString(respData, respBody);
                respBody.close();
                success = true;
            }
            if(!success){
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                exchange.getResponseBody().close();
            }
        }
        catch(IOException e){
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_SERVER_ERROR, 0);
            exchange.getResponseBody().close();
            e.printStackTrace();
        }

    }


    public Command getCommand(com.sun.net.httpserver.HttpExchange exchange) throws IOException{
        InputStream reqBody = exchange.getRequestBody();
        String commandDataJson = readString(reqBody);
        CommandData commandData = serverSerializer.decodeCommandData(commandDataJson);
        return new Command("otherServerThings.StringProcessor", commandData.getMethodType(),
                new Class<?>[] {String.class},
                new String[] {commandData.getData()} );
    }


}
