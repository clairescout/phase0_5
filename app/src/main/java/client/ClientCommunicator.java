package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


import models.Results;

/**
 * Created by clairescout on 1/13/18.
 */

public class ClientCommunicator {

    private Serializer serializer = new Serializer();

    public Results send(String urlPath, Object object){
        Results r = new Results();

        try{
            URL url = new URL(urlPath);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");

            http.setDoOutput(true);
            http.connect();
            String reqData = serializer.encode(object);
            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();
            if(http.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                r = serializer.decodeResults(respData);
            }
            else{
                r.setMessage("Http response message is not okay");
            }

        }
        catch(IOException e){
            r.setMessage("Error In Client Communicator");
        }
        return r;
    }


    private static String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }


    private static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }
}
