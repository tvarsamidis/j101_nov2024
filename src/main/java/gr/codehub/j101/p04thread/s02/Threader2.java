package gr.codehub.j101.p04thread.s02;

public class Threader2 extends Thread {

    int no = 0;

    public Threader2(int no) {
        this.no = no;
    }

    public void run() {
        int wait = (int)(Math.random() * 1000);
        for (int i = 0; i < 300000; i++) {
            //System.out.println("Hello from thread " + no + " at " + i);
        }
        System.gc();
        System.out.println("THREAD " + no + " FINISHED ======================================");
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4000; i++) {
            new Threader2(i).start();
        }
        System.out.println("Main finished!");
    }

}