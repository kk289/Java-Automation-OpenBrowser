package openChrome;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome {

    @Test
    public void chromeBrowser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        //WebDriverManager.chromedriver().setup();

        WebDriver wd = new ChromeDriver();
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