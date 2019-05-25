package com.learn.thinking.generic.issue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

public class NeedCasting {

    @SuppressWarnings("unchecked")
    private void castWithWarning(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream
                = new ObjectInputStream(new FileInputStream(fileName));
        //NeedCasting.Java uses unchecked or unsafe operations.
        List<Date> dateList = (List<Date>)inputStream.readObject();
    }

    @SuppressWarnings("unchecked")
    private void castWithoutWaring(String fileName) throws IOException, ClassNotFoundException{
        ObjectInputStream inputStream
                = new ObjectInputStream(new FileInputStream(fileName));
        List<Date> dates = List.class.cast(inputStream.readObject());
    }



}
