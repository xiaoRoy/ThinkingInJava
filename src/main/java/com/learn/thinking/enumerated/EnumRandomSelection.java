package com.learn.thinking.enumerated;



import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class EnumRandomSelection {

    private static Random sRandom = new Random();

    @Nullable
    public static <T extends Enum<T>> T random(Class<T> enumClass) {
        T[] enumValues = enumClass.getEnumConstants();
        T result = null;
        if(enumValues != null && enumValues.length > 0) {
            result = random(enumValues);
        }
        return result;
    }

    @Nonnull
    public static <T> T random(@Nonnull T[] values) {
        int length = values.length;
        return values[sRandom.nextInt(length)];
    }
}
