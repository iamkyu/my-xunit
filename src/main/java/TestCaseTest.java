/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class TestCaseTest extends TestCase {
    WasRun test;
    TestResult testResult;

    public TestCaseTest(String methodName) {
        super(methodName);
    }

    @Override
    public void setUp() {
        testResult = new TestResult();
    }

    public void testSuite() {
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        suite.run(testResult);
    }

    public void testTemplateMethod() {
        // 자바의 assert를 사용하여 특정 조건(boolean)이 참일 때만 프로그램이 계속되도록 만들 수 있다.
        // 기본적으로 assertion은 무효로 되어 있기 때문에, 실행시 VM옵션에 -ea 를 추가해줘야 한다.
        // http://docs.oracle.com/javase/7/docs/technotes/guides/language/assert.html

        test = new WasRun("testMethod");
        test.run(testResult);
        assert "setUp testMethod tearDown".equals(test.log);
    }

    public void testResult() {
        test = new WasRun("testMethod");
        test.run(testResult);
    }

    public void testFailedResult() {
        test = new WasRun("testBrokenMethod");
        test.run(testResult);
    }

    public void testFailedResultFormatting() {
        testResult.testStarted();
        testResult.testFailed();
    }
}
