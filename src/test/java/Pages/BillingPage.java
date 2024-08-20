package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static Utills.Functionalities.*;

public class BillingPage {
    WebDriver driver;

    String text;

    public BillingPage(WebDriver driver){
        this.driver = driver;
    }

    public void customAPIblock(){
        ActionScroll(xpathELem("//div[@class='zc-billing-application-usage-content-wrapper']"));
    }
    public void customApiVal(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//usage-banner-card[@proptitle=\"Custom API's\"]//small")));
        text =  xpathELem("//usage-banner-card[@proptitle=\"Custom API's\"]//small").getText();
    }

    public String values(){
        return xpathELem("//div[@class='zc-page-header-title zc-float-left']/h5").getText();
//        return xpathELem("//usage-banner-card[@proptitle=\"Custom API's\"]//h6").getText();
    }

    public List<String> listOfValues (){
        WebElement application = xpathELem("//div[@class='zc-billing-application-usage-content-wrapper']");
        return listOfText(application.findElements(By.xpath("//small")));
    }

    public List<String> listOfText(List<WebElement> elements){
        List<String> vals = new ArrayList<>();
        for(WebElement element : elements){
            vals.add(element.getText());
            System.out.println(element.getText() + " all vals");
        }

        return vals;
    }

}
