/**
 * @author Kj Nam
 * @since 2017-03-13
 */
public class TestCaseTest extends TestCase {
    WasRun test;

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
        test.run();
        assert test.log.trim() == "setUp testMethod tearDown" : "test.wasSetup이 setup 되지 않음";
        System.out.println(test.log);
    }
}
