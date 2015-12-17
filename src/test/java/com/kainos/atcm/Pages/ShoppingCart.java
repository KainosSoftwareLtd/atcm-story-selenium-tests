package com.kainos.atcm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends BasePage{
    
public static final By PRODUCTS_ROWS =By.id("shopping-cart-item");
public static final By QUANTITY =By.id("quantity");

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }
    
    public int getNumberOfRowsWithProducts(){
        return getElements(PRODUCTS_ROWS).size();
    }
    
    public int getQuantityOfFirstProduct(){
        String qnty = getElement(PRODUCTS_ROWS).findElement(QUANTITY).getText();
        return  Integer.parseInt(qnty);
    }


}
