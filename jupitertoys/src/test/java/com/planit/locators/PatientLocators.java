package com.planit.locators;

import org.openqa.selenium.By;

public class PatientLocators {
    public static By patientDescription(String count) {
       return By.xpath("//tbody/tr["+count+"]/td[contains(text(),'Patients')]");
    }

    public static By patientCount(String count) {
        return By.xpath("//tbody/tr["+count+"]/td[contains(text(),'Patients')]/following-sibling::td");
    }
}
