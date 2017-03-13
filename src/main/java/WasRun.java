/**
 * @author Kj Nam
 * @since 2017-03-13
 */
public class WasRun extends TestCase {
    boolean wasRun;

    public WasRun(String methodName) {
        super(methodName);
        wasRun = false;
    }

    public void testMethod() {
        wasRun = true;
    }

}
