package utility;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scroll {
    AndroidDriver<AndroidElement> driver;
    public Scroll(AndroidDriver<AndroidElement> driver)
    {
        this.driver = driver;
    }

    public void scrollToText(String text)
    {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
    }

    public void scrollToProduct(String Product)
    {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId" +
                "(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""+Product+"\").instance(0))"));
    }
}
