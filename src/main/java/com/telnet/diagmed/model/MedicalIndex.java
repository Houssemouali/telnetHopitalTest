package com.telnet.diagmed.model;

/**
 * Représente l'index médical utilisé pour diagnostiquer les pathologies ou
 * orienter des patients vers des unités médicales spécifiques.
 *
 * @author Houss
 */
public class MedicalIndex {

    private final int value;

    /**
     * instance de {@code MedicalIndex} avec une valeur donnée.
     * 
     * @param value 
     * @throws IllegalArgumentException  
     */
    public MedicalIndex(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Health index must be positive.");
        }
        this.value = value;
    }

    /**
     * Vérifie si la valeur de l'index est un multiple d'un diviseur.
     */
    public boolean isMultipleOf(int divisor) {
        return value % divisor == 0;
    }

    public int getValue() {
        return value;
    }
}
