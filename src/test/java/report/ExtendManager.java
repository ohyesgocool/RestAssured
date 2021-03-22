package report;

import com.aventstack.extentreports.ExtentTest;

public class ExtendManager  {

    private static final ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return exTest.get();
    }

    public static void setExtentTest(ExtentTest test) {
        exTest.set(test);
    }

    public static void unload() {
        exTest.remove();
    }
}
