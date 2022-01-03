package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class addProduct {
    public addProduct(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    public List<WebElement> TotalProduct;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    public List<WebElement> addToCartBtn;
}
/*driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId" +
        "(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""+Product+"\").instance(0))"));

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i=0;i<count;i++)
        {
        String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        if(text.equalsIgnoreCase(Product))
        {
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        break;
        }
        }*/