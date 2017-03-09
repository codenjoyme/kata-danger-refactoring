package com.apofig.dojo.dangerRefactoring;

/**
 * Created by indigo on 2017-03-08.
 */
public class Calculator  {

    private Converter converter;

    public String calculate(String expression, String stringBase) {
        if (stringBase.equals("R")) {
            converter = new RomanConverter();
        } else {
            converter = new BaseNumberConverter(stringBase);
        }

        int operatorPosition = getOperatorPosition(expression);
        if (operatorPosition == 0 || operatorPosition == expression.length() || expression.split("[+]").length != 2) {
            throw new IllegalArgumentException("Invalid expression format");
        }

        String number1String = expression.substring(0, operatorPosition);
        long number1 = converter.convertFromString(number1String);

        String number2String = expression.substring(operatorPosition + 1, expression.length());
        long number2 = converter.convertFromString(number2String);

        long sum = number1 + number2;

        String result = converter.convertToString(sum);
        return result;
    }

    private int getOperatorPosition(String expr) {
        for (int index = 0; index < expr.length(); index++) {
            if (expr.charAt(index) == '+') {
                return index;
            }
        }
        return 0;
    }





}
