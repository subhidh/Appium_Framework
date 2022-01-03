package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class CheckoutPage {
    public CheckoutPage(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement cartBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    public List<AndroidElement> allPrice;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement totalAmount;

    @AndroidFindBy(className = "android.widget.CheckBox")
    public WebElement checkBox;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    public WebElement proceedBtn;
}

        /* driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2500);
        double total=0.0, price;
        List<AndroidElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        for(AndroidElement text : productPrice) {

            price = Double.parseDouble(text.getText().substring(1));
            total += price;
        }
        //total = 1.0;
        double result =  Double.parseDouble(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText().substring(2));
        Assert.assertEquals(total, result, 0.0);

        driver.findElementByClassName("android.widget.CheckBox").click();

        TouchAction t = new TouchAction(driver);

        WebElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of condition']"));
        t.longPress(LongPressOptions.longPressOptions().withElement(element(terms)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click(); */