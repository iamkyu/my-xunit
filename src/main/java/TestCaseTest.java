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

    public void testTemplateMethod() {
        test = new WasRun("testMethod");
        result = test.run();
        assert result.summary().equals("1 run, 0 failed"); System.out.println(result.summary());
    }

    public void testResult() {
        test = new WasRun("testMethod");
        result = test.run();
        assert result.summary().equals("1 run, 0 failed"); System.out.println(result.summary());
    }

    public void testFailedResult() {
        test = new WasRun("testBrokenMethod");
        result = test.run();
        assert result.summary().equals("1 run, 1 failed"); System.out.println(result.summary());
    }

    public void testFailedResultFormatting() {
        result = new TestResult();
        result.testStarted();
        result.testFailed();
        assert result.summary().equals("1 run, 1 failed"); System.out.println(result.summary());
    }
}
