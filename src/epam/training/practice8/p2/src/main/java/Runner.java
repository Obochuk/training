import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Runner {

    private static final String FIELD_NAME = "value";
    private static final String SETTER_NAME = "setValue";

    public static void run(){
        try {
            Constructor<UnaryArithmeticOperation> constructor = UnaryArithmeticOperation.class.getConstructor(double.class);
            UnaryArithmeticOperation operation = constructor.newInstance(8.5);

            Field valueField = UnaryArithmeticOperation.class.getDeclaredField(FIELD_NAME);
            valueField.setAccessible(true);
            System.out.println("Start value of object: " + valueField.get(operation));

            Method setMethod = UnaryArithmeticOperation.class.getMethod(SETTER_NAME, double.class);
            setMethod.invoke(operation, 110.2);


            System.out.println("New value of object: " + operation.getValue());
        } catch (Exception ignored){}
    }

}
