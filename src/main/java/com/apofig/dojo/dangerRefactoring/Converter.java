package com.apofig.dojo.dangerRefactoring;

public interface Converter {
    long convertFromString(String number);
    String convertToString(long number);
}