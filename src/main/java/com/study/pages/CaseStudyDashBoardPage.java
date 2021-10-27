package com.study.pages;

import com.study.base.StudyBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseStudyDashBoardPage extends StudyBaseClass {
    @FindBy(xpath = "//input[@class='search-input']")
    WebElement exampleStudyLink;

    public CaseStudyDashBoardPage() {
        PageFactory.initElements(driver, this);
        reportLog(" === You are in CaseStudyDashBoardPage ===");
        reportLog("Initialised CaseStudy Dash Board Elements...");
    }

    public CaseStudyReportsPage selectExampleStudy() {
        exampleStudyLink.click();
        reportLog("Example Study is selected from Case Study Dashboard...");
        return new CaseStudyReportsPage();
    }
}
