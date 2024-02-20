package mobile.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class loginPage {
    AndroidDriver driver;

    //construct android driver
    public loginPage(AndroidDriver driver){
        this.driver = driver;
    }

    //mendaftarkan semua locator yang berada HANYA di login page
    By usernameField = By.xpath("");
    By passwordField = By.xpath("");
    By btnLogin = By.xpath("");
    By errorMsg = By.xpath("");

    //method or function to do the task
    public void inputUsername(String email){
        driver.findElement(usernameField).sendKeys(email);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickBtnLogin(){
        driver.findElement(btnLogin).click();
    }

}
