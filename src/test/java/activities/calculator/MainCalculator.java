package activities.calculator;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainCalculator {
    public Button fiveButton = new Button(By.id("com.miui.calculator:id/btn_5_s"));
    public Button sevenButton = new Button(By.id("com.miui.calculator:id/btn_7_s"));
    public Button addButton = new Button(By.id("com.miui.calculator:id/btn_plus_s"));
    public Button equalButton = new Button(By.id("com.miui.calculator:id/btn_equal_s"));

    public Label resultLabel = new Label(By.id("com.miui.calculator:id/result"));
}
