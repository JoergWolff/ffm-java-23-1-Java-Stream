package de.wolffclan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Stream \n------------");

        List<Integer> ints = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            ints.add(i);
        }
        System.out.println(ints);
        System.out.println("Nur gerade Zahlen \n------------");
        ints.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        System.out.println("Zahlen verdoppeln \n------------");
        ints.stream()
                .map(number -> number*2)
                .forEach(System.out::println);

        System.out.println("Zahlen rückwärts \n------------");
        ints.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("Zahlen summieren \n------------");

        Optional<Integer> sumComplete = ints.stream()
                .reduce(Integer::sum);
        if(sumComplete.isPresent()){
            System.out.println("Summe" + sumComplete.get());
        }
        else{
            System.out.println("Kein Wert vorhanden");
        }

        System.out.println("Zahlen in neue Liste \b------------");

        List<Integer> newList = ints.stream()
                .toList();

        System.out.println(newList);

    }
}