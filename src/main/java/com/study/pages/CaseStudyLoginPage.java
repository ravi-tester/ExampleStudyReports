package com.study.pages;

import com.study.base.StudyBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseStudyLoginPage extends StudyBaseClass {
    @FindBy(xpath = "//input[@id='field-username']")
    WebElement emailTextBox;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//span[contains(.,'Log in')]")
    WebElement loginButton;


    public CaseStudyLoginPage() {
        PageFactory.initElements(driver, this);
        reportLog(" === You are in CaseStudyLoginPage ===");
        reportLog("Initialised CaseStudy Login Page Elements...");
    }

    public CaseStudyDashBoardPage loginForCaseStudy(String userName, String pwd) {
        emailTextBox.click();
        emailTextBox.clear();
        emailTextBox.sendKeys(userName);
        reportLog("User " + userName + " Trying to login...");
        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys(pwd);
        loginButton.click();
        reportLog("Logging into application now, please wait...");
        return new CaseStudyDashBoardPage();
    }
}
