package com.apofig.dojo.dangerRefactoring;

public interface Converter {
    boolean checkValid(String expression);

    long convertFromString(String number);
    String convertToString(long number);
}