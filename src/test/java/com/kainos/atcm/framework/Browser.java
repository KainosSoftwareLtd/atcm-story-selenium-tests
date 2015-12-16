package com.kainos.atcm.framework;

import org.openqa.selenium.WebDriver;

public class Browser {

    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void quit() {
        driver.quit();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }


    public void goToLandingPage(DriverConfiguration driverConf) {
        goToUrl(driverConf.getBaseUrl());
    }
}
