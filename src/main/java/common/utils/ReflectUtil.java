/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author chichen  Date: 16-4-20 Time: 下午4:03
 */
public class ReflectUtil {

    public ReflectUtil() {
    }

    private static void makeAccessible(Field field) {
        if(!Modifier.isPublic(field.getModifiers())) {
            field.setAccessible(true);
        }

    }

    private static Field getDeclaredField(Object object, String filedName) {
        Class superClass = object.getClass();

        while(superClass != Object.class) {
            try {
                return superClass.getDeclaredField(filedName);
            } catch (NoSuchFieldException var4) {
                superClass = superClass.getSuperclass();
            }
        }

        return null;
    }

    public static void setFieldValue(Object object, String fieldName, Object value) {
        Field field = getDeclaredField(object, fieldName);
        if(field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        } else {
            makeAccessible(field);

            try {
                field.set(object, value);
            } catch (IllegalAccessException var5) {
                var5.printStackTrace();
            }

        }
    }

    public static Object getFieldValue(Object object, String fieldName) {
        Field field = getDeclaredField(object, fieldName);
        if(field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
        } else {
            makeAccessible(field);
            Object result = null;

            try {
                result = field.get(object);
            } catch (IllegalAccessException var5) {
                var5.printStackTrace();
            }

            return result;
        }
    }
}
