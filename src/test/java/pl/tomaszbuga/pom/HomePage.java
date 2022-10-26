package pl.tomaszbuga.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pl.tomaszbuga.framework.PageObject;


public class HomePage extends PageObject {



    @FindBy(name = "my-password")
    public WebElement searchInput;
    public String textToEnter = "password";


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        return this;
    }



    public HomePage enterText() {
        searchInput.sendKeys(textToEnter);
        return this;
    }

    public HomePage checkPassword() {
        String passwordInput = searchInput.getAttribute("value");
        Assert.assertEquals(textToEnter, passwordInput);
        System.out.println("value in the input and entered value are equals");
        return this;
    }
    public HomePage isEncrypted() {
        searchInput.getAttribute("type").equals("password");
        System.out.println("value in the input is encrypted");
        return this;
    }
}
