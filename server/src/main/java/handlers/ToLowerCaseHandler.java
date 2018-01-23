package handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import otherServerThings.ServerSerializer;
import otherServerThings.StringProcessor;
import models.RequestData;
import models.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class ToLowerCaseHandler extends  HandlerBase {

    @Override
    public void handle(com.sun.net.httpserver.HttpExchange exchange) throws IOException{
        System.out.println("in tolowercase handler");
        ServerSerializer serverSerializer = new ServerSerializer();
        boolean success = false;
        try{
            if(exchange.getRequestMethod().toLowerCase().equals("post")){
                RequestData requestData = getRequestData(exchange);
                Results r = StringProcessor.getInstance().toLowerCase(requestData.getData());
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
}
