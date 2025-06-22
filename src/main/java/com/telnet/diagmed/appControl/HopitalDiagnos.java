package com.telnet.diagmed.appControl;

import com.telnet.diagmed.enums.MedicalUnitEnum;
import com.telnet.diagmed.model.MedicalIndex;
import com.telnet.diagmed.service.DiagnosticService;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 *
 * @author Houss
 */
public class HopitalDiagnos {
    
     private final DiagnosticService diagnosisService;

    public HopitalDiagnos(DiagnosticService diagnostiqueService) {
        this.diagnosisService = diagnostiqueService;
    }

    public String redirectPatient(int healthIndexValue) {
        MedicalIndex index = new MedicalIndex(healthIndexValue);
        EnumSet<MedicalUnitEnum> units = diagnosisService.diagnose(index);

        if (units.isEmpty()) {
            return "Aucune pathologie détectée." ;
        } else {
            return "Rediriger vers : " + formatUnits(units);
        }
    }

    private String formatUnits(EnumSet<MedicalUnitEnum> units) {
        List<String> names = new ArrayList<>();
        for (MedicalUnitEnum unit : units) {
            names.add(unit.name().substring(0, 1).toUpperCase() 
                    + unit.name().substring(1).toLowerCase());
        }
        return String.join(", ", names);
    }
    
}
