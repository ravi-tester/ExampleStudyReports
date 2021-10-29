package com.study.pages;

import com.study.base.StudyBaseClass;
import com.study.utils.StudyUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

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

    @FindBy(xpath = "//div[@class='data-entry-navigation']/div//div[@class='navigation-item-row']//td[1]")
    List<WebElement> primarySectionComponents;

    @FindBy(xpath = "//div[@class='data-entry-navigation']/div/div[contains(@class,'data-entry-step')]//div[@class='navigation-item-row']//td[1]")
    List<WebElement> primarySectionSubComponents;

    @FindBy(xpath = "//div[@id='dataEntryForm-step']//div[@class='form_row']//div[@class='left']/span[@class='castor-label castor-label-required']/span")
    List<WebElement> secondarySectionComponentsText;

    @FindBy(xpath = "//div[@id='dataEntryForm-step']//div[@class='form_row']//div[@class='right']/img[1]")
    List<WebElement> recordCogList;

    @FindBy(xpath = "//div[@id='dataEntryForm-step']//div[@class='right']/img")
    List<WebElement> recordCogListImages;

    @FindAll({@FindBy(xpath = "//div[@class='x-menu x-menu-floating x-layer']/ul/li[@class='x-menu-list-item ']//span"),
            @FindBy(xpath = "//div[@class='x-menu x-menu-floating x-layer']/ul/li[@class='x-menu-list-item']//span")})
    List<WebElement> recordCogMenuOptions;

    @FindBy(xpath = "//div[@role='rowgroup'][2]//button[@aria-label='Row-level actions']")
    List<WebElement> optionsOnExistingReports;

    @FindBy(xpath = "/descendant::span[@class='MenuItemLabel-sc-1uqtab6-0 iUBwCB'][7]")
    WebElement deleteOptionOnReports;

    @FindBy(xpath = "//div[@class='InputBox-sc-3dkitx-0 fTdXIO']/textarea")
    WebElement deleteReasonTextBox;

    @FindBy(xpath = "//footer[@class='DialogFooter-sc-1jmulth-0 kHBvig']//button[@class='StyledButton-sc-1rtnr17-0 UxzOM']")
    WebElement deleteRecordsButton;

    @FindBy(xpath = "//div[@class='x-column-inner']//input")
    List<WebElement> userMissingCogOptions_RadioButtons;

    @FindBy(xpath = "//div[@class='x-column-inner']//input")
    WebElement userMissingCogOptions_Comment;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Save')]")
    WebElement userMissingCogOptions_SaveButton;

    @FindBy(xpath = "//textarea[@name='commentText']")
    WebElement commentsMissingCogOptions_Comment;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Add comment')]")
    WebElement commentsCogOptions_SaveButton;

    @FindBy(xpath = "//td[@class='x-btn-mc'][contains(.,'Close')]")
    WebElement commentsCogOptions_CloseButton;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Close')]")
    WebElement historyCogOptions_CloseButton;

    @FindBy(xpath = "//textarea[@id='queryRemarkText']")
    WebElement queryCogOptions_Remarks;

    @FindBy(xpath = "//td[@class='x-btn-mc'][contains(.,'Update')]")
    WebElement queryCogOptions_UpdateButton;

    @FindBy(xpath = "//td[@class='x-btn-mc'][contains(.,'Close')]")
    WebElement queryCogOptions_CloseButton;

    @FindBy(xpath = "//table[@id='psn-submit-btn']//button[@class=' x-btn-text']")
    WebElement SDVCogOptions_ContinueButton;


    public CaseStudyReportsPage() {
        PageFactory.initElements(driver, this);
        reportLog(" === You are in CaseStudyReportsPage ===");
        reportLog("Initialised CaseStudy Reports Page Elements...");
    }

    public void selectNewRecord() {
        clickUsingJs(newReportStudyButton);
        reportLog("Selected New Report from Case Study Dashboard...");
    }

    public void selectAllExistingRecords() {
        selectAllExistingReportsCheckBox.click();
        reportLog("Selected All Existing Reports from Records Dashboard...");
    }

    public void createNewReportRecord() {
        String email = StudyUtils.generateRandomEmailAddress();
        clickUsingJs(createNewRecordEmailAddress);
        reportLog("Clicked on Email Address");
        waitForElement(createNewRecordEmailAddress);
        createNewRecordEmailAddress.sendKeys(email);
        reportLog("New Report is created with user : " + email);
        clickUsingJs(newRecordCreateButton);
        reportLog("New record Created...");
        waitForElement(recordProgressText);
        Assert.assertEquals(recordProgressText.getText(), "Progress:");
        reportLog("User landed in new reports - Consent page");
    }

    public void deleteSomeRecords() {
        for (int i = 0; i < (optionsOnExistingReports.size() - 1); i++) {
            waitForElement(optionsOnExistingReports.get(i));
            optionsOnExistingReports.get(i).click();
            deleteOptionOnReports.click();
            driver.switchTo().activeElement();
            waitForElement(deleteReasonTextBox);
            clickUsingJs(deleteReasonTextBox);
            deleteReasonTextBox.sendKeys("Testing Purpose");
            deleteRecordsButton.click();
        }
    }

    public void clickOnGivenSectionCogIcon(String primarySection, String primarySubSection, String subSection, String cogOption) {
        for (int i = 0; i < primarySectionComponents.size(); i++) {
            if (primarySectionComponents.get(i).getText().contains(primarySection) && (primarySection != "")) {
                scrollElementIntoView(primarySectionComponents.get(i));
                primarySectionComponents.get(i).click();
                reportLog("Primary Component Selected is - " + primarySectionComponents.get(i).getText());
                break;
            }
        }
        for (int i = 0; i < primarySectionSubComponents.size(); i++) {
            if (primarySectionSubComponents.get(i).getText().contains(primarySubSection) && (primarySubSection != "")) {
                scrollElementIntoView(primarySectionSubComponents.get(i));
                primarySectionSubComponents.get(i).click();
                reportLog("Primary Sub Component Selected is - " + primarySectionSubComponents.get(i).getText());
                break;
            }
        }
        for (int i = 0; i < secondarySectionComponentsText.size(); i++) {
            if (secondarySectionComponentsText.get(i).getText().contains(subSection) && (subSection != "")) {
                scrollElementIntoView(secondarySectionComponentsText.get(i));
                secondarySectionComponentsText.get(i).click();
                reportLog("Secondary Component Selected is - " + secondarySectionComponentsText.get(i).getText());
                recordCogList.get(i).click();
                waitForElement(recordCogMenuOptions.get(i));
                reportLog("Cog of given Primary Component and  Secondary Component... ");
                break;
            }
        }
        for (int j = 0; j < recordCogMenuOptions.size(); j++) {
            reportLog("Avaialble Option : " + j + " : in Cog is :" + recordCogMenuOptions.get(j).getText());

        }

        for (int i = 0; i < recordCogMenuOptions.size(); i++) {
            String presentcogOptionValue = recordCogMenuOptions.get(i).getText();
            reportLog("presentcogOptionValue is : " + presentcogOptionValue + " and Expected is :" + cogOption);
            if (presentcogOptionValue.equalsIgnoreCase(cogOption)) {
                switch (cogOption) {
                    case "Clear":
                        recordCogMenuOptions.get(i).click();
                        reportLog(presentcogOptionValue + " Cog Option Clicked...");
                        break;
                    case "User missing":
                        recordCogMenuOptions.get(i).click();
                        reportLog(presentcogOptionValue + " Cog Option Clicked...");
                        selectOption(userMissingCogOptions_RadioButtons, 1);
                        reportLog("User missing : Radio button selected...");
                        userMissingCogOptions_Comment.sendKeys("Some reason");
                        reportLog("User missing : Comments Entered...");
                        userMissingCogOptions_SaveButton.click();
                        reportLog("User missing : Save button Clicked...");
                        String title = recordCogListImages.get(i).getAttribute("title");
                        reportLog("Options Updated After operation : " + i + " : in Cog is :" + title);
                        break;
                    case "Comments":
                        recordCogMenuOptions.get(i).click();
                        reportLog(presentcogOptionValue + " Cog Option Clicked...");
                        commentsMissingCogOptions_Comment.sendKeys("Some Comments for Comments");
                        reportLog("Comments : Comments Entered...");
                        commentsCogOptions_SaveButton.click();
                        reportLog("Comments : Save button Clicked...");
                        commentsCogOptions_CloseButton.click();
                        reportLog("Comments : Close button Clicked...");
                        break;
                    case "History":
                        recordCogMenuOptions.get(i).click();
                        reportLog(presentcogOptionValue + " Cog Option Clicked...");
                        historyCogOptions_CloseButton.click();
                        reportLog("History : Close button Clicked...");
                        break;
                    case "Queries":
                        recordCogMenuOptions.get(i).click();
                        reportLog(presentcogOptionValue + " Cog Option Clicked...");
                        queryCogOptions_Remarks.sendKeys("Quries Added");
                        reportLog("Queries : Queries Comment added...");
                        queryCogOptions_UpdateButton.click();
                        reportLog("Queries : Update button Clicked...");
                        break;
                    case "SDV field":
                        recordCogMenuOptions.get(i).click();
                        reportLog(presentcogOptionValue + " Cog Option Clicked...");
                        SDVCogOptions_ContinueButton.click();
                        reportLog("SDV field : Continue button Clicked...");
                        break;
                    default:
                        reportLog("Your Cog Option is not present in List. Nothing is clicked.");
                }
            }
        }
    }
}