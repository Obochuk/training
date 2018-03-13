package epam.training.practice3;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        PhoneManufacture apple = PhoneManufacture.APPLE;
        /*PhoneManufacture dontWork = new PhoneManufacture("BAD_BEHAVIOR", 100);*/
        /*switch (apple)*/          // of cause it will not work...
        /*apple.a*/                 // it is not accessible that perfect.
        Enum<PhoneManufacture> phnm = PhoneManufacture.APPLE;
        Enum<?> same = PhoneManufacture.APPLE;
        Enum worksFine = PhoneManufacture.APPLE;
        Enum anotherApple = PhoneManufacture.valueOf(PhoneManufacture.class, "APPLE");

        System.out.println(anotherApple);

        PhoneManufacture[] manufactures = PhoneManufacture.values();
        for (Enum manufacture : manufactures) {
            System.out.println(manufacture.getName() + " " + manufacture.getOrdinal());
        }
    }
}
