package com.study.pages;

import com.study.base.StudyBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseStudyReportsPage extends StudyBaseClass {

    @FindBy(xpath = "//span[contains(.,'New')]")
    WebElement newReportStudyButton;

    public CaseStudyReportsPage() {
        PageFactory.initElements(driver, this);
        reportLog(" === You are in CaseStudyReportsPage ===");
        reportLog("Initialised CaseStudy Reports Page Elements...");
    }

    public void selectNewReport() {
        newReportStudyButton.click();
        reportLog("Selected New Report from Case Study Dashboard...");
    }
}
