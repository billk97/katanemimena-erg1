package threads_examples;

import static java.lang.Thread.sleep;

//protimoteros tropos
//exe extend kai den mporeis na kanies 2 extens
public class MythreadRunable implements Runnable {
    String input;
    //the thread receives a string/name
    private MythreadRunable (String input) {this.input = input;}
    //this function runs every time when a thread is created
    public void run()
    {
        for(int i=0; i<10; i++){
            System.err.println(i+":\t"+input);
            try{
                //sleep for a random number from
                //or i can import the sleep method/package
                sleep((int)(Math.random()*500));
            }catch (InterruptedException e){}
        }
    }
    // no need to do this
    public void start() throws InterruptedException {
        System.out.println("This is the 1 time i call the method / its created ");
        sleep(100);
    }
    public static void main(String [] args){
        //creation of a thread two object type my thread
        MythreadRunable t = new MythreadRunable("Distributed");
        new Thread(t).start();
        MythreadRunable t2 = new MythreadRunable("Systems");
        new Thread(t2).start();
        // is you run it you will see an asynchronous call of the two threads
    }
}
