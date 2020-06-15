package person;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node.SkipResult;
import org.opentest4j.AssertionFailedError;

import dataStorage.DataStorage;
import dataStorage.Person;
import framework.AllureLoger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class EmployeeTest {
private final String company = "Company";
private final int expectedNumberOfEmp = 8;
private final int expectedNumberOfPoznan = 3;
	
	
@Test
@Severity(SeverityLevel.BLOCKER)
@Epic("Employees - check data")
@Feature("Check the number of employees")
@Story("All employees")
@DisplayName("Check the number of all employees in Company")
public void checkNumberOfAllEmplayees() {
	listOfAllEmp();
	checkNumberOfAllEmp(expectedNumberOfEmp);
}

@Test
@Severity(SeverityLevel.BLOCKER)
@Epic("Employees - check data")
@Feature("Check the number of employees")
@Story("Wroclaw employees")
@DisplayName("Check the number of Wroclaw employees in Company")
public void checkNumberOfWroclawEmplayees() {
	listOfCityEmp("Wroclaw");
	checkNumberOfWroclawEmp("Wroclaw",expectedNumberOfEmp);
}

@Test
@Severity(SeverityLevel.BLOCKER)
@Epic("Employees - check data")
@Feature("Check the number of employees")
@Story("Poznan employees")
@DisplayName("Check the number of Poznan employees in Company")
public void checkNumberOfPoznanEmplayees() {
	listOfCityEmp("Poznan");
	checkNumberOfWroclawEmp("Poznan",expectedNumberOfPoznan);
}

@Test
@Severity(SeverityLevel.BLOCKER)
@Epic("Employees - check data")
@Feature("Check position")
@Story("Java developer")
@DisplayName("Check  Java developers in Company")
public void checkPositionJavaDeveloper() {
	listOfPositionsEmp("Java developer");
	checkPosition("Java developer");
	}

@Test
@Severity(SeverityLevel.BLOCKER)
@Epic("Employees - check data")
@Feature("Check position")
@Story("Test developer")
@DisplayName("Check Test developer in Company")
public void checkPositionTestDeveloper() {	
	listOfPositionsEmp("Test developer");
	checkPosition("Test developer");	
}

@Test
@Severity(SeverityLevel.BLOCKER)
@Epic("Employees - check data")
@Feature("Check position")
@Story("Senior project architect")
@DisplayName("Check Senior project architect in Company")
public void checkPositionSeniorProjectArchitect() {	
	listOfPositionsEmp("Senior project architect");
	checkPosition("Senior project architect");	
}

@Test
@Severity(SeverityLevel.BLOCKER)
@Epic("Employees - check data")
@Feature("Check position")
@Story("Junior test developer")
@DisplayName("Check Junior test developer in Company")
public void checkPositionJuniorTestDeveloper() {	
	listOfPositionsEmp("Junior test developer");
	checkPosition("Junior test developer");	
}

@Test
@Severity(SeverityLevel.CRITICAL)
@Epic("Employees - check data")
@Feature("Check age of employees")
@Story("Check age of employees")
@DisplayName("Check if  employee is over 18")
public void checkAge() {	
StringBuilder errorMessage= new StringBuilder("");
for (Person p : DataStorage.listOfPerson ) {
	try{
		checkAge(p.getLastName(),p.getAge());
}catch(AssertionError er) {
	errorMessage.append(p.getLastName()+" is "+ p.getAge()+",  ");
	}
}
assertTrue(errorMessage.toString() +" but should be over 18 ",errorMessage.equals(""));
}









@Step("[STEP]Check age of employee {0}")
private void checkAge(String lastName, int age) {
		assertTrue(age>18);
}

@Step("[STEP] Check if there are {0}s in Company ")
private void checkPosition(String position) {
	long positionNumber = DataStorage.listOfPerson.stream().filter(x->x.getPosition().equals(position)).count();
	AllureLoger.log("There are "+ positionNumber+" "+position+"s");
	Assertions.assertTrue(positionNumber>0);
}

@Step("[STEP] List of {0} Company employess")
private void listOfCityEmp(String city) {
	DataStorage.listOfPerson.stream().filter(x->x.getCity().equals(city)).forEach(x->AllureLoger.info(x.getPersonNameAndPositionInfo()));
	
}

@Step("[STEP] List of all Company employess")
private void listOfAllEmp() {
	DataStorage.listOfPerson.forEach(x->AllureLoger.info(x.getPersonNameAndPositionInfo()));
}


@Step("[STEP] List of {0}s in Company")
private void listOfPositionsEmp(String position) {
	DataStorage.listOfPerson.stream().filter(x->x.getPosition().equals(position)).forEach(x->AllureLoger.info(x.getPersonNameAndPositionInfo()));
	
}

@Step("[STEP] Check if actual number of {0} employess is equal to expected ")
private void checkNumberOfWroclawEmp(String city, int expectedNumberOfEmp) {
	AllureLoger.log("Expected number of "+city+" employess: "+ expectedNumberOfEmp);
	AllureLoger.log("Actual number of "+city+" employess: "+ DataStorage.listOfPerson.stream().filter(x->x.getCity().equals(city)).count());
	Assertions.assertEquals(expectedNumberOfEmp,DataStorage.listOfPerson.stream().filter(x->x.getCity().equals(city)).count());
	
}


@Step("[STEP] Check if actual number of employess is equal to expected ")
private void checkNumberOfAllEmp(int  expectedNumberOfEmp) {
	AllureLoger.log("Expected number of employess: "+ expectedNumberOfEmp);
	AllureLoger.log("Actual number of employess: "+ DataStorage.listOfPerson.size());
	Assertions.assertEquals(expectedNumberOfEmp,DataStorage.listOfPerson.size());
	
}
}
