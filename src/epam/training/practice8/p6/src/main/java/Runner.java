import entity.Gender;
import entity.Person;
import entity.Reservist;
import generator.PersonGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    private final static String SEPARATOR = "------------------------------------------------------------";

    private final static int PERSON_AMOUNT = 8;

    public static void run() {
        task1();

        System.out.println(SEPARATOR);

        task34();

    }

    public static void task1() {
        List<Integer> streamResult = Stream.iterate(10, i -> i + 10)
                .limit(10)
                .map(i -> i >> 1)
                .collect(Collectors.toList());

        System.out.println("task1. " + streamResult);
    }

    public static void task34() {
        List<Person> generatedPersons = PersonGenerator.generatePersons(PERSON_AMOUNT);
        System.out.println("task3. Generated collection of persons: " + generatedPersons);
        List<Person> reservists = generatedPersons.stream()
                .filter(person -> person.getGender() == Reservist.GENDER &&
                        person.getAge() >= Reservist.MIN_AGE &&
                        person.getAge() < Reservist.MAX_AGE).collect(Collectors.toList());

        System.out.println("Reservists: " + reservists);

        System.out.println(SEPARATOR);

        System.out.println("task4. Mean female age: ");
        List<Person> females = generatedPersons.stream()
                .filter(person -> person.getGender() == Gender.FEMALE)
                .collect(Collectors.toList());
        int ageSum = females.stream()
                .mapToInt(Person::getAge)
                .sum();
        double meanAge = ageSum / (double) females.size();
        System.out.print(meanAge);
    }


}
