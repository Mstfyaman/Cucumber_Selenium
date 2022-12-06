package com.krafttech.pages;

import com.krafttech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages extends BasePage{


//    public LoginPages() {
//        PageFactory.initElements(Driver.get(),this);
//    }

    @FindBy(name = "email")
    public WebElement userEmailInput_loc;

    @FindBy(name = "password")
    public WebElement passwordInput_loc;

    @FindBy(xpath = "//button[@class=\"btn btn-primary w-100\"]")
    public WebElement loginButton_loc;

    @FindBy(xpath = "//*[contains(text(),'Email address or password is incorrect. Please check')]")
    public WebElement warningMessage_loc;

    public void loginUser(){
        String username= ConfigurationReader.get("userEmail");
        String password= ConfigurationReader.get("password");

        userEmailInput_loc.sendKeys(username);
        passwordInput_loc.sendKeys(password);
        loginButton_loc.click();
    }


    public void loginWithParameter (String email, String password){


        userEmailInput_loc.sendKeys(email);
        passwordInput_loc.sendKeys(password);
        loginButton_loc.click();
    }



}
