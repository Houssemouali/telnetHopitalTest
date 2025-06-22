package com.telnet.diagmed;

import com.telnet.diagmed.appControl.HopitalDiagnos;
import com.telnet.diagmed.service.DiagnosticService;

/**
 * Class main de test
 *
 * @author Houss
 */
public class DiagMed {

    public static void main(String[] args) {
        DiagnosticService diagnosticService = new DiagnosticService();
        HopitalDiagnos cabinHopital = new HopitalDiagnos(diagnosticService);

        String patient1Cardio = cabinHopital.redirectPatient(33);
        System.out.println(patient1Cardio);

        String patient2Trauma = cabinHopital.redirectPatient(55);
        System.out.println(patient2Trauma);

        String patient3TraumaCardio = cabinHopital.redirectPatient(15);
        System.out.println(patient3TraumaCardio);

        String patient4Undefined = cabinHopital.redirectPatient(22);
        System.out.println(patient4Undefined);

    }
}
