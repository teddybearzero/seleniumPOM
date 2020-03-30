import utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

    public static void main(String[] args) {

        String name = "Mary Smith";
        String email = "mary@home.com";
        String password = "mpass";
        String gender = "female";
        String country = "United States";
        String phoneNumber = "123456678";
        boolean weeklyEmail = true;
        boolean monthlyEmail = false;
        boolean occasionalEmail = false;
        String browserType = "Chrome";

        WebDriver driver;
        driver = DriverFactory.open(browserType);

        // Open Browser to Account Management Page
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Click create account
        driver.findElement(By.linkText("Create Account")).click();

        // Define WebElements
        WebElement firstNameElement = driver.findElement(By.id("MainContent_txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']]"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
        WebElement verifyPassword = driver.findElement((By.name("ctl00$MainContent$txtVerifyPassword")));
        WebElement femaleRadioButton = driver.findElement(By.id("MainContent_Female"));
        WebElement maleRadioButton = driver.findElement(By.id("MainContent_Male"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement weeklyCheckBox = driver.findElement(By.name("MainContent_checkWeeklyEmail"));
        WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));

        // Fill out form
        firstNameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifyPassword.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        // Gender radio button selection
        if (gender.equalsIgnoreCase("Female")) {

            // using css Selector
            femaleRadioButton.click();
            //driver.findElement(By.cssSelector("input['ctl00$MainContent$Gender'][value='Female']")).click();
        } else {
            maleRadioButton.click();
        }

        if (weeklyEmail) {
            if (!weeklyCheckBox.isSelected()) {
                weeklyCheckBox.click();
            }
        } else {
            if (weeklyCheckBox.isSelected()) {
                weeklyCheckBox.click();
            }
        }

        //click submit button
        submitButton.click();

        // get confirmation and close browser
        String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println(("Confirmation " + confirmation));
        driver.close();
    }
}
