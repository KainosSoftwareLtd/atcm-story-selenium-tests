package com.kainos.atcm;

import com.kainos.atcm.framework.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class AtcmStoryTest  extends BaseTest{

@Test
public void testAddProductsToCart() {
    super.setupBaseTest();
    
    int initialNumberInCart = shopProducts.getNumberOfItemsInCart();    
    shopProducts.clickAddToACartForItem(1);
    int oneItem = shopProducts.getNumberOfItemsInCart();
    shopProducts.clickAddToACartForItem(2);

    shopProducts.openCart();

    Assert.assertEquals(
}

}
