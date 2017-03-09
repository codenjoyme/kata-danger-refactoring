package com.apofig.dojo.dangerRefactoring;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RomanConverter implements Converter {

    public static final int[] DIVIDERS = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static Map<Character, Long> digits = new HashMap<Character, Long>();
    private static Map<Long, String> symbols = new HashMap<Long, String>();

    static {
        digits.put('I', 1L);
        digits.put('V', 5L);
        digits.put('X', 10L);
        digits.put('L', 50L);
        digits.put('C', 100L);
        digits.put('D', 500L);
        digits.put('M', 1000L);

        symbols.put(1L, "I");
        symbols.put(4L, "IV");
        symbols.put(5L, "V");
        symbols.put(9L, "IX");
        symbols.put(10L, "X");
        symbols.put(40L, "XL");
        symbols.put(50L, "L");
        symbols.put(90L, "XC");
        symbols.put(100L, "C");
        symbols.put(400L, "CD");
        symbols.put(500L, "D");
        symbols.put(900L, "CM");
        symbols.put(1000L, "M");
    }

    @Override
    public boolean checkValid(String expression) {
        return false; // TODO to use validateNumber(rom);
    }

    @Override
    public long convertFromString(String rom) {
        validateNumber(rom);

        int sum = 0;
        Character previous = null;
        for (int i = rom.length() - 1; i >= 0; i--) {
            char currentSymbol = rom.charAt(i);
            Long currentDigit = digits.get(currentSymbol);
            if (previous != null && digits.get(previous) > currentDigit) {
                sum -= currentDigit;
            } else {
                sum += currentDigit;
            }
            previous = currentSymbol;
        }
        return sum;
    }

    @Override
    public String convertToString(long number) {
        StringBuilder result = new StringBuilder();

        for (int divider : DIVIDERS) {
            number = appendSymbols(number, divider, result);
        }
        return result.toString();
    }

    private long appendSymbols(long number, long divider, StringBuilder result) {
        long div = number / divider;
        for (int i = 1; i <= div; i++) {
            result.append(symbols.get(divider));
        }
        return number - divider * div;
    }

    private static void validateNumber(String expr) {
        if (!Pattern.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$", expr)) {
            throw new IllegalArgumentException("Invalid number");
        }
    }
}