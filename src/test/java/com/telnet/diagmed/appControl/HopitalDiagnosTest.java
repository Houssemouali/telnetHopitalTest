package com.telnet.diagmed.appControl;

import com.telnet.diagmed.service.DiagnosticService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *Classe de test pour le classe de control HopitalDiagnos
 * 
 * @author Houss
 */
public class HopitalDiagnosTest {

    public static final String CONST_CARDIOLOGIE = "Rediriger vers : Cardiologie";

    public static final String CONST_TRAUMATOLOGIE = "Rediriger vers : Traumatologie";
   
    public static final String CONST_CARDIOTRAUMA ="Rediriger vers : Cardiologie, Traumatologie";
    
    public static final int VALEUR_CARDIOLOGIE = 6;
    
    public static final int VALEUR_TRAUMATOLOGIE = 20;
    
    public static final int VALEUR_TRAUMACARDIO = 15;

    private final DiagnosticService service = new DiagnosticService();
    private final HopitalDiagnos cabin = new HopitalDiagnos(service);

    /**
     * Test of redirectPatient method, of class HopitalDiagnos for Cardiology.
     */
    @Test
    public void testRedirectPatientIndexCardiology() {
        String message = cabin.redirectPatient(VALEUR_CARDIOLOGIE);
        assertEquals(CONST_CARDIOLOGIE, message);

    }

    /**
     * Test of redirectPatient method, of class HopitalDiagnos for Traumatology.
     */
    @Test
    public void testRedirectPatientIndexTraumatology() {
        String message = cabin.redirectPatient(VALEUR_TRAUMATOLOGIE);
        assertEquals(CONST_TRAUMATOLOGIE , message);

    }

    /**
     * Test of redirectPatient method, of class HopitalDiagnos for Traumatology and Cardiology.
     */
     @Test
    void testRedirectPatientIndexBothUnits() {
        String message = cabin.redirectPatient(VALEUR_TRAUMACARDIO);
        
        boolean bothUnits = message.equals(CONST_CARDIOTRAUMA);
        assertEquals(true, bothUnits);
    }
    
    /**
     * Test of redirectPatient method, of class HopitalDiagnos for non existantIndex.
     */
    @Test
    void shouldReturnNoPathologyMessageForIndex7() {
        String message = cabin.redirectPatient(7);
        assertEquals("Aucune pathologie détectée.", message);
    }
    
}
