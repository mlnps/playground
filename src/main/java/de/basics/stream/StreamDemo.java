package de.basics.stream;


import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamDemo {
    public static void main(String[] args) {

        var list = List.of("A", "B", "c");
        //
        //        for (var s : list) {
        //            if (s.equals("A")) {
        //                System.out.println(s);
        //            }
        //        }

        var mapOfList = Map.of(
                "A", List.of(1, 2, 4),
                "B", List.of(1, 2, 5)
        );

        List<String> resultList = list.stream()
                .map(mapOfList::get) //jetzt besteht Liste aus 1,2,4 und 1,2,5, "c" ist leer. (=> stream aus 3 int-listen)
                .filter(Objects::nonNull) //leere liste ("c") wird rausgeschmissen, sonst NullPointer
                /*.flatMap(l -> l.parallelStream())*/
                .distinct()   //doppelte rauswerfen
                .map(i -> i.toString())  //ohne diese Zeile Fehler, da Typ der Rückgabe String
                .peek(i -> System.out.println("zwischenstand: " + i))
                .collect(Collectors.toList());

        var result = Stream.of(1, 2, 3, 4, 5)
                .reduce("10", (s, i) -> s + " " + i, (s1, s2) -> s1 + "+" + s2);

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
        int l1result = l1.stream()
                .reduce(0, (subtotal, element) -> subtotal + element);  //identity = initial value and also default value, if stream is empty
        //lambda expression = accumulator --> function with two values: takes partial value and next value

        //Combine elements ofList of Strings to one String

        String stringResult = Stream.of("A", "B", "C")
                .reduce("", (s, n) -> s.toLowerCase() + n.toLowerCase());

        System.out.println(resultList);
        System.out.println(result);
        System.out.println(l1result);
        System.out.println(stringResult);

    }
}
