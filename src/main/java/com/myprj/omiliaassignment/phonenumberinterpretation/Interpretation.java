package com.myprj.omiliaassignment.phonenumberinterpretation;

public class Interpretation {

    // removes spaces from user input
    static String removeSpaces(String str){
        return str.replaceAll(" ","");
    }

    // checks if String is parsable to long
    static boolean checkIfLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

}
