package testBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBaseExtentReport {

	public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
			System.getProperty("user.dir") + "/target/ExtentReport.html");
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeAll
	public static void startReport() {
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setAnalysisStrategy(AnalysisStrategy.TEST);

		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		htmlReporter.config().setEncoding("ISO 8859-1");
	}

	@AfterAll
	public static void end() {
		extent.flush();
	}
	
}
