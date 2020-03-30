import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccounts {

    public static void main(String[] args) {

        // Create WebDriver
        //System.setProperty("webdriver.gecko.driver", "//Users/andraemckenzie/Documents/software/geckodriver");
        System.setProperty("webdriver.gecko.driver", "//Users/teddybearzero/Documents/software/chromedriver");
        WebDriver driver = new FirefoxDriver();

        // Open Browser to Account Management Page
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Click create account
        driver.findElement(By.linkText("Create Account")).click();

        driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Mary Smith");
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys("mary@home.com");
        driver.findElement(By.xpath("//*[@id='MainContent_txtEmail']")).sendKeys("123456678");

        //input tag, attribute and then the value
        driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("mspass");
        driver.findElement((By.name("ctl00$MainContent$txtVerifyPassword"))).sendKeys("mspass");

        // interacting with radio buttons
        driver.findElement(By.id("MainContent_Female")).click();
        // using css Selector
        //driver.findElement(By.cssSelector("input['ctl00$MainContent$Gender'][value='Female']")).click();

        //drop down menu selection
        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("United States");

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
