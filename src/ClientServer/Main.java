package ClientServer;

public class Main {
    public static void main(String [] args)
    {
        Server t = new Server("thread1");
        new Thread(t).start();
        
    }
}
