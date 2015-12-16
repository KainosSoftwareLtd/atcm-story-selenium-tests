package com.kainos.atcm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopProducts extends BasePage{

 
    private static final By BUTTON = By.xpath("//button");
    private static final By CART = By.className("navbar-right");

    public ShopProducts(WebDriver driver) {
        super(driver);
    }
    
    public void clickAddToACartForItem(int n){
        List<WebElement> buttons = getElements(BUTTON);
        buttons.get(n-1).click();
    }
    
    public String getCartText(){
       return getText(CART);        
    }
    
    public int getNumberOfItemsInCart(){
       String extractedNumber =  getCartText().replaceAll("\\D+","") ;
        return Integer.valueOf(extractedNumber);
    }
    
    public void openCart(){
        clickOnElement(CART);
    }
}
