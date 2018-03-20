import java.util.LinkedList;
import java.util.List;

public final class PhoneManufacture extends Enum<PhoneManufacture> {
    private static List<PhoneManufacture> values = new LinkedList<>();

    public static final PhoneManufacture SAMSUNG = new PhoneManufacture("SAMSUNG", 0);
    public static final PhoneManufacture APPLE = new PhoneManufacture("APPLE", 1);
    public static final PhoneManufacture XIAOMI = new PhoneManufacture("XIAOMI", 2);

    private int a = 5;

    private PhoneManufacture(String name, int ordinal){
        super(name, ordinal);
        values.add(this);
    }

    public static PhoneManufacture[] values(){
        PhoneManufacture[] manufactures = new PhoneManufacture[values.size()];
        return  values.toArray(manufactures);
    }
}
