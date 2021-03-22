package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;


public final class ExtentReport {

    private static ExtentReports extent;

    private ExtentReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReports/index.html"); //raised a bug -->5.0.5
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Appium Training");
    }

    public static void getInstance()  {

        if(Objects.isNull(extent))
            new ExtentReport();

    }

    public static void createTestNode(String testname) {
        ExtendManager.setExtentTest(extent.createTest(testname));

    }

    public static void terminateInstance() {

        if(Objects.nonNull(extent)) {
            extent.flush();
            ExtendManager.unload();
        }
    }

}