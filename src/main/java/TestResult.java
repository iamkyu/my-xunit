/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class TestResult {
    int runCount;
    int failedCount;

    public TestResult() {
        runCount = 0;
        failedCount = 0;
    }

    public void testStarted() {
        runCount++;
    }

    public void testFailed() {
        failedCount++;
    }

    public void summary() {
        System.out.println(String.format("%d run, %d failed", runCount, failedCount));
    }
}
