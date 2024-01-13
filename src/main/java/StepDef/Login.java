package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;

    @Given("open web url {string}")
    public void open_web_url(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @And("Input username {string} and password {string}")
    public void input_username_and_password(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @When("Click login button")
    public void click_login_button() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("Should success and redirected to homepage")
    public void should_success_and_redirected_to_homepage() {
        Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
        driver.close();
        driver.quit();
    }

    @Then("Should showing error message")
    public void shouldShowingErrorMessage() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed());
        driver.close();
        driver.quit();
    }
}
