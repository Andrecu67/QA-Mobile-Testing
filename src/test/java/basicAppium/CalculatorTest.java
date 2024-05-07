package basicAppium;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTest {
    AppiumDriver phone;

    @BeforeEach
    public void openApp () throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Redmi Note 8");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.miui.calculator");
        capabilities.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","uiautomator2");

        phone = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        phone.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void closeApp (){
        phone.quit();
    }

    @Test
    public void verifyAddTwoNumber () throws InterruptedException {
        //click 5
        phone.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();

        //click +
        phone.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();

        //click 7
        phone.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();

        //click =
        phone.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();

        //Verification
        Thread.sleep(5000);
        String expectedResult = "= 12";
        String actualResult = phone.findElement(By.id("com.miui.calculator:id/result")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma es incorrecta");
    }
}
