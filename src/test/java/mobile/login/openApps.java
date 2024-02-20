package mobile.login;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class openApps {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;
    public static String baseUrl = "http://127.0.0.1:4723/wd/hub";

    @Test
    public void main() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid","RR8RB05RF5Z");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13");
        //use emolator
        capabilities.setCapability("app", System.getProperty("user.dir")+"/src/test/java/mobile/apk/app-release_HC.apk");
        capabilities.setCapability("autoGrantPermission", "true"); //set auto permission request setting
        capabilities.setCapability("autoAcceptAlerts", "true"); // set auto accept all possible appearing alert

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url,capabilities);
        //set timeout
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //get elements and input username
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
        //assert title
        driver.findElement(By.xpath("")).isEnabled();

        driver.close();

    }

}
