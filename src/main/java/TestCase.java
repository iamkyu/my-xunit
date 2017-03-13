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

    public void run() {
        try {
            Method method = this.getClass().getMethod(this.methodName);
            method.invoke(this);
        } catch (Exception e) {
            // TODO Something..
        }
    }
}
