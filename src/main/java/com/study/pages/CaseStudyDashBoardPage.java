package com.study.pages;

import com.study.base.StudyBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseStudyDashBoardPage extends StudyBaseClass {
    @FindBy(xpath = "//a[@class='StudyTitle link']")
    WebElement exampleStudyLink;

    public CaseStudyDashBoardPage() {
        PageFactory.initElements(driver, this);
        reportLog(" === You are in CaseStudyDashBoardPage ===");
        reportLog("Initialised CaseStudy Dash Board Elements...");
    }

    public CaseStudyReportsPage selectExampleStudy() {
        clickUsingJs(exampleStudyLink);
        reportLog("Example Study is selected from Case Study Dashboard...");
        return new CaseStudyReportsPage();
    }
}
