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

    private int getBase(String bs) {
        int base = 0;
        try {
            base = Integer.valueOf(bs);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid base", e);
        }
        if (base > NUMBERS.length() || base <= 1) {
            throw new IllegalArgumentException("Invalid base");
        }
        return base;
    }

    @Override // TODO to check only numbers not expressions
    public boolean checkValid(String expression) {
        boolean result = true;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+') {
                continue;
            }
            char d = expression.charAt(i);
            int in = NUMBERS.indexOf(d);
            result &= (in >= 0) && in < base;
        }
        return result;
    }

    @Override
    public long convertFromString(String string) {
        long result = 0;
        for (int i = 0; i < string.length() ; i++) {
            char c = string.substring(i, i + 1).charAt(0);
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
