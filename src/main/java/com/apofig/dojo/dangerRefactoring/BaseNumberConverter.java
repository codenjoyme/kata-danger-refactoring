package com.apofig.dojo.dangerRefactoring;

/**
 * Created by indigo on 2017-03-09.
 */
public class BaseNumberConverter implements Converter {

    private static final String NUMBERS = "0123456789ABCDEFG";

    private int base;

    public BaseNumberConverter(String stringBase) {
        base = getBase(stringBase);
    }

    private int getBase(String stringBase) {
        int result = 0;
        try {
            result = Integer.valueOf(stringBase);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid base", e);
        }
        if (result > NUMBERS.length() || result <= 1) {
            throw new IllegalArgumentException("Invalid base");
        }
        return result;
    }

    private void validateNumber(String number) {
        boolean valid = true;
        for (int index = 0; index < number.length(); index++) {
            char d = number.charAt(index);
            int in = NUMBERS.indexOf(d);
            valid &= (in >= 0) && in < base;
        }
        if (!valid) {
            throw new IllegalArgumentException("Invalid number");
        }
    }

    @Override
    public long convertFromString(String string) {
        validateNumber(string);

        long result = 0;
        for (int index = 0; index < string.length() ; index++) {
            char c = string.substring(index, index + 1).charAt(0);
            result = base*result + NUMBERS.indexOf(c);
        }
        return result;
    }

    @Override
    public String convertToString(long number) {
        String result = "";
        long l = number;
        do {
            int h = (int)(l % base);
            l = l / base;
            String digits = NUMBERS;
            result = digits.charAt(h) + result;
        } while (l >= 1);
        return result;
    }
}
