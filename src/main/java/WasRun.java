/**
 * @author Kj Nam
 * @since 2017-03-13
 */
public class WasRun extends TestCase {
    boolean wasRun;
    String log;

    public WasRun(String methodName) {
        super(methodName);
    }

    @Override
    public void setUp() {
        wasRun = false;
        log = "setUp";
    }

    @Override
    public void tearDown() {
        log += "tearDown";
    }

    public void testMethod() {
        wasRun = true;
        log += " testMethod ";
    }
}
