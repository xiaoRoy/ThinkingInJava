package com.learn.playground.methodreference;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {


    private void methodReferenceToStaticMethod(){
        final Function<Integer, String> function = String::valueOf;
    }

    private void methodReferenceToInstanceMethodA(){
        final Comparator<String> comparator = String::compareToIgnoreCase;
    }

    private void methodReferenceToInstanceMethodB(){
        Printer printer = new Printer();
        final Consumer<String> consumer = printer::println;
    }

    public static class Printer{
        public void println(String text){
            System.out.println(text);
        }
    }


}

