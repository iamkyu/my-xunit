/**
 * @author Kj Nam
 * @since 2017-03-14
 */
public class TestResult {
    int runCount;
    int failedCount;
    private boolean summary;

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

    public String summary() {
        return String.format("%d run, %d failed", runCount, failedCount);
    }
}
