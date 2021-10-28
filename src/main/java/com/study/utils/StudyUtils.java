package com.study.utils;

import com.study.base.StudyBaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class StudyUtils extends StudyBaseClass {

    public static long PAGE_LOAD_TIMEOUT = 50;
    public static long IMPLICIT_WAIT = 30;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    public static String generateRandomEmailAddress(){
        String randomStringInput = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder newMail = new StringBuilder();
        Random rnd = new Random();
        while (newMail.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * randomStringInput.length());
            newMail.append(randomStringInput.charAt(index));
        }
        String newMailUserName = newMail.toString();
        return newMailUserName+"@gmail.com";
    }
}
