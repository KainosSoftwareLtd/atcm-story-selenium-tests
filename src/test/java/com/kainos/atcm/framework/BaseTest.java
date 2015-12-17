package com.kainos.atcm.framework;

import com.kainos.atcm.Pages.*;
        
public class BaseTest {

    private DriverFactory driverFactory;
    protected Browser browser;
    private DriverConfiguration driverCfg;
    public BasePage basePage;
    public ShopProducts shopProducts;
    public ShoppingCart shoppingCart;

    public void setupBaseTest() {
        this.driverFactory = new DriverFactory();
        this.browser = new Browser(driverFactory.getDriver());
        this.driverCfg = new DriverConfiguration();
        this.basePage = new BasePage(driverFactory.getDriver());
        this.shopProducts = new ShopProducts(driverFactory.getDriver());
        this.shoppingCart = new ShoppingCart(driverFactory.getDriver());

        browser.goToLandingPage(driverCfg);
    }


    public void  endSession(){
        browser.quit();
    }
}