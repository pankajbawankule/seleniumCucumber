package com.planit.stepdef;

import com.planit.reusablefunctions.CartReusableOperations;
import com.planit.reusablefunctions.ShopOperations;
import cucumber.api.java.en.Then;

public class CartStepDef {

    @Then("^User verifies selected items availability in cart$")
    public void verifyCart(){
        ShopOperations.verifySelectedItems();
    }
}
