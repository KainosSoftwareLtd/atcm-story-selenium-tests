package com.kainos.atcm;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AtcmStoryTest
    extends TestCase
{

private static String PHANTOMJS_BINARY;

/**
 * Check that the PhantomJS binary was installed successfully.
 */
@Before
public static void beforeTest() {
    PHANTOMJS_BINARY = System.getProperty("phantomjs.binary");

    assertNotNull(PHANTOMJS_BINARY);
    assertTrue(new File(PHANTOMJS_BINARY).exists());
}

@Test
public void testSomething() {
    final DesiredCapabilities capabilities = new DesiredCapabilities();


    // Configure our WebDriver to support JavaScript and be able to find the PhantomJS binary
    capabilities.setJavascriptEnabled(true);
    capabilities.setCapability("takesScreenshot", false);
    capabilities.setCapability(
        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
        PHANTOMJS_BINARY
    );

    final WebDriver driver = new PhantomJSDriver(capabilities);
    final String baseURL = "http://localhost:8080" ;


    // If the referenced JavaScript files fail to load, the test fails at this point
    driver.navigate().to(baseURL + "/index.html");

    // Then do some more tests using WebDriver methods...
}

}
