package com.telnet.diagmed.model;

/**
 *
 * @author Houss
 */
public class MedicalIndex {
     private final int value;

    public MedicalIndex(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Health index must be positive.");
        }
        this.value = value;
    }

    public boolean isMultipleOf(int divisor) {
        return value % divisor == 0;
    }

    public int getValue() {
        return value;
    }
}
