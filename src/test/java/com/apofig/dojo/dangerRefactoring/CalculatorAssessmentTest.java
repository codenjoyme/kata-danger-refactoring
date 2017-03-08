package com.apofig.dojo.dangerRefactoring;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by indigo on 2017-03-08.
 */
public class CalculatorAssessmentTest {

    @Test
    public void test(){
        List<String> inputs = loadInputs("src\\test\\java\\com\\apofig\\dojo\\dangerRefactoring\\input.txt");

        Map<String, String> actual = calculateAll(inputs, new CalculatorAssessment());
        Map<String, String> expected = calculateAll(inputs, new Calculator());

        assertEquals(actual.toString().replaceAll(", ", "\n"),
                expected.toString().replaceAll(", ", "\n"));
    }

    private List<String> loadInputs(String filePath) {
        File file = new File(filePath);
        System.out.println(file.getAbsolutePath());
        List<String> result = new ArrayList<String>();
        try (Scanner s = new Scanner(file)) {
            while (s.hasNext()) {
                result.add(s.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Map<String, String> calculateAll(List<String> inputs, Calculator calculator) {
        Map<String, String> result = new LinkedHashMap<String, String>();

        for (String input : inputs) {
            String[] split = input.split("\\^");
            String expression = split[0];
            String base = split[1];
            String value = checkValues(expression, base, calculator);
            result.put(input, value);
        }

        return result;
    }

    private String checkValues(String expression, String base, Calculator calculator) {
        try {
            return  calculator.calculate(expression, base);
        } catch (Exception e) {
            return e.toString();
        }
    }

}
