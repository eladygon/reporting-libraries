package salary;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SalaryTest {
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Salary - check data")
	@Feature("Check algorithm")
	@Story("Check brutto/netto salary algorithm")
	@DisplayName("Check algorithm of brutto/netto salary")
	public void checkAlgorithmBruttonNetto() throws FileNotFoundException {
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

	}
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Salary - check data")
	@Feature("Check salary for employee")
	@Story("Check income tax for employee")
	@DisplayName("Check income tax for employee")
	public void checkTaxForEmployee() {

	}
	

}
