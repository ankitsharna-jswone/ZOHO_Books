package Script;

import Pages.BillingPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utills.Functionalities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Properties;



public class runner {
    WebDriver driver;

    String link;
    Properties properties = new Properties();
    LoginPage loginPage;
    Functionalities functionalities;
    HomePage homePage;
    BillingPage billingPage;

    @BeforeTest
    public void setup(){

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this);





        link = "https://creator.zoho.in/userhome/zohoadmin_jsw/admindashboard#/billing";

        driver.get(link);

        //wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        functionalities = new Functionalities(driver);
        loginPage = new LoginPage(driver);
        homePage =  new HomePage(driver);
        billingPage = new BillingPage(driver);

    }

    @Test(priority = 1)
    public void loginPage() throws InterruptedException {
        loginPage.signinButton();
        loginPage.usernameEnter("subhankar.ray@jsw.in");
        loginPage.nextButton();
        loginPage.passwordEnter("zohointegration");
        loginPage.signInClick();

        Thread.sleep(10000);
        Set<Cookie> cookies = driver.manage().getCookies();
        saveCookiesToJson(cookies);

    }

    private void saveCookiesToJson(Set<Cookie> cookies) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("cookies.json")) {
            writer.write(gson.toJson(cookies));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCookies() {
        try (FileReader reader = new FileReader("cookies.json")) {
            Gson gson = new Gson();
            Set<Cookie> cookies = gson.fromJson(reader, new TypeToken<Set<Cookie>>(){}.getType());

            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2)
    public void homePage(){
        homePage.roleChangeTab();
        System.out.println("clickhappend");
        homePage.selectZohoadminUser();
        homePage.billingTab();

    }

    @Test(priority = 3)
    public void billingPage() throws InterruptedException {
        Thread.sleep(3000);

        billingPage.customAPIblock();
        billingPage.customApiVal();
        System.out.println(billingPage.values() + " value is");
        billingPage.listOfValues();

    }
}
