package ClientServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class NewClient {
    String threadName;
    public NewClient(String Name){
        threadName=Name;
    }

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
                MyClient = new Socket("192.168.1.65",4202);
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
        Client client = new Client("3");
        new Thread(client).start();
    }
}
