package generator;

import entity.Gender;
import entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonGenerator {
    private final static Random RANDOM = new Random();

    private final static int MAX_AGE = 80;
    private final static int MIN_AGE = 1;

    private final static List<String> MALE_NAMES = Arrays.asList("Vlad", "Sergio", "Volodymyr",
            "Oleksandr", "Ivan", "Igor");
    private final static List<String> FEMALE_NAMES = Arrays.asList("Katya", "Anya", "Vika",
            "Liza", "Yana", "Voletta", "Liudmyla");

    private final static List<String> SURNAMES = Arrays.asList("Smith", "Jones", "Taylor",
            "Williams", "Brown", "Davies", "Evans", "Wilson", "Thomas", "Roberts", "Johnson");

    public static List<Person> generatePersons(int amount){
        List<Person> generated = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            generated.add(generatePerson());
        }

        return generated;
    }

    public static Person generatePerson(){
        Gender gender = getRandom(Gender.values());

        String name = generateName(gender);
        String surname = getRandom(SURNAMES);
        String fullName = name + " " + surname;

        int age = MIN_AGE + RANDOM.nextInt(MAX_AGE);
        return new Person(fullName, age, gender);
    }

    private static String generateName(Gender gender){
        switch (gender){
            case MALE:
                return getRandom(MALE_NAMES);
            case FEMALE:
                return getRandom(FEMALE_NAMES);
            default:
                throw new IllegalArgumentException("This class doesn`t support this gender " + gender);
        }
    }

    private static <T> T getRandom(List<T> list){
        int amount = list.size();
        return list.get(RANDOM.nextInt(amount));
    }

    private static <T> T getRandom(T[] elements){
        int amount = elements.length;
        return elements[RANDOM.nextInt(amount)];
    }

}
