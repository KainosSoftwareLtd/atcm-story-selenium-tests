package com.kainos.atcm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopProducts extends BasePage{

 
    private static final By BUTTON = By.id("add-item-to-cart");
    private static final By CART = By.id("shopping-cart-summary");
    private static final By INFO_TEXT = By.className("jumbotron");

    public ShopProducts(WebDriver driver) {
        super(driver);
    }
    
    public ShopProducts clickOnFirstProduct(){
        clickOnElement(BUTTON);
        return this;
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

    public String getInformationText() {
       return getText(INFO_TEXT);
    }
}
