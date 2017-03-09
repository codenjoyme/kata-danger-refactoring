package com.apofig.dojo.dangerRefactoring;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {

    @Test
    public void shouldCalculateWorks_when2NumberSystem() {
        String base = "2";
        assertCalculate("1+1", base, "10");
        assertCalculate("1+10", base, "11");
        assertCalculate("10+1", base, "11");
        assertCalculate("10+10", base, "100");
        assertCalculate("11+11", base, "110");
        assertCalculate("101+111", base, "1100");
        assertCalculate("0+101", base, "101");
        assertCalculate("101+0", base, "101");
    }

    @Test
    public void shouldCalculateWorks_when3NumberSystem() {
        String base = "3";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+12", base, "20");
        assertCalculate("12+1", base, "20");
        assertCalculate("12+12", base, "101");
        assertCalculate("11+11", base, "22");
        assertCalculate("121+112", base, "1010");
        assertCalculate("0+121", base, "121");
        assertCalculate("121+0", base, "121");
    }

    @Test
    public void shouldCalculateWorks_when4NumberSystem() {
        String base = "4";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+13", base, "20");
        assertCalculate("13+1", base, "20");
        assertCalculate("13+13", base, "32");
        assertCalculate("11+11", base, "22");
        assertCalculate("131+113", base, "310");
        assertCalculate("0+131", base, "131");
        assertCalculate("131+0", base, "131");
    }

    @Test
    public void shouldCalculateWorks_when5NumberSystem() {
        String base = "5";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+14", base, "20");
        assertCalculate("14+1", base, "20");
        assertCalculate("14+14", base, "33");
        assertCalculate("11+11", base, "22");
        assertCalculate("141+114", base, "310");
        assertCalculate("0+141", base, "141");
        assertCalculate("141+0", base, "141");
    }

    @Test
    public void shouldCalculateWorks_when6NumberSystem() {
        String base = "6";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+15", base, "20");
        assertCalculate("15+1", base, "20");
        assertCalculate("15+15", base, "34");
        assertCalculate("11+11", base, "22");
        assertCalculate("151+115", base, "310");
        assertCalculate("0+151", base, "151");
        assertCalculate("151+0", base, "151");
    }

    @Test
    public void shouldCalculateWorks_when7NumberSystem() {
        String base = "7";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+16", base, "20");
        assertCalculate("16+1", base, "20");
        assertCalculate("16+16", base, "35");
        assertCalculate("11+11", base, "22");
        assertCalculate("161+116", base, "310");
        assertCalculate("0+161", base, "161");
        assertCalculate("161+0", base, "161");
    }

    @Test
    public void shouldCalculateWorks_when8NumberSystem() {
        String base = "8";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+17", base, "20");
        assertCalculate("17+1", base, "20");
        assertCalculate("17+17", base, "36");
        assertCalculate("11+11", base, "22");
        assertCalculate("171+117", base, "310");
        assertCalculate("0+171", base, "171");
        assertCalculate("171+0", base, "171");
    }

    @Test
    public void shouldCalculateWorks_when9NumberSystem() {
        String base = "9";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+18", base, "20");
        assertCalculate("18+1", base, "20");
        assertCalculate("18+18", base, "37");
        assertCalculate("11+11", base, "22");
        assertCalculate("181+118", base, "310");
        assertCalculate("0+181", base, "181");
        assertCalculate("181+0", base, "181");
    }

    @Test
    public void shouldCalculateWorks_when10NumberSystem() {
        String base = "10";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+10", base, "11");
        assertCalculate("10+1", base, "11");
        assertCalculate("10+10", base, "20");
        assertCalculate("11+11", base, "22");
        assertCalculate("123+456", base, "579");
        assertCalculate("0+34", base, "34");
        assertCalculate("34+0", base, "34");
    }

    @Test
    public void shouldCalculateWorks_when11NumberSystem() {
        String base = "11";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+1A", base, "20");
        assertCalculate("1A+1", base, "20");
        assertCalculate("1A+1A", base, "39");
        assertCalculate("11+11", base, "22");
        assertCalculate("1A1+11A", base, "310");
        assertCalculate("0+1A1", base, "1A1");
        assertCalculate("1A1+0", base, "1A1");
    }

    @Test
    public void shouldCalculateWorks_when12NumberSystem() {
        String base = "12";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+1B", base, "20");
        assertCalculate("1B+1", base, "20");
        assertCalculate("1B+1B", base, "3A");
        assertCalculate("11+11", base, "22");
        assertCalculate("1B1+11B", base, "310");
        assertCalculate("0+1B1", base, "1B1");
        assertCalculate("1B1+0", base, "1B1");
    }

    @Test
    public void shouldCalculateWorks_when13NumberSystem() {
        String base = "13";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+1C", base, "20");
        assertCalculate("1C+1", base, "20");
        assertCalculate("1C+1C", base, "3B");
        assertCalculate("11+11", base, "22");
        assertCalculate("1C1+11C", base, "310");
        assertCalculate("0+1C1", base, "1C1");
        assertCalculate("1C1+0", base, "1C1");
    }

    @Test
    public void shouldCalculateWorks_when14NumberSystem() {
        String base = "14";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+1D", base, "20");
        assertCalculate("1D+1", base, "20");
        assertCalculate("1D+1D", base, "3C");
        assertCalculate("11+11", base, "22");
        assertCalculate("1D1+11D", base, "310");
        assertCalculate("0+1D1", base, "1D1");
        assertCalculate("1D1+0", base, "1D1");
    }

    @Test
    public void shouldCalculateWorks_when15NumberSystem() {
        String base = "15";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+1E", base, "20");
        assertCalculate("1E+1", base, "20");
        assertCalculate("1E+1E", base, "3D");
        assertCalculate("11+11", base, "22");
        assertCalculate("1E1+11E", base, "310");
        assertCalculate("0+1E1", base, "1E1");
        assertCalculate("1E1+0", base, "1E1");
    }

    @Test
    public void shouldCalculateWorks_when16NumberSystem() {
        String base = "16";
        assertCalculate("1+1", base, "2");
        assertCalculate("1+1F", base, "20");
        assertCalculate("1F+1", base, "20");
        assertCalculate("1F+1F", base, "3E");
        assertCalculate("11+11", base, "22");
        assertCalculate("1F1+11F", base, "310");
        assertCalculate("0+1F1", base, "1F1");
        assertCalculate("1F1+0", base, "1F1");
    }

    @Test
    public void shouldException_whenBaseIsNotANumber() {
        String wrongBase = "qwe";
        assertException("1+1", wrongBase,
                "java.lang.IllegalArgumentException: Invalid base");
    }

    @Test
    public void shouldException_whenBaseIsOne() {
        String wrongBase = "1";
        assertException("1+1", wrongBase,
                "java.lang.IllegalArgumentException: Invalid base");
    }

    @Test
    public void shouldException_whenBaseIsZero() {
        String wrongBase = "0";
        assertException("1+1", wrongBase,
                "java.lang.IllegalArgumentException: Invalid base");
    }

    @Test
    public void shouldException_whenBaseIsMoreThan17() {
        String maxAcceptableBase = "17";
        assertCalculate("1+1", maxAcceptableBase, "2");
        
        String wrongBase = "18";
        assertException("1+1", wrongBase,
                "java.lang.IllegalArgumentException: Invalid base");
    }

    @Test
    public void shouldCalculateWorks_when17NumberSystem_checkAllSymbols() {
        assertCalculate("12+34", "17", "46");
        assertCalculate("45+67", "17", "AC");
        assertCalculate("89+1A", "17", "A2");
        assertCalculate("AB+CD", "17", "167");
        assertCalculate("EF+FG", "17", "1DE");
        assertCalculate("GG+11", "17", "110");
    }

    @Test
    public void shouldException_whenBadNumberContainsUnexpectedSymbols() {
        String wrongNumber = "H";

        assertException("1+" + wrongNumber, "17",
                "java.lang.IllegalArgumentException: Invalid number");

        assertException(wrongNumber + "+1", "17",
                "java.lang.IllegalArgumentException: Invalid number");
    }

    @Test
    public void shouldException_whenUsedSymbolNotPermittedInThisNumberSystem() {
        String wrongNumber = "2";
        String base = "2";

        assertException("1+" + wrongNumber, base,
                "java.lang.IllegalArgumentException: Invalid number");

        assertException(wrongNumber + "+1", base,
                "java.lang.IllegalArgumentException: Invalid number");
    }

    @Test
    public void shouldException_whenUseAnotherOperation() {
        String wrongOperation = "-";

        assertException("1" + wrongOperation + "1", "2",
                "java.lang.IllegalArgumentException: Invalid expression format");
    }

    private void assertException(String expression, String base, String expected) {
        try {
            assertCalculate(expression, base, "inessential");
            fail("Expected exception");
        } catch (Exception e) {
            assertEquals(expected, e.toString());
        }
    }

    @Ignore
    @Test
    public void shouldException_caseX() {
        assertException("+21+", "10",
                "java.lang.StringIndexOutOfBoundsException: String index out of range: 24");
    }

    @Test
    public void shouldWorkWithRoman() {
        assertCalculate("III+III", "R", "VI");
        assertCalculate("IV+VI", "R", "X");
        assertCalculate("XII+IX", "R", "XXI");
    }

    private void assertCalculate(String expression, String base, String expected) {
        Calculator calculator = new Calculator();
        String result = calculator.calculate(expression, base);
        assertEquals(expected, result);
    }

}