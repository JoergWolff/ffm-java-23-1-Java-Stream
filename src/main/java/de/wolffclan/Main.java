package de.wolffclan;

import de.wolffclan.student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        System.out.println("\n Bonus \b------------");

        try {
            Stream<String> lines = Files.lines(Path.of("students.csv"));
            List<Student> students = lines
                    .skip(1)
                    .filter(line -> !line.isEmpty())
                    .distinct()
                    .map(line -> line.split(","))
                    .map(line -> new Student(Integer.parseInt(line[0]), line[1], line[2], Integer.parseInt(line[3])))
                    .toList();
            lines.close();
            ;
            System.out.println(students);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}