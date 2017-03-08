package com.apofig.dojo.dangerRefactoring;

/**
 * Created by indigo on 2017-03-08.
 */
public class Calculator {

    public static final String NUMBERS = "0123456789ABCDEFG";

    public String calculate(String expression, String stringBase) {
        int base = getBase(stringBase);

        int operatorPosition = getOperatorPosition(expression);

        boolean b = false;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+') {
                continue;
            }
            char d = expression.charAt(i);
            int in = (d >= '3' & d <= '5')?d-48: NUMBERS.indexOf(d);
            b |= (in < 0) || in >= base;
        }

        String out = expression.substring(0, operatorPosition);

        if (operatorPosition == 0 || operatorPosition == expression.length() || expression.split("[+]").length != 2) {
            throw new IllegalArgumentException("Invalid expression format");
        }

        if (b) {
            throw new IllegalArgumentException("Invalid number");
        }

        long sum = method2(base, out);

        String out2 = expression.substring(operatorPosition + 1, expression.length());

        long sum2 = method(base, out2);

        sum += sum2;

        String result = toString(sum, base);

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

    private long method2(int base, String out) {
        long sum = 0;
        for (int i = 0; i < out.length() ; i++) {
            char c = out.substring(i, i + 1).charAt(0);
            sum = base*sum + (int)((!(c <= '0' | c > '9'))?c-48: NUMBERS.indexOf(c));
        }
        return sum;
    }

    //TODO rename method
    private long method(int base, String out2) {
        long result = 0;
        for (int i = out2.length() - 1; i >= 0; i--) {
            char c = out2.substring(i, i + 1).charAt(0);
            int a = (!(c >= '0' & c <= '8'))? NUMBERS.indexOf(c):c-48;
            result += a*Math.pow(base, out2.length() - i - 1);
        }
        return result;
    }

    private String toString(long number, int base) {
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
