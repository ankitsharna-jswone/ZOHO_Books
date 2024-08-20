package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utills.Functionalities.*;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void roleChangeTab(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='zselectbox__text']")));
        clickingTool(xpathELem("//span[@class='zselectbox__text']"));
    }

    public void selectZohoadminUser(){
        waitLocatedXpath("//span[text()='zohoadmin_jsw' and @class='zdropdownlist__text']");
        clickingTool(xpathELem("//span[text()='zohoadmin_jsw' and @class='zdropdownlist__text']"));
    }

    public void billingTab(){
        scrollBar(xpathELem("//div[@id='left-side-nav-bar']"));
        waitLocatedXpath("//a[@id='billing']");
        clickingTool(xpathELem("//a[@id='billing']"));
    }



}
