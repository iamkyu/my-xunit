import java.lang.reflect.Method;

/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class TestCase {
    String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public void run() {
        try {
            Method method = this.getClass().getMethod(this.methodName);
            method.invoke(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
