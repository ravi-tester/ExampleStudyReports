package com.study.pages;

import com.study.base.StudyBaseClass;
import com.study.utils.StudyUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

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

    @FindBy(xpath = "//div[@class=' css-1ym6uuo-container']//div[@class=' css-1wkkm92']//div[@class=' css-1wazpb5-indicatorContainer']")
    WebElement instituteSelection;

//    @FindBy(xpath = "//div[@class=' css-1ym6uuo-container']//div[@class=' css-1abkzx2-singleValue']")
@FindBy(xpath = "//div[@class=' css-1qzvyu0-control']//div[@class='css-shyno6']//input")
//@FindBy(xpath = "//div[@class=' css-1ym6uuo-container']//div[@class=' css-1wkkm92']//div[@class=' css-1rurbkc-indicatorContainer']")
    WebElement instituteSelectionNew;



    //    @FindAll({
//    @FindBy(xpath = "//div[@id='dataEntryForm-step']//div[@class='form_row']//div[@class='left']/span[@class='castor-label castor-label-required']/span"),
//    @FindBy(xpath = "//div[@id='dataEntryForm-step']//div[@class='form_row']//div[@class='left']/span[@class='castor-label ']/span")})
    @FindBy(xpath = "//div[@id='dataEntryForm-step']//div[@class='form_row']//div[@class='left']/span[contains(@class,'castor-label ')]/span")
    List<WebElement> secondarySectionComponentsText;


    @FindBy(xpath = "//div[@id='dataEntryForm-step']//div[@class='form_row']//div[@class='right']/img[@title='Settings']")
    List<WebElement> recordCogList;


    @FindBy(xpath = "//div[@class=' form_row x-item-disabled form-row-disabled']/div[@class='castor-field   ']//div[@class='right']/img[@title='Settings']")
    List<WebElement> recordCogListAfterUpdate;


    @FindBy(xpath = "//div[@id='dataEntryForm-step']//div[@class='right']/img")
    List<WebElement> recordCogListImages;


    //    @FindAll({@FindBy(xpath = "//div[@class='x-menu x-menu-floating x-layer']/ul/li[@class='x-menu-list-item ']//span"),
//    @FindBy(xpath = "//div[@class='x-menu x-menu-floating x-layer']/ul/li[@class='x-menu-list-item']//span")})
    @FindBy(xpath = "//div[@class='x-menu x-menu-floating x-layer']/ul/li[not(contains(@class,'x-menu-list-item  x-hide-display'))]//span")
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

    @FindBy(xpath = "//div[@id='x-form-el-userMissingCommentText']/textarea[@id='userMissingCommentText']")
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

    int tmp1,tmp2,tmp3;

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

    public void createNewReportRecord(String institudeName) {
//        instituteSelection.click();
//        instituteSelection.click();
//        driver.switchTo().activeElement();
//        waitForElement(instituteSelectionNew);
//        instituteSelectionNew.click();
//        instituteSelectionNew.sendKeys(Keys.ARROW_DOWN);
//        instituteSelectionNew.sendKeys(Keys.ENTER);
//        waitForElement(instituteSelectionNew);
//        instituteSelectionNew.click();
//        instituteSelection.clear();
//        instituteSelectionNew.sendKeys(institudeName);
//        Reporter.log("Institute select as : "+institudeName);
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
        int optionsOnExistingReportsSize=optionsOnExistingReports.size();
//        int totalRecordssize = optionsOnExistingReports.size();
        reportLog("Total Records Available :" + optionsOnExistingReportsSize);
        for (int i = 0; i < (optionsOnExistingReportsSize - 2); i++) {
            waitForElement(optionsOnExistingReports.get(i));
            optionsOnExistingReports.get(i).click();
            waitForElement(deleteOptionOnReports);
            deleteOptionOnReports.click();
            driver.switchTo().activeElement();
            waitForElement(deleteReasonTextBox);
            clickUsingJs(deleteReasonTextBox);
            deleteReasonTextBox.sendKeys("Testing Purpose");
            waitForElement(deleteRecordsButton);
            deleteRecordsButton.click();
            reportLog("Deleted Reccord : " + i + " Successfully");
        }
    }

    public void clickOnGivenSectionCogIcon(String primarySection, String primarySubSection, String subSection, String cogOption,String cogOperation) {
        reportLog("primarySection : "+primarySection);
        reportLog("primarySubSection : "+primarySubSection);
        reportLog("subSection : "+subSection);
        reportLog("cogOperation : "+cogOperation);
        int primarySectionComponentsSize=primarySectionComponents.size();
        tmp1=primarySectionComponentsSize;
        int primarySectionSubComponentsSize=primarySectionSubComponents.size();
        tmp2=primarySectionSubComponentsSize;
        int secondarySectionComponentsTextSize=secondarySectionComponentsText.size();
        tmp3=secondarySectionComponentsTextSize;
//        int recordCogListSize=recordCogList.size();
//        int recordCogListAfterUpdateSize=recordCogListAfterUpdate.size();
//        int recordCogListImagesSize=recordCogListImages.size();
//        int recordCogMenuOptionsSize=recordCogMenuOptions.size();
        for (int i = 0; i < primarySectionComponentsSize; i++) {
            if (primarySectionComponents.get(i).getText().contains(primarySection) && (primarySection != "")) {
                scrollElementIntoView(primarySectionComponents.get(i));
                primarySectionComponents.get(i).click();
                reportLog("Primary Component Selected is - " + primarySectionComponents.get(i).getText());
            }
            primarySectionComponentsSize =tmp1;
            break;
        }
        for (int i = 0; i < primarySectionSubComponentsSize; i++) {
            if (primarySectionSubComponents.get(i).getText().contains(primarySubSection) && (primarySubSection != "")) {
                scrollElementIntoView(primarySectionSubComponents.get(i));
                primarySectionSubComponents.get(i).click();
                reportLog("Primary Sub Component Selected is - " + primarySectionSubComponents.get(i).getText());
            }
            primarySectionSubComponentsSize=tmp2;
            break;
        }
        for (int i = 0; i < secondarySectionComponentsTextSize; i++) {
            waitForElement(secondarySectionComponentsText.get(i));
//            String secondarySubSectionText = secondarySectionComponentsText.get(i).getText();
            if ((secondarySectionComponentsText.get(i).getText().contains(subSection)) && ((subSection != ""))) {
//                scrollElementIntoView(secondarySectionComponentsText.get(i));
//                secondarySectionComponentsText.get(i).click();
                reportLog("Secondary Component Selected is - " + secondarySectionComponentsText.get(i).getText());
                if(cogOperation!="1"){
                    reportLog("Settings : Clicked 2nd time");
                    waitForElement(recordCogListAfterUpdate.get(i));
                    recordCogListAfterUpdate.get(i).click();
                }else{
                    waitForElement(recordCogList.get(i));
                    recordCogList.get(i).click();
                    reportLog("Settings : Clicked Fresh and 1st time");
                }
                waitForElement(recordCogMenuOptions.get(i));
                reportLog("Cog of given Primary Component and  Secondary Component... ");
            }
            secondarySectionComponentsTextSize=tmp3;
            break;
        }
//        for (int j = 0; j < recordCogMenuOptions.size(); j++) {
//            reportLog("Avaialble Option : " + j + " : in Cog is :" + recordCogMenuOptions.get(j).getText());
//
//        }

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
                break;
            }
        }
    }
}