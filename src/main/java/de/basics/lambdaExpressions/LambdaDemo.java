package de.basics.lambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {

    static Consumer<String> c = new Consumer<String>() {    //alles über Lambda viel kürzer: s -> System.out.println(s);
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    };

    public static void main(String[] args) {
        var list = new ArrayList<>(List.of("A", "b", "c"));   //ohne new ArrayList, also nur mit List.of ist die Liste nicht modifizierbar!


        // ganz alt
        for (var s : list) {
            System.out.println(s);
        }

        // vor java 8, auch alt
        list.forEach(c);

        list.forEach(s -> System.out.println(s));
        list.forEach(s -> System.out.println(s + "!"));
        list.forEach(s -> {
            System.out.println(s);
            System.out.println(s + " ein 2. mal");
        });

        list.sort((s, t1) -> s.compareTo(t1));
/*        list.sort(String::compareTo);
        list.sort(Comparator.naturalOrder());*/

        // Methodenreferenz
        list.forEach(System.out::println);

        //bestimmtes Element aus Liste entfernen
        String toRemove = "A";
        list.removeIf(s -> toRemove.equals(s));
        list.removeIf(toRemove::equals);

    }


}
