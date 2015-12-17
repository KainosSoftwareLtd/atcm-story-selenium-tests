package com.kainos.atcm;

import com.kainos.atcm.framework.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ShoppingCartTest extends BaseTest{
    
    @Before
    public void setup(){
        super.setupBaseTest();
    }

    @Test
    public void testAddProductsToCart() {
    shopProducts
            .clickOnFirstProduct()
            .clickOnFirstProduct();

    assertEquals("Expected number of products displayed in Cart should be 2",
            2,shopProducts.getNumberOfItemsInCart());
    
    shopProducts.openCart();

   assertEquals("Expected number of products should be 2",2,shoppingCart.getQuantityOfFirstProduct());
}
    
    @Test
    public void testEmptyCart(){
        shopProducts.openCart();
        System.out.print(shopProducts.getInformationText());
        
    }
    @After
    public void quit(){
    browser.quit();
    
}
}
