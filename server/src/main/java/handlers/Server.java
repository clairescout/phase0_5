package handlers;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import otherServerThings.ServerSerializer;

/**
 * Created by clairescout on 1/15/18.
 */

public class Server {

    private static final int MAX_WAITING_CONNECTIONS = 12;
    private HttpServer server;
   // private ServerSerializer serverSerializer = new ServerSerializer();

    private void run(String portNumber) {
        System.out.println("Initializing HTTP Server"); //will comment out eventually

        try{
            server = HttpServer.create(
                    new InetSocketAddress(Integer.parseInt(portNumber)),
                    MAX_WAITING_CONNECTIONS);
        }
        catch(IOException e){
            e.printStackTrace();
            return;
        }

        server.setExecutor(null);
        System.out.println("Creating contexts");
        server.createContext("/command", new ExecCommandHandler());
        server.createContext("/parse", new ParseIntegerHandler());
        server.createContext("/trim", new TrimHandler());
        server.createContext("/lower", new ToLowerCaseHandler());


        System.out.println("Starting server");
        server.start();
        System.out.println("Server started");
    }

    public static void main(String[] args) {
        String portNumber = "8080";// args[0]; //"8080"; //
        new Server().run(portNumber);
    }
}
