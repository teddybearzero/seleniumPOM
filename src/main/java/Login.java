import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) {

        // Open the Web Browser
        //System.setProperty("webdriver.chrome.driver", "//Users/andraemckenzie/Documents/software/chromedriver");
        System.setProperty("webdriver.chrome.driver", "//Users/teddybearzero/Documents/software/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to the web application
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Enter email address
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        //Enter password
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");

        //Click login
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

        //Get Confirmation
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("Confirmation: " + message);

        String pageTitle = driver.getTitle();
        if (pageTitle.equals("SDET Training | Account Management")){
            System.out.println("Page Title Test Passed");
        }

        // Close the browser
        driver.close();
    }
}
