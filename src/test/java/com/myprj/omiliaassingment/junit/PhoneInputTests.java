/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprj.omiliaassingment.junit;

import com.myprj.omiliaassignment.phonenumberinterpretation.UserInput;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Maria
 */
public class PhoneInputTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void test_StringInput() {
        String in = "a b";
        UserInput.checkPhoneNumber(in);
        assertEquals("Not a valid phone number\r\n", outContent.toString());
    }

    @Test
    public void test_GreekPhoneNumber10DigitsStartsWith2() {
        String startsWIth2And10digits = "2000000000";
        UserInput.checkPhoneNumber(startsWIth2And10digits);
        assertEquals("Interpretation 1: 2000000000 [phone number: VALID]\r\n", outContent.toString());
    }

    @Test
    public void test_GreekPhoneNumber10DigitsStartsWith69() {
        String startsWIth69And10digits = "6900000000";
        UserInput.checkPhoneNumber(startsWIth69And10digits);
        assertEquals("Interpretation 1: 6900000000 [phone number: VALID]\r\n", outContent.toString());
    }

    @Test
    public void test_GreekPhoneNumber14DigitsStartsWith003069() {
        String startsWIth003069And14digits = "00306900000000";
        UserInput.checkPhoneNumber(startsWIth003069And14digits);
        assertEquals("Interpretation 1: 00306900000000 [phone number: VALID]\r\n", outContent.toString());
    }

    @Test
    public void test_GreekPhoneNumber14DigitsStartsWith00302() {
        String startsWIth00302And14digits = "00302000000000";
        UserInput.checkPhoneNumber(startsWIth00302And14digits);
        assertEquals("Interpretation 1: 00302000000000 [phone number: VALID]\r\n", outContent.toString());
    }

    @Test
    public void test_DoubleDigit() {
        String doubleDigit = "25";
        UserInput.checkPhoneNumber(doubleDigit);
        assertEquals("Interpretation 1: 25 [phone number: INVALID]\r\n"
                + "Interpretation 2: 205 [phone number: INVALID]\r\n", outContent.toString());
    }

    @Test
    public void test_CombinationsWithDoubleDigits() {
        String input = "13 25";
        UserInput.checkPhoneNumber(input);
        assertEquals("Interpretation 1: 1325 [phone number: INVALID]\r\n"
                + "Interpretation 2: 13205 [phone number: INVALID]\r\n"
                + "Interpretation 3: 10325 [phone number: INVALID]\r\n"
                + "Interpretation 4: 103205 [phone number: INVALID]\r\n", outContent.toString());
    }
    
    @Test
    public void test_CombinationsWithDoubleAndSingleDigit() {
        String input = "1 25";
        UserInput.checkPhoneNumber(input);
        assertEquals("Interpretation 1: 125 [phone number: INVALID]\r\n"
                + "Interpretation 2: 1205 [phone number: INVALID]\r\n", outContent.toString());
    }
}
