package gr.codehub.j101.p01jvm.memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryError {
    public static void main(String[] args) {
        // stackErrors();
        heapErrors();
    }

    private static void stackErrors() {
        try {
            doSomething(0);
        } catch (Error e) { // Exception will not catch the error
            System.out.println("There was an error of: " + e);
            System.out.println("Saved it!");
        }
    }

    private static void doSomething(int depth) throws OutOfMemoryError {
        if (depth % 1000 == 0) {
            System.out.println("We are at stack depth " + depth);
        }
        doSomething(depth + 1);
    }

    private static void heapErrors() {
        try {
            int blockSize = 10_000_000;
            long blockCount = 0;
            List<byte[]> list = new ArrayList<>();
            while (true) {
                list.add(new byte[blockSize]);
                blockCount++;
                System.out.println("List size=" + String.format("%,d", blockCount * blockSize));
                System.out.printf("Available heap memory: %,d\n", Runtime.getRuntime().freeMemory());
            }
        } catch (Error e) { // Exception will not catch the memory error!
            System.out.println("There was an error of: " + e);
            System.out.println("Saved it!");
        }
    }

}
