package com.study.tests;

import com.study.base.StudyBaseClass;
import com.study.pages.CaseStudyLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends StudyBaseClass {

    CaseStudyLoginPage caseStudyLoginPage;
    String userName = prop.getProperty("userName");
    String passWd = prop.getProperty("passWd");

    @BeforeMethod
    public void setUp() {
        reportLog("======	Test Case Execution Started	======");
        initialization();
        caseStudyLoginPage = new CaseStudyLoginPage();
    }

    @Test
    public void login_Test() {
        caseStudyLoginPage.loginForCaseStudy(userName, passWd);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        reportLog("======	Test Case Execution Completed	======");
    }
}
