package gt.cs4420.relationaldb.test;

public class TestFailedException extends RuntimeException {

    public TestFailedException(String testName) {
        super("Test failed: " + testName);
    }

    public TestFailedException(String testName, String message) {
        super("Test failed: " + testName + "; " + message);
    }

}
