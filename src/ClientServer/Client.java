package ClientServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{
    String threadName;
    public Client(String Name){
        threadName=Name;
    }

    @Override
    public void run() {
        connect();

    }
    public void connect() {
        Socket MyClient;
        try {
            /**makes a connection to the server**/
            MyClient = new Socket("localhost",4000);
            System.out.println("connected to server");
            PrintWriter pr = new PrintWriter(MyClient.getOutputStream());
            pr.println(threadName);
            pr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("somethin happend");

    }
    public static void main(String [] args){
        Client client = new Client("1");
        Client client2 = new Client("2");
        new Thread(client).start();
        new Thread(client).start();
        new Thread(client2).start();
    }
}
