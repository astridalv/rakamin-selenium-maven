package kasirAja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void success_login_case() throws InterruptedException {
        WebDriver driver;
        String baseURL = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\'root\']/div/div/div/div[1]/h2")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");
        //input email
        driver.findElement(By.id("email")).sendKeys("admin@sel.com");
        //input password
        driver.findElement(By.id("password")).sendKeys("test321");
        //click login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //assert berhasil masuk dashboard
        String namaToko = driver.findElement(By.xpath("//dt[contains(text(), 'Sel Ventures')]")).getText();
        Assert.assertEquals(namaToko, "Sel Ventures");

        driver.quit();
    }
    @Test
    public void failed_login_case() throws InterruptedException {
        WebDriver driver;
        String baseURL = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\'root\']/div/div/div/div[1]/h2")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");
        //input email
        driver.findElement(By.id("email")).sendKeys("admin@sel.com");
        //input password
        driver.findElement(By.id("password")).sendKeys("test32155");
        //click login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //assert message error
        String errorMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorMsg, "Kredensial yang Anda berikan salah");

        driver.quit();
    }
}
