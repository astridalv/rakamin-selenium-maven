package kasirAja.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {

    WebDriver driver;
    String baseUrl ="https://kasirdemo.belajarqa.com/";
    @Given("Halaman login kasir aja")
    public void halaman_login_kasir_aja(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //assertion
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(), 'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");

    }

    @When("input username")
    public void inputUsername() {
        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");
        throw new io.cucumber.java.PendingException();
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("tdd-selenium");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("User on dashboard page")
    public void userOnDashboardPage() {
        driver.findElement(By.xpath("//div[contains(text(), 'dashboard')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(), 'hai')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username, "tdd-selenium");
        driver.close();
    }

    @And("Input invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("test32155");

    }

    @Then("User Get Error Message")
    public void userGetErrorMessage() {
        String errorMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorMsg, "Kredensial yang Anda berikan salah");
        driver.close();
    }
}
