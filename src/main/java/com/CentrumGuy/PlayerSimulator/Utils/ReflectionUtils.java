package com.CentrumGuy.PlayerSimulator.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static Object getFieldValue(Object object, String variableName) {
        try {
            Field field = object.getClass().getField(variableName);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setFieldValue(Object classObject, String variableName, Object value) {
        try {
            Field field = classObject.getClass().getField(variableName);
            field.setAccessible(true);
            field.set(classObject, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object callMethod(Object classObject, String methodName, Object... args) {
        try {
            Class<?>[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            Method method = classObject.getClass().getMethod(methodName, classes);
            method.setAccessible(true);
            return method.invoke(classObject, args);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
