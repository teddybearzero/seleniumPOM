import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class JUnitTest {

    WebDriver driver;
    String webURL = "http://www.google.com";

    @Before
    public void setUp(){
        System.out.println("Initialise the Driver");
        driver = utilities.DriverFactory.open("Chrome");
    }

    @After
    public void teardown(){
        System.out.println("Close driver");
        driver.close();
    }

    @Test
    public void _01_pageTitleTest(){

        System.out.println("Running the test\n");
        driver.get(webURL);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(expectedTitle, actualTitle);

    }
}
