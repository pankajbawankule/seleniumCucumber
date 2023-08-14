package com.planit.stepdef;

import com.cucumber.listener.Reporter;
import com.planit.util.WebdriverHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        System.out.println("Executing before hooks");
        //below code should manage through environemnt management
        WebdriverHelper.driver.get("https://jupiter.cloud.planittesting.com");
    }

    @After
    public void tearDown(){
        /*
            Uncomment below code if screenshot required on failure
            but to uss this please create folder with name screenshot under path target/cucumber-reports
            This is a temporary process will write the code to auto create screenshot directory

        */
         /*if (scenario.isFailed()) {
            WebdriverHelper.takeScreenShot(scenario);
        }*/
        //WebdriverHelper.driver.close();
        //WebdriverHelper.driver.quit();
    }
}
