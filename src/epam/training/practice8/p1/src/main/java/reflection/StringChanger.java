package reflection;

import java.lang.reflect.Field;

public class StringChanger {
    private Field valueField;

    public StringChanger(){
        try {
            valueField = String.class.getDeclaredField("value");
            valueField.setAccessible(true);
        } catch (NoSuchFieldException ignored){}
    }

    public String change(String s, char[] newValue){
        try {
            valueField.set(s, newValue);
        } catch (IllegalAccessException ignored) {}
        return s;
    }

}
