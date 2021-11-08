package com.myprj.omiliaassignment;

import java.util.*;

public class UserInput {
    static Scanner sc = new Scanner(System.in);
    static CheckPhoneNumberRegion checkPhoneNumber = new CheckPhoneNumberRegion();
    static NumberAmbiguitiesPermutations numAmb = new NumberAmbiguitiesPermutations();

    public static void inputPhone() {
        while (true) {
            System.out.println("Please enter phone number: ");
            String number = sc.nextLine();
            checkPhoneNumber(number);
        }
    }

    // prints the interpretations of the phone number to the console and their validity as greek phone numbers
    private static void checkPhoneNumber(String number) {
        String trimmedInput = InterpretationMethods.removeSpaces(number);
        if (InterpretationMethods.checkIfLong(trimmedInput)) {
            LinkedHashMap<Integer, List<String>> possibleDigits = numAmb.digitsCombinationsList(number);
            List<String> possiblePhones = numAmb.phoneNumberPermutationsList(possibleDigits);
            for (int i = 0; i < possiblePhones.size(); i++) {
                String validGreekNumber = "";
                if(CheckPhoneNumberRegion.checkGreekPhoneNumber(possiblePhones.get(i))==true){validGreekNumber = "VALID";}
                else {validGreekNumber="INVALID";}
                System.out.println("Interpretation "+(i+1)+": "+possiblePhones.get(i)+"[phone number: "+validGreekNumber+"]");
            }
        } else {
            System.out.println("Not a valid phone number");
        }
    }
}
