package com.apofig.dojo.dangerRefactoring;

/**
 * Created by indigo on 2017-03-08.
 */
public class Calculator {

    public static final String NUMBERS = "0123456789ABCDEFG";
    private int base;

    public String calculate(String expression, String stringBase) {
        base = getBase(stringBase);

        int operatorPosition = getOperatorPosition(expression);
        if (operatorPosition == 0 || operatorPosition == expression.length() || expression.split("[+]").length != 2) {
            throw new IllegalArgumentException("Invalid expression format");
        }

        boolean isValid = checkValid(expression);
        if (!isValid) {
            throw new IllegalArgumentException("Invalid number");
        }

        String number1String = expression.substring(0, operatorPosition);
        long number1 = parse(number1String);

        String number2String = expression.substring(operatorPosition + 1, expression.length());
        long number2 = parse(number2String);

        long sum = number1 + number2;

        String result = toString(sum);
        return result;
    }

    private boolean checkValid(String expression) {
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

    private int getOperatorPosition(String expr) {
        int operatorPosition = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '+') {
                operatorPosition = i;
                continue;
            }
        }
        return operatorPosition;
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

    private long parse(String string) {
        long result = 0;
        for (int i = 0; i < string.length() ; i++) {
            char c = string.substring(i, i + 1).charAt(0);
            result = base*result + NUMBERS.indexOf(c);
        }
        return result;
    }

    private String toString(long number) {
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
