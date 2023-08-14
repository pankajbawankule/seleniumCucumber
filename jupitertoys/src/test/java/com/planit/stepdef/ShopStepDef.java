package com.planit.stepdef;

import com.planit.reusablefunctions.ShopOperations;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class ShopStepDef {
    @Given("^User selects items$")
    public void selectItems(DataTable dataTable) throws Throwable{
        ShopOperations.selectItem(dataTable);
    }
}
