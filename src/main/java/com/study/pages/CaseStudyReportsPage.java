package com.study.pages;

import com.study.base.StudyBaseClass;
import com.study.utils.StudyUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CaseStudyReportsPage extends StudyBaseClass {

    @FindBy(xpath = "//span[contains(.,'New')]")
    WebElement newReportStudyButton;

    @FindBy(xpath = "//input[@title='Toggle All Rows Selected']")
    WebElement selectAllExistingReportsCheckBox;

    @FindBy(xpath = "//footer[@class='DialogFooter-sc-1jmulth-0 kHBvig']//button[@class='StyledButton-sc-1rtnr17-0 UxzOM']")
    WebElement newRecordCreateButton;

    @FindBy(xpath = "//div[@class='InputBox-sc-3dkitx-0 fTdXIO']/input")
    WebElement createNewRecordEmailAddress;

    @FindBy(xpath = "//div[@class='data-entry-progress']//span")
    WebElement recordProgressText;

    @FindBy(xpath = "//div[@id='manageCrfCenter']//div[@id='dataEntryCenter']//div[@id='dataEntryForm-step']//div[@class='form_row']//div[@class='right']")
    WebElement recordCogList;


    public CaseStudyReportsPage() {
        PageFactory.initElements(driver, this);
        reportLog(" === You are in CaseStudyReportsPage ===");
        reportLog("Initialised CaseStudy Reports Page Elements...");
    }

    public void selectNewReport() {
        clickUsingJs(newReportStudyButton);
        reportLog("Selected New Report from Case Study Dashboard...");
    }

    public void selectAllExistingReport() {
        selectAllExistingReportsCheckBox.click();
        reportLog("Selected All Existing Reports from Reports Dashboard...");
    }

    public void createNewReportRecord() {
        String email = StudyUtils.generateRandomEmailAddress();
        clickUsingJs(createNewRecordEmailAddress);
        waitForElement(createNewRecordEmailAddress);
        createNewRecordEmailAddress.sendKeys(email);
        reportLog("New Report is created with user : "+email);
        clickUsingJs(newRecordCreateButton);
        reportLog("New record Created...");
        Assert.assertEquals(recordProgressText.getText(),"Progress:");
        reportLog("User landed in new reports - Consent page");
    }
}
