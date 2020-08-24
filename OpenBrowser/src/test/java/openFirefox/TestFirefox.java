package openFirefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestFirefox {

    @Test
    public void firefoxBrowser() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();

        WebDriver wd = new FirefoxDriver();

        wd.get("http://www.google.com");

        // Print a Log In message to the screen
        System.out.println("Successfully opened the website");

        // Maximize Browser
        wd.manage().window().maximize();

        // Wait for 5 sec
        Thread.sleep(5000);

        // Close
        wd.quit();
    }
}