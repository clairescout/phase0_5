package handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import otherServerThings.ServerSerializer;
import theseclasses.RequestData;

/**
 * Created by clairescout on 1/15/18.
 */

public class HandlerBase implements HttpHandler {

    private HttpExchange exchange;

    public void handle(HttpExchange exchange) throws IOException{
        this.exchange = exchange;

    }

    public String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }

    public void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }

    public String getStringFromUrl(HttpExchange exchange){
        java.net.URI uri = exchange.getRequestURI();
        String filePathString = uri.getPath();
        String[] paths = filePathString.split("/");
        System.out.println("Paths 1: " + paths[1]);
        System.out.println("Paths 2: " + paths[2]);
        return paths[2];
    }

    public RequestData getRequestData(HttpExchange exchange) throws IOException{
        ServerSerializer serverSerializer = new ServerSerializer();
        InputStream reqBody = exchange.getRequestBody();
        String reqData = readString(reqBody);
        return serverSerializer.decodeRequestData(reqData);
    }

}
