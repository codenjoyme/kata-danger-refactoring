package com.apofig.dojo.dangerRefactoring;

/**
 * Created by indigo on 2017-03-08.
 */
public class Calculator {

    public static final String NUMBERS = "0123456789ABCDEFG";

    public String calculate(String expr, String bs) {
        int base = 0;
        try {
            base = Integer.valueOf(bs);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid base", e);
        }
        if (base > NUMBERS.length() || base <= 1) {
            throw new IllegalArgumentException("Invalid base");
        }

        boolean b = false;
        int pos = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '+') {
                pos = i;
                continue;
            }

            char d = expr.charAt(i);
            int in = (d >= '3' & d <= '5')?d-48: NUMBERS.indexOf(d);
            b |= (in < 0) || in >= base;
        }

        String out = expr.substring(0, pos);

        if (pos == 0 || pos == expr.length() || expr.split("[+]").length != 2) {
            throw new IllegalArgumentException("Invalid expression format");
        }

        if (b) {
            throw new IllegalArgumentException("Invalid number");
        }

        long sum = 0;
        for (int i = 0; i < out.length() ; i++) {
            char c = out.substring(i, i + 1).charAt(0);
            sum = base*sum + (int)((!(c <= '0' | c > '9'))?c-48: NUMBERS.indexOf(c));
        }

        out = expr.substring(pos + 1, expr.length());

        long sum2 = 0;
        for (int i = out.length() - 1; i >= 0; i--) {
            char c = out.substring(i, i + 1).charAt(0);
            int a = (!(c >= '0' & c <= '8'))? NUMBERS.indexOf(c):c-48;
            sum2 += a*Math.pow(base, out.length() - i - 1);
        }

        sum += sum2;

        String result = "";
        long l = sum;
        do {
            int h = (int)(l % base);
            l = l / base;
            String digits = "GFEDCBA9876543210";
            result = digits.charAt(16 - h) + result;
        } while (l >= 1);

        return result;
    }

}
