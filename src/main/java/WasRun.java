/**
 * @author Kj Nam
 * @since 2017-03-13
 */
public class WasRun extends TestCase {
    boolean wasRun;
    boolean wasSetUp;

    public WasRun(String methodName) {
        super(methodName);
    }

    @Override
    public void setUp() {
        wasSetUp = true;
        wasRun = false;
    }

    public void testMethod() {
        wasRun = true;
    }

}
