/**
 * @author Kj Nam
 * @since 2017-03-13
 */
public class TestCaseTest extends TestCase {
    WasRun test;
    TestResult result;

    public TestCaseTest(String methodName) {
        super(methodName);
    }

    @Override
    public void setUp() {
    }

    @Override
    public void tearDown() {
    }

    public void testSuite() {
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        result = new TestResult();
        suite.run(result);
        assert result.summary().equals("2 run, 1 failed");
    }

    public void testTemplateMethod() {
        test = new WasRun("testMethod");
        test.run(result);
        assert test.log.equals("setUp testMethod tearDown");
    }

    public void testResult() {
        test = new WasRun("testMethod");
        test.run(result);
        assert result.summary().equals("1 run, 0 failed");
    }

    public void testFailedResult() {
        test = new WasRun("testBrokenMethod");
        test.run(result);
        assert result.summary().equals("1 run, 1 failed");
    }

    public void testFailedResultFormatting() {
        result = new TestResult();
        result.testStarted();
        result.testFailed();
        assert result.summary().equals("1 run, 1 failed");
    }
}
