package com.learn.thinking.generic.issue;

public interface Payable<T> {

    static class Employee implements Payable<Employee> {

    }

//    static class Hourly extends Employee implements Payable<Hourly> { }
}
