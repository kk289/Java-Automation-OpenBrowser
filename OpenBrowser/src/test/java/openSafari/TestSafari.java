package openSafari;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestSafari {

    @Test
    public void safariBrowser() throws InterruptedException {
        // Instantiate a SafariDriver class.
        System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");

        WebDriver driver = new SafariDriver();

        // Launch Website
        driver.get("http://www.google.com");

        // Print a Log In message to the screen
        System.out.println("Successfully Opened the website");

        // Maximize Browser
        driver.manage().window().maximize();

        // Wait for 5 sec
        Thread.sleep(5000);

        // Close the Browser
        driver.quit();
    }
}