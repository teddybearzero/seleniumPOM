import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateAccounts {

    public static void main(String[] args) {

        // Create WebDriver
        System.setProperty("webdriver.gecko.driver", "//Users/andraemckenzie/Documents/software/geckodriver");
        WebDriver driver = new FirefoxDriver();

        // Open Browser to Account Management Page
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Click create account
        driver.findElement(By.linkText("Create Account")).click();

        driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Mary Smith");
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys();

        driver.close();



    }

}
