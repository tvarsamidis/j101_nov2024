package gr.codehub.j101.p04thread.s01;

public class SimpleThreadsJoin {

    public static int balance;

    public static void main(String[] args)  {
        System.out.println("the application has started");
        Thread t1 = new Thread(){
            public void run(){
                loop(1);
            }
        };
        t1.start();

        // Lambda implementation
        Thread t2 = new Thread(() -> loop(2));
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        for (int i = 0 ; i < 100; i++)
            System.out.println("the application has finished");
        try {
            t1.wait(); // This will cause an exception
            t2.wait(); // This will cause an exception
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(balance);
    }

    private static void loop(int id) {
        for (int i = 0; i < 100; i++) {
            System.out.println("This is loop " + id + ", round " + i);
            balance += id;
        }
    }

}
