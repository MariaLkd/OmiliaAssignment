package com.myprj.omiliaassignment;

public class CheckPhoneNumberRegion {
    InterpretationMethods im = new InterpretationMethods();

    // checks if a phone number is Greek
    public static boolean checkGreekPhoneNumber(String phone) {
        if ((String.valueOf(phone).length() == 10 && (String.valueOf(phone).startsWith("2") || String.valueOf(phone).startsWith("69")))
                || (String.valueOf(phone).length() == 14 && (String.valueOf(phone).startsWith("00302") || String.valueOf(phone).startsWith("003069")))
        ) return true;
        else return false;
    }
    

}
