import Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

    public static void main(String[] args) {

        String name = "Mary Smith";
        String email = "mary@home.com";
        String password = "mpass";
        String gender;
        String country = "United States";
        String phoneNumber = "123456678";
        String weeklyEmail;
        String monthlyEmail;
        String occasionalEmail;
        String browserType = "Chrome";
        WebDriver driver;

        driver = DriverFactory.open(browserType);

        // Open Browser to Account Management Page
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Click create account
        driver.findElement(By.linkText("Create Account")).click();

        driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(name);
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']]")).sendKeys(phoneNumber);

        //input tag, attribute and then the value
        driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys(password);
        driver.findElement((By.name("ctl00$MainContent$txtVerifyPassword"))).sendKeys(password);

        // interacting with radio buttons
        driver.findElement(By.id("MainContent_Female")).click();
        // using css Selector
        //driver.findElement(By.cssSelector("input['ctl00$MainContent$Gender'][value='Female']")).click();

        //drop down menu selection
        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);

        // checkbox
        driver.findElement(By.name("MainContent_checkWeeklyEmail")).click();

        //click submit button
        driver.findElement(By.id("MainContent_btnSubmit")).click();

        // get confirmation
        String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println(("Confirmation " + confirmation));

        driver.close();
    }
}
