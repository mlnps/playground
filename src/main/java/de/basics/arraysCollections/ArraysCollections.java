package de.basics.arraysCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysCollections {

    public static void main(String[] args) {
        //Array
        int[] arr1 = new int[4]; //size = 4 (arr.length gibt size zurück)
        arr1[0] = 1;    //die restlichen automatisch 0 (nicht null, da primititiv!)
        arr1[3] = 5;

        int[] arr2 = { 1, 2 };
        String[] arr3 = { "A", "B", "C", "D" };

        //Array printen
        //ganz ganz alt:
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i] + " ganz ganz alt");
        }

        //ganz alt:
        for (int i : arr1) {
            System.out.println(i + " ganz alt");
        }

        //Arrays als Stream benutzen: Arrays.stream(array) bzw. Stream.of(array)
        //Object Array
        String[] array = {"t", "e", "c", "h", "i", "o"};

        //Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(x -> System.out.println(x));

        //Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.println(x));

        //Premitive Array arr1
        //Arrays.stream
        IntStream intStream1 = Arrays.stream(arr1);
        intStream1.forEach(x -> System.out.println(x));

        //Stream.of
        Stream<int[]> tempStream = Stream.of(arr1);
        IntStream intStream2 = tempStream.flatMapToInt(x -> Arrays.stream(x));
        intStream2.forEach(x -> System.out.println(x));

        System.out.println("-----------");

        // noch schöner durch Methodenreferenz:
        Arrays.stream(arr1).forEach(System.out::println);

        System.out.println("-----------");

        //Collections (List, Set, Map)
        List<Integer> list1 = new ArrayList<>(); //möglich in Klammern initiale Größe anzugeben, aber nicht nötig
        list1.add(1);      //hängt diesen Value hinten dran


        //aus Collection (ArrayList) Array machen:
        Integer list2[] = new Integer[list1.size()];
        list2 = list1.toArray(list2);
        // int[] arrayListToArray = list.toArray(2);  geht nicht; keine primitiven Datentypen wohl

        List<Integer> list3 = Arrays.asList(1, 2);
        List<Integer> list4 = List.of(1, 2); //nicht modifizierbar
        var list = new ArrayList<>(List.of("A", "b", "c")); //modifizierbar

        //keine Duplikate --> Set (HashSet, LinkedSet, TreeSet)
        Set<String> setA = new HashSet();
        //Set befüllen
        setA.add("A");
        setA.add("B");
        setA.add("C");

        //Durch Collections iterieren:
        //1. mit Iterator  (Iterator is an interface available in Collection framework)
        Iterator<String> iterator = setA.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " iterator");
        }

        //2. mit ForEach Schleife (Set Interface implementiert das Iterable Interface, daher for each Loop möglich)
        for (String element : setA) {
            System.out.println(element + " for Schleife");
        }

        //3. via Java Stream API
        Stream<String> setStream = setA.stream();

        setStream.forEach(element -> System.out.println(element + " stream of set"));
        //oder beide Zeilen zusammenfassen
        //mit Methodenreferenz, wenn nur Elemente printen

        System.out.println("-----------");

        System.out.println("stream, peek, collect:");
        setA.stream().peek(System.out::print).collect(Collectors.toSet());

        System.out.println();
        System.out.println("-----------");

        System.out.println(list1);
        System.out.println(list3 + " Arrays.asList");
        System.out.println(list4 + " List.of");
        System.out.println(setA + " print Set");
        System.out.println(list2[0] + " toArray");

    }
}
