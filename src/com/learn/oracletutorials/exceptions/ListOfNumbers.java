package com.learn.oracletutorials.exceptions;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {

    private static final int SIZE = 10;

    private List<Integer> numberList;

    public ListOfNumbers() {
        numberList = new ArrayList<>(SIZE);
        for (int index = 0; index < SIZE; index++) {
            numberList.add(index);
        }
    }

    public void writeList() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter("out_file.txt"));
            for (int index = 0; index < SIZE; index++) {
                printWriter.write("Value at: " + index + " = " + numberList.get(index));
            }
        } catch (IndexOutOfBoundsException exception) {
            System.err.println("IndexOutOfBoundsException: " + exception.getMessage());
        } catch (IOException exception) {
            System.err.println("Caught IOException: " + exception.getMessage());
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public void writeListTryWithResource() {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter("out_file.txt"))){
            for (int index = 0; index < SIZE; index++) {
                printWriter.write("Value at: " + index + " = " + numberList.get(index));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void writeListThrowsException() throws IOException{
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter("out_file.txt"));
            for (int index = 0; index < SIZE; index++) {
                printWriter.write("Value at: " + index + " = " + numberList.get(index));
            }
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public void testIndexOutOfBoundException(int index){
        if(index <= 0){
            /*
            * We definitely can catch this exception. Even we catch them,
            * but we don't know how to handle it. So we just throw it let
            * the one who called the method to handle it.
            * */
            throw new IndexOutOfBoundsException();
        }
    }

    public int testFinally(){
        try {
            return 11;
        }finally {
            System.out.println("Finally Block");
        }
    }

    public static void main(String[] args) {
        new ListOfNumbers().testFinally();
    }
}
