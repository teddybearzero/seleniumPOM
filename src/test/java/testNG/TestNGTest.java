package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGTest {

    WebDriver driver;
    String webURL = "http://www.google.com";

    @BeforeClass
    public void setUp(){

        System.out.println("Initialising Driver");
        driver = utilities.DriverFactory.open("Chrome");
        driver.get(webURL);
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Close driver");
        driver.close();
    }

    @Test
    public void test_(){
        System.out.println("Running the test\n");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
