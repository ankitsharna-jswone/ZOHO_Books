package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Setup {
    WebDriver driver;

    public Setup(WebDriver Webdriver){
        this.driver = Webdriver;
    }

    public void browserSetup(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", prefs);

//        options.setCapability("goog:loggingPrefs", "{\"browser\": \"ALL\"}");
//        options.setCapability("goog:loggingPrefs", "{browser: ALL}");

        driver = new ChromeDriver(options);
//        setConsoleReader(driver);
        driver.manage().window().maximize();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this);
        driver.get("https://creator.zoho.in/userhome/zohoadmin_jsw/admindashboard#/billing");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }



}
