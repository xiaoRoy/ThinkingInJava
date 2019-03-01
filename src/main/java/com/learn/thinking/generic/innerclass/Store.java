package com.learn.thinking.generic.innerclass;

import com.learn.thinking.generic.gernericinterface.Generator;
import com.learn.thinking.generic.gernericinterface.Generators;

import java.util.ArrayList;
import java.util.Random;

public class Store extends ArrayList<Store.Aisle>{

    public Store(int numberOfAisle, int numberOfShelfPerAisle, int numberOfProductPerShelf) {
        for (int index = 0; index < numberOfAisle; index++) {
            add(new Aisle(numberOfShelfPerAisle, numberOfProductPerShelf));
        }
    }

    private static class Product {

        private final int id;
        private String description;
        private double price;

        public static Generator<Product> generator = new Generator<Product>() {

            private Random random = new Random();

            @Override
            public Product next() {
                return new Product(random.nextInt(1000), "Test",
                        Math.round(random.nextDouble() * 1000.0) + 0.99);
            }
        };

        public Product(int id, String description, double price) {
            this.id = id;
            this.description = description;
            this.price = price;
        }

        public void changePrice(double change) {
            price += change;
        }

        @Override
        public String toString() {
            return id + ": " + description + ", price: $" + price;
        }
    }

    private static class Shelf extends ArrayList<Product> {

        public Shelf(int numberOfProduct) {
            Generators.fill(this, Product.generator, numberOfProduct);
        }
    }

    static class Aisle extends ArrayList<Shelf> {
        public Aisle(int numberOfShelf, int numberOfProductPerShelf) {
            for (int index = 0; index < numberOfShelf; index++) {
                add(new Shelf(numberOfProductPerShelf));
            }

        }
    }
}
