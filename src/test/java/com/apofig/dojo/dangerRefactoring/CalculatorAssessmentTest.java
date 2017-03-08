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
        List<String> inputs = new LinkedList<>();
        inputs.add("1+1^2");
        inputs.add("1+10^2");
        inputs.add("10+1^2");
        inputs.add("10+10^2");
        inputs.add("11+11^2");
        inputs.add("101+111^2");
        inputs.add("0+101^2");
        inputs.add("101+0^2");

        Map<String, String> result = calculateAll(inputs);
        System.out.println(result);
    }

    private Map<String, String> calculateAll(List<String> inputs) {
        Map<String, String> result = new LinkedHashMap<String, String>();

        for (String input : inputs) {
            String[] split = input.split("\\^");
            String expression = split[0];
            String base = split[1];
            String value = callMethod(expression, base);
            result.put(input, value);
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

    private String calculate(String expression, String base) {
        Calculator calculator = new Calculator();
        String result = calculator.calculate(expression, base);
        return result;
    }
}
