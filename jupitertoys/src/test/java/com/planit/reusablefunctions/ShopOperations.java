package com.planit.reusablefunctions;

import com.cucumber.listener.Reporter;
import com.planit.locators.CartPageLocators;
import com.planit.locators.ContactPageLocators;
import com.planit.locators.ShopPageLocators;
import cucumber.api.DataTable;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.planit.util.PageActions.*;

public class ShopOperations {

    private static List<Map<String , String >> selectedShoppingItems = new ArrayList<Map<String, String>>();

    /**
     * This function will perform item selection for cart
     * @param dataTable - user provided table with item name and quantity*/
    public static void selectItem(DataTable dataTable){
        List<Map<String,String>> dataList = dataTable.asMaps(String.class,String.class);
        selectedShoppingItems=dataList;
        for(int i=0; i<dataList.size();i++){
            for (int j=0; j<Integer.parseInt(dataList.get(i).get("Quantity"));j++){
                click(ShopPageLocators.buyItem(dataList.get(i).get("Item Name")));
            }
        }
    }

    /**
     * Verification of user selected items*/
    public static void verifySelectedItems(){
        boolean overallCartStatus=true;
        for(int i=0; i<selectedShoppingItems.size();i++){
            boolean status = isElementPresent(CartPageLocators.itemQuantityOnCart(ShopOperations.selectedShoppingItems.get(i).get("Item Name"),ShopOperations.selectedShoppingItems.get(i).get("Quantity")));
            if(!status){
                overallCartStatus=false;
                Reporter.addStepLog("Item:"+ShopOperations.selectedShoppingItems.get(i).get("Item Name")+" with quantity:"+ShopOperations.selectedShoppingItems.get(i).get("Quantity")+" not present in cart");
            }
            Reporter.addStepLog("Item:"+ShopOperations.selectedShoppingItems.get(i).get("Item Name")+" with quantity:"+ShopOperations.selectedShoppingItems.get(i).get("Quantity")+" present in cart");
        }
        if(!overallCartStatus)
            Assert.assertFalse("Selected items are not prsent in cart with selectd quantity",true);
    }
}
