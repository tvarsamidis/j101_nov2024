package gr.codehub.j101.p01jvm.p03streamfunction;

import java.util.List;

public class TitlerExample {
    public static void main(String[] args) {
        Titler withStars = (x) -> System.out.println("******* " + x + " ********");
        Titler withExclamation = (x) -> System.out.println("!!!!! " + x + " !!!!!!");
        Titler withDefault = (x) -> System.out.println(x);

        Titler t = Math.random() >= 0.5 ? withStars : withExclamation;

        List<String> movies = List.of("Hello world", "Nice day", "Time to relax", "Noooooooo!");
        movies.stream()
                .filter(x -> x.startsWith("N"))
                .forEach(t::showTitle);
    }
}
