import Invoke.apk_invoke;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.CheckoutPage;
import pageObject.FormPage;
import pageObject.addProduct;
import utility.Scroll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class app_testing extends apk_invoke {

    public static void signIn(AndroidDriver<AndroidElement> driver) {

        FormPage formPage = new FormPage(driver);

        formPage.nameField.sendKeys("Subhidh Agarwal");
        driver.hideKeyboard();

        //Gender
        formPage.genderField.click();

        formPage.countryDropDown.click();

        //scroll and select country
        Scroll scroll = new Scroll(driver);
        scroll.scrollToText("Aruba");
        formPage.selectCountry.click();

        //click login
        formPage.shopButton.click();

        //detect toast message for any error
        /*String toastMessage = formPage.toastMessage.getAttribute("name");
        Assert.assertEquals("Please enter your name", toastMessage);*/

    }
    public static void addParticularProduct(AndroidDriver<AndroidElement> driver, String Product) {
        Scroll scroll = new Scroll(driver);
        scroll.scrollToProduct(Product);
        addProduct pro = new addProduct(driver);
        int count = pro.TotalProduct.size();

        for(int i=0;i<count;i++)
        {
            String text = pro.TotalProduct.get(i).getText();
            if(text.equalsIgnoreCase(Product))
            {
                pro.addToCartBtn.get(i).click();
                break;
            }
        }

        /*
        String lastPageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        System.out.println(lastPageText);
        //Assert.assertEquals("Jordan 6 Ring",lastPageText);*/
    }
    public static void validation(AndroidDriver<AndroidElement> driver) throws InterruptedException {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.cartBtn.click();
        Thread.sleep(2500);
        double total=0.0, price;
        List<AndroidElement> productPrice = checkoutPage.allPrice;
        for(AndroidElement text : productPrice) {

            price = Double.parseDouble(text.getText().substring(1));
            total += price;
        }
        //total = 1.0;
        double result =  Double.parseDouble(checkoutPage.totalAmount.getText().substring(2));
        Assert.assertEquals(total, result, 0.0);

        checkoutPage.checkBox.click();

        //TouchAction t = new TouchAction(driver);

        /*WebElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of condition']"));
        t.longPress(LongPressOptions.longPressOptions().withElement(element(terms)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.findElementById("android:id/button1").click();*/


        checkoutPage.proceedBtn.click();
    }
    public static void switchContext(AndroidDriver<AndroidElement> driver) throws InterruptedException {
        Thread.sleep(5000);
        Set<String> context = driver.getContextHandles();

        /*=for(String names : context)
            System.out.println(names);*/

        List<String> contextList = new ArrayList<>(context);
        System.out.println(contextList.get(1));
        driver.context(contextList.get(1));
        //driver.findElement(By.name("q")).sendKeys("Apple");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("apple");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context(contextList.get(0));
    }

    @BeforeTest
    public void startAppiumServer() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        service = startServer();
    }
    @Test
    public void totalTest() throws IOException, InterruptedException {


        AndroidDriver<AndroidElement> driver = capabilities("AppName");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signIn(driver);
        addParticularProduct(driver, "Jordan 6 Rings");
        addParticularProduct(driver, "Air Jordan 4 Retro");
        validation(driver);
        switchContext(driver);


    }
    @AfterTest
    public void stopAppiumServer()
    {
        service.stop();
    }
}

