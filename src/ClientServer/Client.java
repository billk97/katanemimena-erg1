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
            while (true)
            {
                Thread.sleep(1000);
                /**makes a connection to the server**/
                MyClient = new Socket("192.168.1.65",4200);
                System.out.println("connected to server");
                PrintWriter pr = new PrintWriter(MyClient.getOutputStream());
                pr.println(threadName);
                pr.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("somethin happend");

    }
    public static void main(String [] args){
       // Server server = new Server("server1");
       // new Thread(server).start();
        Client client = new Client("1");
        new Thread(client).start();
        Client client2 = new Client("2");
        new Thread(client2).start();
    }
}
