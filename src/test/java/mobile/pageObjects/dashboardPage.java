package mobile.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class dashboardPage {
    AndroidDriver driver;

    //construct android driver
    public void loginPage(AndroidDriver driver){
        this.driver = driver;
    }

    //mendaftarkan semua locator yang berada HANYA di login page
}
