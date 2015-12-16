package com.kainos.atcm.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    private WebDriver driver;
    private static String PHANTOMJS_BINARY;

    public DriverFactory() {
        if (this.driver == null) {
            driver = getPhantomJS();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver getFirefox() {
        FirefoxProfile fp = new FirefoxProfile();
        fp.setPreference("getBrowser.download.manager.showWhenStarting", false);
        fp.setPreference("getBrowser.helperApps.neverAsk.saveToDisk", "application/pdf");
        return driver = new FirefoxDriver(fp);
    }
    
    private WebDriver getPhantomJS() {
        PHANTOMJS_BINARY = System.getProperty("phantomjs.binary");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        // Configure our WebDriver to support JavaScript and be able to find the PhantomJS binary
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                PHANTOMJS_BINARY
        );
        return driver = new PhantomJSDriver(capabilities);
        
    }
}
