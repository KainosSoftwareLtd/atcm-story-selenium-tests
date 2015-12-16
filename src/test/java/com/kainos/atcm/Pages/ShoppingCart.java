package com.kainos.atcm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends BasePage{
    
public static final By PRODUCTS_ROWS =By.xpath("//tr");

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }
    
    public int getNumberOfRowsWithProducts(){
        return getElements(PRODUCTS_ROWS).size();
    }


}
