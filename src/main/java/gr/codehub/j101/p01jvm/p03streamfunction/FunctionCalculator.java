package gr.codehub.j101.p01jvm.p03streamfunction;

import java.util.function.Function;

public class FunctionCalculator {
    public static void main(String[] args) {
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> subtractThree = x -> x - 3;
        Function<Integer, Integer> raiseAbove100 =
                x -> {
                    while (x < 100) {
                        x += 10;
                    }
                    return x;
                };
        int result = addOne
                .andThen(multiplyByTwo)
                .andThen(subtractThree)
                .andThen(raiseAbove100)
                .apply(5);
        System.out.println(result);
    }
}
