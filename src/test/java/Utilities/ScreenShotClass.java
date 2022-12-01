package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ScreenShotClass {



    public static String takeScreenShot(WebDriver driver , String name) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\aothman\\eclipse-workspace\\Orange_LoginPage\\Screenshots\\"+name+".png");
        FileUtils.copyFile(file ,des);
        String errflpath = des.getAbsolutePath();
        return errflpath;
    }
}
