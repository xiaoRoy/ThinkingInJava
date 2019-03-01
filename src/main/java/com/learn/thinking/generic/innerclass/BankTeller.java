package com.learn.thinking.generic.innerclass;

import com.learn.thinking.generic.gernericinterface.Generator;

public class BankTeller {

    public static class Customer {


        private static long counter = 1;

        private final long id = counter++;

        private Customer() {
        }

        @Override
        public String toString() {
            return "Customer " + id;
        }

        public static Generator<Customer> generator() {
            return new Generator<Customer>() {
                @Override
                public Customer next() {
                    return new Customer();
                }
            };
        }

    }

    public static class Teller {

        private static long counter = 1;

        private final long id = counter++;

        public static Generator<Teller> generator = new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };

        private Teller() {

        }

        @Override
        public String toString() {
            return "Teller " + id;
        }
    }
}
