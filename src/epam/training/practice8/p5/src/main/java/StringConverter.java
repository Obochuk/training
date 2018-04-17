@FunctionalInterface
public interface StringConverter {

    String convert(String value);

    default boolean isPresent(String s){
        if (s == null)
            return false;
        return s.isEmpty();
    }

}
