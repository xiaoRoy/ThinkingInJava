package com.learn.thinking.enumerated;

import javax.annotation.Nonnull;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAIN_COURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    public interface Food {
        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROLLS
        }

        enum MainCourse implements Food {
            LASAGNE, BURRITO, PAD_THAI,
            LENTILS, HUMMOUS, VINDALOO
        }

        enum Dessert implements Food {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE,
            FRUIT, CREME_CARMEL
        }

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
            LATTE, CAPPUCCINO, TEA, HERB_TEE
        }
    }

    private Food[] values;

    private Course(Class<? extends Food> foodClass) {
        values = foodClass.getEnumConstants();
    }

    @Nonnull
    public Food randomSelection() {
        if (values.length <= 0) throw new IllegalStateException();
        return EnumRandomSelection.random(values);
    }


}
