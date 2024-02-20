package mobile.login;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import page object
import mobile.pageObjects.loginPage;
import mobile.pageObjects.dashboardPage;

public class loginPOM {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;
    public static String baseUrl = "http://127.0.0.1:4723/wd/hub";

    @Test
    public void login_success() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", "RR8RB05RF5Z");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13");
        //use emolator
        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/java/mobile/apk/app-release_HC.apk");
        capabilities.setCapability("autoGrantPermission", "true"); //set auto permission request setting
        capabilities.setCapability("autoAcceptAlerts", "true"); // set auto accept all possible appearing alert

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url, capabilities);
        //set timeout
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        loginPage loginPage = new loginPage(driver);
        dashboardPage dashboardPage = new dashboardPage(driver);

        //get elements and input username
        loginPage.inputUsername("email@gmail.com");
        loginPage.inputPassword("inipassword");
        loginPage.clickBtnLogin();
        //assert title

        driver.close();
    }

    @Test
    public void failed_login() throws MalformedURLException{
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", "RR8RB05RF5Z");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13");
        //use emolator
        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/java/mobile/apk/app-release_HC.apk");
        capabilities.setCapability("autoGrantPermission", "true"); //set auto permission request setting
        capabilities.setCapability("autoAcceptAlerts", "true"); // set auto accept all possible appearing alert

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url, capabilities);
        //set timeout
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        loginPage loginPage = new loginPage(driver);
        dashboardPage dashboardPage = new dashboardPage(driver);

        //get elements and input username
        loginPage.inputUsername("email@gmail.com");
        loginPage.inputPassword("inipasswordsalah");
        loginPage.clickBtnLogin();
        //assert error message dashboardpage object

        driver.close();
    }
}
