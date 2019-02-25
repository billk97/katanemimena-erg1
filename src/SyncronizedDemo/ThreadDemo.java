package SyncronizedDemo;

public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
     //creates an object type thread
    PrintDemo PD;
    ThreadDemo(String name ,PrintDemo pd){
        threadName=name;
        PD=pd;

    }
    public void run(){
        PD.printCount();
        System.out.println("Thread "+ threadName+" exiting");
    }
}
