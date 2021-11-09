package com.myprj.omiliaassignment.phonenumberinterpretation;

import java.util.*;

public class NumberAmbiguitiesPermutations {

    // finds possible ambiguities in digits and saves them in a LinkedHashMap
    LinkedHashMap<Integer, List<String>> digitsCombinationsList(String str) {
        LinkedHashMap<Integer, List<String>> digitsCombinations = new LinkedHashMap<>();
        List<String> digits = Arrays.asList(str.split(" "));
        for (int i = 0; i < digits.size(); i++) {

            if (digits.get(i).length() > 1 && digits.get(i).contains("0")) {
                String digit = digits.set(i, digits.get(i).replace("0", ""));
                digitsCombinations.put(i, Arrays.asList(digit, digits.get(i)));
            } else if (digits.get(i).length() > 1 && !digits.get(i).contains("0") && !digits.get(i).equals("11") && !digits.get(i).equals("12")) {
                String sb = "";
                for (int j = 0; j < digits.get(i).length(); j++) {
                    sb += digits.get(i).substring(j, j + 1).concat(String.join("", Collections.nCopies(digits.get(i).length() - j - 1, "0")));
                }
                String digit = digits.set(i, sb);
                digitsCombinations.put(i, Arrays.asList(digit, digits.get(i)));
            } else {
                digitsCombinations.put(i, Arrays.asList(digits.get(i), digits.get(i)));
            }
        }
        return digitsCombinations;
    }

    // finds permutations between digits in LinkedHashMap and adds the to the list given in the parameters
    List<String> phoneNumberPermutationsList(LinkedHashMap<Integer, List<String>> digitsCombinations) {
        List<List<String>> digits = new ArrayList<>(digitsCombinations.values());
        List<String> result = new ArrayList<>();
        findPermutations(0, "", digitsCombinations.size(), digits, result);
        return result;
    }

    private void findPermutations(int i, String str, int mapSize, List<List<String>> digits, List<String> result) {
        if (i >= mapSize) {
            if (!result.contains(str)) {
                result.add(str);
            }
            return;
        }
        List<String> list = digits.get(i);
        findPermutations(i + 1, str + list.get(0), mapSize, digits, result);
        findPermutations(i + 1, str + list.get(1), mapSize, digits, result);
    }
}
