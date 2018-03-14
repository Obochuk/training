package epam.training.practice3;

import java.lang.reflect.Field;
import java.util.List;

public abstract class Enum<E extends Enum<E>> implements Comparable<E> {
    private final String name;
    private final int ordinal;

    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }


    public final String getName() {
        return name;
    }

    public final int getOrdinal() {
        return ordinal;
    }

    public static <T extends Enum<T>> Enum valueOf(Class<T> type, String name){
        final String VALUES_FIELD = "values";
        try {
            Field valuesField = type.getDeclaredField(VALUES_FIELD);
            valuesField.setAccessible(true);
            List<Enum> values = (List<Enum>) valuesField.get(null);
            return searchEnumValue(name, values);
        } catch (IllegalAccessException | ClassCastException | NoSuchFieldException e){
            throw new UnsupportedOperationException("Desired enum type doesn`t support this operation!");
        }
    }

    private static Enum searchEnumValue(String name, List<Enum> enumValues){
        for (Enum value : enumValues) {
            if (value.getName().equals(name)){
                return value;
            }
        }
        throw new IllegalArgumentException("No such enum constant " + name);
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Enum is not clonable");
    }

    @Override
    public int compareTo(E o) {
        Enum<?> arg = o;
        if (arg.getClass() != this.getClass())
            throw new ClassCastException("Cannot compare to another type, this.class=" + this.getClass() +
                    ", supplied class=" + arg.getClass());
        return arg.ordinal - this.ordinal;
    }
}
