package com.learn.playground.sort;

import sun.jvm.hotspot.types.basic.BasicOopField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuestProfile implements Comparable<GuestProfile>{

    private static final int GUEST_CATEGORY_ONLY_LAST = 1;
    private static final int GUEST_CATEGORY_NORMAL = 2;
    private static final int GUEST_CATEGORY_EMPTY = 3;

    private String firstName;
    private String lastName;

    public GuestProfile() {
    }

    public GuestProfile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.firstName = this.firstName.toLowerCase();
//        this.lastName = this.lastName.toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(GuestProfile another) {
        char index = getIndex(this.firstName, this.lastName);
        char anotherIndex = getIndex(another.getFirstName(), another.getLastName());
        boolean isAlphabetic = isAlphabetic(index);
        boolean isAnotherAlphabetic = isAlphabetic(anotherIndex);
        int result;
        if(isAlphabetic && isAnotherAlphabetic){
            if(index == anotherIndex){
                result = compare(another);
            } else {
                String comparison = isEmpty(this.lastName) ? this.firstName : this.lastName;
                String anotherComparison = isEmpty(another.getLastName()) ? another.getFirstName() : another.getLastName();
                result = comparison.compareToIgnoreCase(anotherComparison);
            }
        } else if(isAlphabetic){
            result = -1;
        } else if(isAnotherAlphabetic){
            result = 1;
        } else {
            if(index == anotherIndex){
                result = compare(another);
            } else {
                String comparison = isEmpty(this.lastName) ? this.firstName : this.lastName;
                String anotherComparison = isEmpty(another.getLastName()) ? another.getFirstName() : another.getLastName();
                result = comparison.compareToIgnoreCase(anotherComparison);
            }
        }
        return result;
    }

    private int compare(GuestProfile another){
       int category = getCategory(this.firstName, this.lastName);
       int anotherCategory =getCategory(another.getFirstName(), another.getLastName());
       int result;
       if (category == anotherCategory){
           String comparison = isEmpty(this.lastName) ? this.firstName : this.lastName;
           String anotherComparison = isEmpty(another.getLastName()) ? another.getFirstName() : another.getLastName();
           result = comparison.compareToIgnoreCase(anotherComparison);
       } else {
           result = category - anotherCategory;
       }
       return result;
    }

    private static int getCategory(String firstName, String lastName){
        boolean isFirstNameEmpty = isEmpty(firstName);
        boolean isLastNameEmpty = isEmpty(lastName);
        int result;
        if(isFirstNameEmpty && isLastNameEmpty) {
            result = GUEST_CATEGORY_EMPTY;
        } else if(isFirstNameEmpty){
            result = GUEST_CATEGORY_ONLY_LAST;
        } else {
            result = GUEST_CATEGORY_NORMAL;
        }
        return result;
    }

    private static char getIndex(String firstName, String lastName){
        char index;
        if(!isEmpty(lastName)){
            index = lastName.charAt(0);
        } else if(!isEmpty(firstName)){
            index = firstName.charAt(0);
        } else {
            index = 0;
        }
        return index;
    }

    private static boolean isAlphabetic(char index){
       return (index >= 97 && index <= 122) || (index >= 65 && index <= 90);
    }

    private static boolean isEmpty(String text){
        return text == null || text.isEmpty();
    }

    @Override
    public String toString() {
        String firstName = this.firstName;
        if(isEmpty(firstName)){
            firstName = "firstEmpty";
        }
        String lastName = this.lastName;
        if(isEmpty(lastName)){
            lastName = "lastEmpty";
        }
        return String.format("%1$s %2$s", firstName, lastName);
    }

    public static void main(String[] args) {
      /*  System.out.println("trail.codePint.a:" + "a".codePointAt(0));
        System.out.println("trail.codePint.z:" + "z".codePointAt(0));
        System.out.println("trail.codePint.A:" + "A".codePointAt(0));
        System.out.println("trail.codePint.Z:" + "Z".codePointAt(0));
        System.out.println("trail.codePint.1:" + "1".codePointAt(0));
        System.out.println("a".compareTo("b"));*/
        List<GuestProfile> guestProfiles = new ArrayList<>();
        guestProfiles.add(new GuestProfile("", "zz"));
        guestProfiles.add(new GuestProfile("AA", "Hh"));
        guestProfiles.add(new GuestProfile("CC", "BB"));
        guestProfiles.add(new GuestProfile("tt", "aa"));
        guestProfiles.add(new GuestProfile("uu", "AAAA"));
//        guestProfiles.add(new GuestProfile());
        guestProfiles.add(new GuestProfile("kk", "oo"));
        guestProfiles.add(new GuestProfile("abc", "zxy"));
        guestProfiles.add(new GuestProfile("", "abc"));
        guestProfiles.add(new GuestProfile("jjjj", ""));
        guestProfiles.add(new GuestProfile("bbb", ""));
        guestProfiles.add(new GuestProfile("", "mm"));
        guestProfiles.add(new GuestProfile("aa", "mm"));
        guestProfiles.add(new GuestProfile("zx", ""));
        guestProfiles.add(new GuestProfile("", "tt"));
        guestProfiles.add(new GuestProfile("", "--tt"));
        guestProfiles.add(new GuestProfile("", "a--tt"));
        Collections.sort(guestProfiles);
        for(GuestProfile guestProfile : guestProfiles){
            System.out.println(guestProfile);
        }
    }
}
