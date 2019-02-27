package SyncronizedDemo;

public class TestThread {
    public static void main(String[] args){
        PrintDemo PD =new PrintDemo();
        ThreadDemo T1 = new ThreadDemo("Thread--1-- ",PD);
        ThreadDemo T2 = new ThreadDemo("Thread--2-- " ,PD);
        T1.start();
        T2.start();
        /**The join() method of a Thread instance can be used to "join" the start of
         *  a thread's execution to the end of another thread's execution so tha a
         *  thread will not start running until another thread has ended.
         *  If join() is called on a Thread instance, the currently running thread
         *  will block until the Thread instance has finished executing.**/
        try {
            T1.join();
            T2.join();
        } catch (InterruptedException e) {
            System.out.println("Interaped");
            e.printStackTrace();
        }
        System.out.println("All thread are joined");
    }
}
