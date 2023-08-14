package com.planit.reusablefunctions;
import com.planit.locators.PatientLocators;
import java.util.HashMap;
import static com.planit.util.PageActions.*;

public class PatientOperations {
    public static  HashMap<String,String> patientStats = new HashMap<String, String>();
    public static void getPatientsAnalysis() {
        waitForPageLoad();
        for(int i=1;i<=6;i++){
            String patientDesc=getText(PatientLocators.patientDescription(Integer.toString(i)));
            String patientCount=getText(PatientLocators.patientDescription(Integer.toString(i)));
            patientStats.put(patientDesc,patientCount);
        }
    }

    public static void validateWithAnalysisService() {
        HashMap<String,String> patientServiceStats = new HashMap<String, String>();
        patientServiceStats.put("","");
        patientServiceStats.put("","");
        patientServiceStats.put("","");
        patientServiceStats.put("","");
        patientServiceStats.put("","");
        patientServiceStats.put("","");
    }
}
