package salary;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import dataStorage.Salary;
import extentReportsTests.CheckExtentReport;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import testBase.TestBaseExtentReport;

public class SalaryTest extends TestBaseExtentReport {


 
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Salary - check data")
	@Feature("Check algorithm")
	@Story("Check brutto/netto salary algorithm")
	@DisplayName("Check algorithm of brutto/netto salary")
	public void checkAlgorithmBruttonNetto() throws FileNotFoundException {
		test = extent.createTest("Check algorithm of brutto/netto salary");
		//ExtentTest step1 = step("Count salary for  "+3200);
		ExtentTest step1 = test.createNode("[STEP] Count netto salary for  "+3200+"brutto");
		
		Salary sal = new Salary(3200);
		step1.createNode("pension contribution "+(String.format("%.2f", sal.getPensionContribution())));
		step1.createNode("disability pension contribution  "+(String.format("%.2f", sal.getDisabilityPensionContribution())));
		step1.createNode("sickness contribution     	   "+(String.format("%.2f", sal.getSicknessContribution())));
		step1.createNode("health care contribution         "+(String.format("%.2f", sal.getHealthCareContribution())));
		step1.createNode("base of income tax 		       "+(String.format("%.2f", sal.getIncomeTax())));
		step1.createNode("income tax final 			       "+(String.format("%.2f", sal.getIncomeTaxFinal())));
		step1.createNode("netto salary	 			       "+(String.format("%.2f", sal.getNettonSalary())));
		
	
		
		
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
		test = extent.createTest("Check algorithm of income tax salary");
		ExtentTest node1 = test.createNode("Step1");
		ExtentTest node2  = node1.createNode("Substep");
		node2.createNode("SubstepSubstep").skip("Test skipped");
		
	
		assumeTrue(true);
		test.createNode("Step2");
	
	}
	
	@Test//junit
	@Severity(SeverityLevel.BLOCKER)//ALLURE
	@Epic("Salary - check data")//ALLURE
	@Feature("Check salary for employee")//ALLURE
	@Story("Check income tax for employee")//ALLURE
	@DisplayName("Check income tax for employee")//junit
	public void checkTaxForEmployee() {
		test = extent.createTest("Check income tax for employee");
		Assertions.assertFalse(true, "Salary - check data - forced to fail");
	}
	

	@Test//junit
	@Severity(SeverityLevel.BLOCKER)//ALLURE
	@Epic("Salary - check data")//ALLURE
	@Feature("Check salary for employee")//ALLURE
	@Story("Check income tax for employee")//ALLURE
	@DisplayName("Check income tax for employee")//junit
	public void checkPage() throws IOException {
		test = extent.createTest("Check if site is displayed");
		test.info("Open page: poradnikprzedsiebiorcy.pl");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\EDYGON\\WorkspaceReports\\test-report-tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://poradnikprzedsiebiorcy.pl/-jak-wyliczac-wynagrodzenia";
        String expectedTitle = "Jak wyliczać wynagrodzenia - składki i potrącenia - Poradnik Przedsiębiorcy";
        String actualTitle = "";
        driver.get(baseUrl);
        actualTitle = driver.getTitle();
        test.info("Actual title is "+actualTitle);
       
        final CheckExtentReport link = new CheckExtentReport();
        link.setLinkText("Link Text goes here");
        link.setLinkUrl("http://somedomain.com");
        test.log(Status.INFO, link);
        

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
        	TakesScreenshot ts = (TakesScreenshot) driver;
        	byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			File sourcePath = ts.getScreenshotAs(OutputType.FILE);
			File destinationPath = new File(System.getProperty("user.dir") + "/target/screenshoot.png");
			Files.copy(sourcePath, destinationPath);   
			test.info("destination screenshoot "+destinationPath.toString());
			MediaEntityBuilder.createScreenCaptureFromPath("screenshoot.png").build();
            test.log(Status.FAIL, "fail").addScreenCaptureFromPath("screenshoot.png");
         
        } else {
        	 test.fail("fail");
        }
       
       driver.close();
       
    }

	}

	


