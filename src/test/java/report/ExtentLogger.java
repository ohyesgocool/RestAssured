package report;

public final class ExtentLogger {

    private ExtentLogger() {

    }

    public static void pass(String details) {
        ExtendManager.getExtentTest().pass(details);
    }

    public static void fail(String details) {
        ExtendManager.getExtentTest().fail(details);
    }


    public static void skip(String details) {
        ExtendManager.getExtentTest().skip(details);
    }
    public static void info(String details) {
        ExtendManager.getExtentTest().info(details);
    }
}