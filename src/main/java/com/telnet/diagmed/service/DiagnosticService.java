package com.telnet.diagmed.service;

import com.telnet.diagmed.enums.MedicalUnitEnum;
import com.telnet.diagmed.model.MedicalIndex;
import java.util.EnumSet;

/**
 * Service de diagnostic permettant de déterminer les unités
 * médicales en fonction de l'index médicale donné
 *
 * @author Houss
 */
public class DiagnosticService {

    /**
     * Analyse l'indice médical et détermine les unités médicales concernées.
     * 
     * @param index
     * @return EnumSet
     */
    public EnumSet<MedicalUnitEnum> diagnose(MedicalIndex index) {
        EnumSet<MedicalUnitEnum> result = EnumSet.noneOf(MedicalUnitEnum.class);

        if (index.isMultipleOf(3)) {
            result.add(MedicalUnitEnum.CARDIOLOGIE);
        }
        if (index.isMultipleOf(5)) {
            result.add(MedicalUnitEnum.TRAUMATOLOGIE);
        }

        return result;
    }
}
