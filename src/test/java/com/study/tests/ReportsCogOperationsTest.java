package com.study.tests;

import com.study.base.StudyBaseClass;
import com.study.pages.CaseStudyDashBoardPage;
import com.study.pages.CaseStudyLoginPage;
import com.study.pages.CaseStudyReportsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportsCogOperationsTest extends StudyBaseClass {

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
    public void deleteExistingReports(){
        caseStudyDashBoardPage =  caseStudyLoginPage.loginForCaseStudy(userName, passWd);
        caseStudyDashBoardPage.selectExampleStudy();
        caseStudyReportsPage.deleteSomeRecords();
    }

    @Test
    public void create_New_Report_Test() {
        caseStudyDashBoardPage =  caseStudyLoginPage.loginForCaseStudy(userName, passWd);
        caseStudyDashBoardPage.selectExampleStudy();
        caseStudyReportsPage.selectNewReport();
        caseStudyReportsPage.createNewReportRecord();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        reportLog("======	Test Case Execution Completed	======");
    }
}
