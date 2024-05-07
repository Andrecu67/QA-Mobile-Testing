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

public class WhenDoTest {
    AppiumDriver phone;

    @BeforeEach
    public void openApp () throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","QAV1_Android9");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","uiautomator2");

        phone = new AppiumDriver(new URL("http://192.168.31.237:4723/wd/hub"),capabilities);
        phone.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void closeApp (){
        phone.quit();
    }

    @Test
    public void verifyCreateTask () throws InterruptedException {
        //Click + com.vrproductiveapps.whendo:id/fab
        phone.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();

        //Set titulo  com.vrproductiveapps.whendo:id/noteTextTitle
        String tituloTarea = "EjemploTest";
        phone.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(tituloTarea);

        //Set descripcion com.vrproductiveapps.whendo:id/noteTextNotes
        phone.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Este es el 1er ejemplo con IJ");

        //Click save button com.vrproductiveapps.whendo:id/saveItem
        phone.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

        //Verificacion //android.widget.TextView[@text="Andrea"]
        Assertions.assertTrue(phone.findElements(By.xpath("//android.widget.TextView[@text='"+tituloTarea+"']")).size()>=1,
                "ERROR no se creo la tarea");

    }
}
