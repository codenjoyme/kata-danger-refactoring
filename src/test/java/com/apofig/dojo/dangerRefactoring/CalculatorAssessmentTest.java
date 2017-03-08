package com.apofig.dojo.dangerRefactoring;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by indigo on 2017-03-08.
 */
public class CalculatorAssessmentTest {

    @Test
    public void test(){
        String validChars = "0123456789ABCDEFG+";
        String invalidChars = "H-/*";
        String charsForCombination = validChars + invalidChars;

        Map<String, String> result = calculateAll(
                combination(charsForCombination, 5),
                combination(charsForCombination, 2));

        System.out.println(result);
    }

    private Map<String, String> calculateAll(List<String> expressionList, List<String> baseList) {
        Map<String, String> result = new LinkedHashMap<String, String>();

        for (String expression : expressionList) {
            for (String base : baseList) {
                String value = callMethod(expression, base);

                result.put(expression + "^" + base, value);
            }
        }

        return result;
    }

    private String callMethod(String expression, String base) {
        try {
            return calculate(expression, base);
        } catch (Exception e) {
            return e.toString();
        }
    }

    private List<String> combination(String chars, int length) {
        String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> result = new LinkedList<>();
        int base = chars.length();
        long max = (long) Math.pow(base, length);

        for (long i = 0; i < max; i++) {
            String string = Long.toString(i, base).toUpperCase();

            StringBuilder resultString = new StringBuilder();
            for (int j = 0; j < string.length(); j++) {
                char ch = string.charAt(j);
                int indexOf = CHARS.indexOf(ch);
                char ch2 = chars.charAt(indexOf);

                resultString.append(ch2);
            }

            result.add(resultString.toString());
        }

        return result;
    }

    private String calculate(String expression, String base) {
        Calculator calculator = new Calculator();
        String result = calculator.calculate(expression, base);
        return result;
    }
}
