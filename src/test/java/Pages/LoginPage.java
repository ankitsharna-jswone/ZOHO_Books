package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utills.Functionalities.*;
import static org.openqa.selenium.By.xpath;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void signinButton(){
        waitLocatedXpath("//a[@class='zlogin-apps']");
        clickingTool(xpathELem("//a[@class='zlogin-apps']"));
    }

    public void usernameEnter(String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id ='login_id']")));
        xpathELem("//input[@id ='login_id']").sendKeys(username);
    }

    public void nextButton(){
        waitLocatedXpath("//button[@id ='nextbtn']");
        clickingTool(xpathELem("//button[@id ='nextbtn']"));
    }


    public void passwordEnter(String password){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
        xpathELem("//input[@id='password']").sendKeys(password);
    }

    public void signInClick(){
        waitLocatedXpath("//button[@id='nextbtn']");
        clickingTool(xpathELem("//button[@id='nextbtn']"));
    }



}
