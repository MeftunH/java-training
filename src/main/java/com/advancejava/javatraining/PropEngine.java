package com.advancejava.javatraining;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class PropEngine<T> {
    //objeyi ben yaratip veriyorrum cunku compile ettiginde veriler gider diger turlu
    //objenin isminin bilmeden objeyi yarattim
    public T readProp(final Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        //Create Instance
        clazz.getConstructor().newInstance(
        );
        clazz.getAnnotation(PropFile.class);
        PropFile propFile = clazz.getAnnotation(PropFile.class);
        if (propFile == null) {
            throw new RuntimeException("PropFile annotation not found");
        }
        Field[] fields = clazz.getDeclaredFields();
        Properties properties = new Properties();
        properties.load(PropEngine.class.getClassLoader().getResourceAsStream(propFile.value()));
        for (Field field : fields) {
            Prop prop = field.getAnnotation(Prop.class);
            Class<T> type = (Class<T>) field.getType();
            if (type.isPrimitive()) {
                throw new RuntimeException("Primitive type not allowed");
            }
            if (String.class.equals(type)) {
                field.set(type.getConstructor().newInstance(), properties.getProperty(prop.key()));
            }
            if (prop != null) {
                String value = properties.getProperty(prop.key());
                field.setAccessible(true);
                field.set(clazz, value);

            }
            return (T) type;

        }
        return null;
    }

}
