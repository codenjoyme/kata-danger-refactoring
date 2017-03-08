package com.apofig.dojo.dangerRefactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldCalculateWorks() {
        Calculator calculator = new Calculator();
        String result = calculator.calculate("1+1", "10");
        assertEquals("2", result);
    }

}