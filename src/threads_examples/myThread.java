package threads_examples;

public class myThread extends  Thread{
    String input;
    //the thread receives a string/name
    private myThread (String input) {this.input = input;}
    //this function runs every time when a thread is created
    public void run()
    {
        for(int i=0; i<10; i++){
            System.err.println(i+":\t"+input);
            try{
                //sleep for a random number from
                sleep((int)(Math.random()*500));
            }catch (InterruptedException e){}
        }
    }
    public static void main(String [] args){
        //creation of a thread two object type my thread
        Thread t = new myThread("Distributed");
        Thread t2 = new myThread("Systems");
        // is you run it you will see an asynchronous call of the two threads
        t.start();
        t2.start();
    }
}
