/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class TestResult {
    int runCount;

    public TestResult() {
        runCount = 0;
    }

    public void testStarted() {
        runCount++;
    }

    public String summary() {
        return String.format("%d run, 0 failed", runCount);
    }
}
