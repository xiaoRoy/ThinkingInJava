package com.learn.thinking.enumerated;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EnumAnalysis {

    enum Explore {
        HERE, THERE
    }

    @Nonnull
    public static Set<String> analyze(@Nonnull Class<?> enumClass) {
        System.out.println("Interfaces:");
        for(Type type : enumClass.getGenericInterfaces()) {
            System.out.println(type);
        }

        System.out.println("Base:" + enumClass.getSuperclass());

        System.out.println("Methods:");
        Set<String> methods = new TreeSet<>();
        for(Method method: enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }
}
