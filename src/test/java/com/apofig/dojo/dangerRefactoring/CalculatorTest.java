package com.apofig.dojo.dangerRefactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldCalculateWorks() {
        assertCalculate("1+1", "10", "2");
        assertCalculate("1+10", "10", "11");
        assertCalculate("10+1", "10", "11");
        assertCalculate("10+10", "10", "20");
        assertCalculate("11+11", "10", "22");
        assertCalculate("123+456", "10", "579");
        assertCalculate("0+34", "10", "34");

        assertCalculate("0+34", "10", "34");
    }

    private void assertCalculate(String expression, String base, String expected) {
        Calculator calculator = new Calculator();
        String result = calculator.calculate(expression, base);
        assertEquals(expected, result);
    }

}