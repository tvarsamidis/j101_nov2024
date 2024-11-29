package gr.codehub.j101.p04thread.s02;

public class Threader1 extends Thread {
    int no = 0;

    public Threader1(int no) {
        this.no = no;
    }

    public void run() {
        for (int i = 0; i < 1000; i++)
            System.out.println("Hello from thread " + no + " at " + i);
        System.out.println("THREAD " + no + " FINISHED ======================================");
    }

    public static void main(String[] args) {
        Threader1 t1 = new Threader1(1);
        Threader1 t2 = new Threader1(2);
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                System.out.println("Hello from thread 3 at " + i);
        });

        t3.run();
        t1.start();
        t2.start();
        System.out.println("The main program has finished");
    }
}