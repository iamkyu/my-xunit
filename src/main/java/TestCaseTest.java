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
//        assert test.log.trim() == "setUp testMethod tearDown" : "test.wasSetup이 setup 되지 않음";
//        System.out.println(test.log);
        assert result.summary() == "1 run, 0 failed";
        System.out.println(result.summary());
    }

    public void testFailedResult() {
        test = new WasRun("testBrokenMethod");
        result = test.run();
        assert result.summary() == "1 run, 1 failed";
        System.out.println(result.summary());
    }

    public void testFailedResultFormatting() {
        result = new TestResult();
        result.testStarted();
        result.testFailed();
        assert result.summary() == "1 run, 1 failed";
    }
}
