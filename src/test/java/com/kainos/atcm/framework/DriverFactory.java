package com.kainos.atcm.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
            driver = getChrome();
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
    
    private WebDriver getChrome(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--start-maximized");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
       return driver = new ChromeDriver(capabilities);
    }
    
    private WebDriver getPhantomJS() {
        PHANTOMJS_BINARY = System.getProperty("phantomjs.binary");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        // Configure our WebDriver to support JavaScript and be able to find the PhantomJS binary
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        String [] phantomJsArgs = {"--disable-web-security"};
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, phantomJsArgs);
        
        capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                PHANTOMJS_BINARY
        );
        return driver = new PhantomJSDriver(capabilities);
        
    }
}
