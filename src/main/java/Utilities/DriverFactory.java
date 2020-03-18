package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static WebDriver open(String browserType) {
        if (browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "//Users/andraemckenzie/Documents/software/chromedriver");
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("FireFox")) {
            System.setProperty("webdriver.gecko.driver", "//Users/andraemckenzie/Documents/software/geckodriver");
            return new FirefoxDriver();
        } else {
            System.setProperty("webdriver.ie.driver", "ie path");
            return new InternetExplorerDriver();
        }
    }
}
