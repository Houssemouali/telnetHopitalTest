package com.telnet.diagmed.service;

import com.telnet.diagmed.enums.MedicalUnitEnum;
import com.telnet.diagmed.model.MedicalIndex;
import java.util.EnumSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Houss
 */
public class DiagnosticServiceTest {
   private final DiagnosticService service = new DiagnosticService();

    
    @Test
    public void diagnosticServiceTest_MultipleDe3() {
        MedicalIndex index = new MedicalIndex(33);
        EnumSet<MedicalUnitEnum> result = service.diagnose(index);
        
        assertTrue(result.contains(MedicalUnitEnum.CARDIOLOGIE), "Cardilogie doit etre detecté");
        assertFalse(result.contains(MedicalUnitEnum.TRAUMATOLOGIE));
    }
   
      @Test
    public void diagnosticServiceTest_MultipleDe5() {
        MedicalIndex index = new MedicalIndex(5);
        EnumSet<MedicalUnitEnum> result = service.diagnose(index);
        
        assertTrue(result.contains(MedicalUnitEnum.TRAUMATOLOGIE), "TRAUMATOLOGIE doit etre detecté");
        assertFalse(result.contains(MedicalUnitEnum.CARDIOLOGIE));
    }
    
    
     @Test
    public void diagnosticServiceTest_MultipleDe3et5() {
        MedicalIndex index = new MedicalIndex(15);
        EnumSet<MedicalUnitEnum> result = service.diagnose(index);
        
        assertTrue(result.contains(MedicalUnitEnum.TRAUMATOLOGIE));
        assertTrue(result.contains(MedicalUnitEnum.CARDIOLOGIE));
    }
    
     @Test
    public void diagnosticServiceTest_MultipleNor3et5() {
        MedicalIndex index = new MedicalIndex(22);
        EnumSet<MedicalUnitEnum> result = service.diagnose(index);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void throwExceptionIfIndexIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class, () -> new MedicalIndex(0));
        assertThrows(IllegalArgumentException.class, () -> new MedicalIndex(-1));
    }
    
    
}
