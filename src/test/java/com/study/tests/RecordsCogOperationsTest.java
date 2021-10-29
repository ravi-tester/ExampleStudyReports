package com.study.tests;

import com.study.base.StudyBaseClass;
import com.study.pages.CaseStudyDashBoardPage;
import com.study.pages.CaseStudyLoginPage;
import com.study.pages.CaseStudyReportsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RecordsCogOperationsTest extends StudyBaseClass {

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
    public void deleteExistingReports() {
        caseStudyDashBoardPage = caseStudyLoginPage.loginForCaseStudy(userName, passWd);
        caseStudyDashBoardPage.selectExampleStudy();
        caseStudyReportsPage.deleteSomeRecords();
    }

    @Test
    public void createNewRecordAndDoGivenCogOperationsTest() {
        caseStudyDashBoardPage = caseStudyLoginPage.loginForCaseStudy(userName, passWd);
        caseStudyDashBoardPage.selectExampleStudy();
        caseStudyReportsPage.selectNewRecord();
        caseStudyReportsPage.createNewReportRecord();
//        caseStudyReportsPage.clickOnGivenSectionCogIcon("", "Consent", "Date of informed consent", "Clear");
        caseStudyReportsPage.clickOnGivenSectionCogIcon("Baseline", "Physical exam", "Body weight", "User missing");
//        caseStudyReportsPage.clickOnGivenSectionCogIcon("Follow-up Visit", "Physical exam", "Body weight", "SDV field");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        reportLog("======	Test Case Execution Completed	======");
    }
}
