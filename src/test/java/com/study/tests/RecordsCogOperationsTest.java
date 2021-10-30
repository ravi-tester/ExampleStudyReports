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
        caseStudyReportsPage.createNewReportRecord("Test Institute");
        caseStudyReportsPage.clickOnGivenSectionCogIcon("", "Consent", "Date of informed consent", "Clear","1");
//        caseStudyReportsPage.clickOnGivenSectionCogIcon("Informed Consent and Inclusion", "Study inclusion", "Informed consent signed", "Queries","1");
//        caseStudyReportsPage.clickOnGivenSectionCogIcon("Baseline", "Physical exam", "BMI", "History","1");
//        caseStudyReportsPage.clickOnGivenSectionCogIcon("Follow-up Visit", "Laboratory", "Blood trombocyte count", "SDV field","1");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        reportLog("======	Test Case Execution Completed	======");
    }
}

//        caseStudyReportsPage.clickOnGivenSectionCogIcon("", "Consent", "Date of informed consent", "User missing","1");
//        caseStudyReportsPage.clickOnGivenSectionCogIcon("", "Consent", "Date of informed consent", "Comments","2");
//        caseStudyReportsPage.clickOnGivenSectionCogIcon("", "Consent", "Date of informed consent", "History","2");
//        caseStudyReportsPage.clickOnGivenSectionCogIcon("", "Consent", "Date of informed consent", "Queries","2");
//        caseStudyReportsPage.clickOnGivenSectionCogIcon("", "Consent", "Date of informed consent", "SDV field","2");