import java.lang.reflect.Method;

/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public abstract class TestCase {
    String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public void setUp() {
    }

    public TestResult run(TestResult result) {
        result.testStarted();
        setUp();

        try {
            Method method = this.getClass().getMethod(this.methodName);
            method.invoke(this);
        } catch (Exception e) {
            result.testFailed();
        } finally {
            tearDown();
            return result;
        }
    }

    public void tearDown() {
    }
}
