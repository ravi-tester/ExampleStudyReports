package com.study.tests;

import com.study.base.StudyBaseClass;
import com.study.pages.CaseStudyDashBoardPage;
import com.study.pages.CaseStudyLoginPage;
import com.study.pages.CaseStudyReportsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CogTest extends StudyBaseClass {

    CaseStudyLoginPage caseStudyLoginPage;
    CaseStudyDashBoardPage caseStudyDashBoardPage;
    CaseStudyReportsPage caseStudyReportsPage;
    String userName = prop.getProperty("userName");
    String passWd = prop.getProperty("passWd");

    @BeforeMethod
    public void setUp() {
        reportLog("======	Test Case Execution Started	======");
        initialization();
        caseStudyLoginPage = new CaseStudyLoginPage();
        caseStudyDashBoardPage = new CaseStudyDashBoardPage();
        caseStudyReportsPage = new CaseStudyReportsPage();
    }

    @Test
    public void cogTest_Reports() {
        caseStudyLoginPage.loginForCaseStudy(userName, passWd);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        reportLog("======	Test Case Execution Completed	======");
    }
}
