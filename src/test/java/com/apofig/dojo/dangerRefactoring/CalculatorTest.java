package com.apofig.dojo.dangerRefactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldCalculateWorks() {
        assertCalculate("1+1", "10", "2");
    }

    private void assertCalculate(String expression, String base, String expected) {
        Calculator calculator = new Calculator();
        String result = calculator.calculate(expression, base);
        assertEquals(expected, result);
    }

}