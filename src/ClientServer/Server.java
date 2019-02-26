package ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Server implements Runnable{
    String ThreadName;
    /**creation of an constructor
     * (quick  reminder )
     * a constructor declaration looks like a method declaration except
     * that the use the name of the class and have no return value
     * this is an empty constructor**/
    private Server(){}
    /**this is a constructor  that that takes a String argument
     * ass you can see you can have 2 constructors or more**/
    public Server(String Name){
        ThreadName=Name;
    }
    /**if you implement Runnable you need to have a run function**/
    public void run(){
        connect();
    }

    private void connect()
    {
        System.out.println("Server Is Up");
        ServerSocket serverSocket =null;
        Socket socket1 ;
        try {
            serverSocket = new ServerSocket(4000);
            while (true)
            {
                socket1 = serverSocket.accept();
                System.out.println("Client Connected");
                InputStreamReader input = new InputStreamReader(socket1.getInputStream());
                BufferedReader buffer= new BufferedReader(input);
                String mesage = buffer.readLine();
                System.out.println("Client ---> "+ mesage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
