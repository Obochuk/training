package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionAction {

    public static Object create(Class aClass, Object... params) throws
            NoSuchMethodException, InvocationTargetException, InstantiationException{
        Constructor constructor = getAccessibleConstructor(aClass, params);

        try {
            return constructor.newInstance(params);
        }catch (IllegalAccessException ignored){
            return null;
        }
    }

    private static Constructor getAccessibleConstructor(Class aClass, Object... params) throws NoSuchMethodException{
        Class[] paramsTypes = getClassesOf(params);
        Constructor constructor = aClass.getDeclaredConstructor(paramsTypes);
        constructor.setAccessible(true);
        return constructor;
    }

    public static Object get(Object from, String fieldName) throws NoSuchFieldException{
        Field field = getAccessibleField(from.getClass(), fieldName);
        try {
            return field.get(from);
        } catch (IllegalAccessException ignored){
            return null;
        }
    }

    public static void set(Object in, String fieldName, Object newValue) throws NoSuchFieldException{
        Field field = getAccessibleField(in.getClass(), fieldName);
        try {
            field.set(in, newValue);
        } catch (IllegalAccessException ignored){}
    }

    private static Field getAccessibleField(Class from, String fieldName) throws NoSuchFieldException{
        Field field = from.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field;
    }

    public static Object call(Object called, String methodName, Object... parameters) throws NoSuchMethodException, InvocationTargetException{
        Method method = getAccessibleMethod(called.getClass(), methodName, parameters);
        try {
            return method.invoke(called, parameters);
        } catch (IllegalAccessException ignored){
            return null;
        }
    }

    private static Method getAccessibleMethod(Class aClass, String methodName, Object... parameters) throws NoSuchMethodException{
        Class[] parameterTypes = getClassesOf(parameters);
        Method method = aClass.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method;
    }

    private static Class[] getClassesOf(Object... param){
        return Arrays.stream(param).map(p -> p.getClass()).toArray(Class[]::new);
    }
}
