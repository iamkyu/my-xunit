import java.lang.reflect.Method;

/**
 * @author Kj Nam
 * @since 2017-03-13
 */
public abstract class TestCase {
    String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public abstract void setUp();

    public abstract void tearDown();

    public TestResult run() {
        TestResult result = new TestResult();

        try {
            result.testStarted();

            setUp();
            Method method = this.getClass().getMethod(this.methodName);
            method.invoke(this);
            tearDown();

        } catch (Exception e) {
            result.testFailed();
        }

        return result;
    }
}
