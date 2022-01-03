package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

    @AndroidFindBy(xpath = "//*[@text='Male']")
    public WebElement genderField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    public WebElement countryDropDown;

    @AndroidFindBy(xpath = "//*[@text='Aruba']")
    public WebElement selectCountry;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement shopButton;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public WebElement toastMessage;

}


/*driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Subhidh Agarwal");
        driver.hideKeyboard();

        //Gender
        driver.findElement(By.xpath("//*[@text='Male']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

        //scroll and select country
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"))");
        driver.findElement(By.xpath("//*[@text='Aruba']")).click();

        //click login
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();*/

//detect toast message for any error
//String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//Assert.assertEquals("Please enter your name", toastMessage);