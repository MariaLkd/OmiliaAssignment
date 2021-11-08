package com.myprj.omiliaassignment;

public class InterpretationMethods {

    // removes spaces from user input check natural number validity
    public static String naturalNumberInterpretation(String userInput) {
        String userInputNoSpaces = removeSpaces(userInput);
        if (checkIfLong(userInputNoSpaces)) {
            return userInputNoSpaces;
        } else {
            return ("Not a valid number");
        }
    }

    public static String removeSpaces(String str){
        return str.replaceAll(" ","");
    }

    // checks if String is parsable to long
    public static boolean checkIfLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

}
