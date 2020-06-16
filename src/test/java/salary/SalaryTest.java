package salary;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import framework.AllureLoger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SalaryTest {

	static ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;
 
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Salary - check data")
	@Feature("Check algorithm")
	@Story("Check brutto/netto salary algorithm")
	@DisplayName("Check algorithm of brutto/netto salary")
	public void checkAlgorithmBruttonNetto() throws FileNotFoundException {
		 AllureLoger.info(System.getProperty("user.dir") +"/test-output/testReport.html");
		 File myObj = new File("filename.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	      }
	assumeTrue(false);
	}
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Salary - check data")
	@Feature("Check algorithm")
	@Story("Check income tax algorithm")
	@DisplayName("Check algorithm of income tax salary")
	public void checkAlgorithmTax() {
		assumeTrue(true);
	}
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Salary - check data")
	@Feature("Check salary for employee")
	@Story("Check income tax for employee")
	@DisplayName("Check income tax for employee")
	public void checkTaxForEmployee() {
		assumeTrue(false);
	}
	

    @BeforeAll
    public static void startReport() {
    	// initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
     AllureLoger.info(System.getProperty("user.dir") +"/test-output/testReport.html");
        
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        //To add system or environment info by using the setSystemInfo method.

        
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
	

}
