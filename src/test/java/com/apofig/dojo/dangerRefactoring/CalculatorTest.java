package com.apofig.dojo.dangerRefactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {

    @Test
    public void shouldCalculateWorks_when10NumberSystem() {
        assertCalculate("1+1", "10", "2");
        assertCalculate("1+10", "10", "11");
        assertCalculate("10+1", "10", "11");
        assertCalculate("10+10", "10", "20");
        assertCalculate("11+11", "10", "22");
        assertCalculate("123+456", "10", "579");
        assertCalculate("0+34", "10", "34");
        assertCalculate("34+0", "10", "34");
    }

    @Test
    public void shouldCalculateWorks_when2NumberSystem() {
        assertCalculate("1+1", "2", "10");
        assertCalculate("1+10", "2", "11");
        assertCalculate("10+1", "2", "11");
        assertCalculate("10+10", "2", "100");
        assertCalculate("11+11", "2", "110");
        assertCalculate("101+111", "2", "1100");
        assertCalculate("0+101", "2", "101");
        assertCalculate("101+0", "2", "101");
    }

    @Test
    public void shouldException_whenBaseIsNotANumber() {
        String wrongBase = "qwe";
        assertException("1+1", wrongBase,
                "java.lang.IllegalArgumentException: Invalid base");
    }

    private void assertException(String expression, String base, String expected) {
        try {
            assertCalculate(expression, base, "inessential");
            fail("Expected exception");
        } catch (Exception e) {
            assertEquals(expected, e.toString());
        }
    }

    private void assertCalculate(String expression, String base, String expected) {
        Calculator calculator = new Calculator();
        String result = calculator.calculate(expression, base);
        assertEquals(expected, result);
    }

}