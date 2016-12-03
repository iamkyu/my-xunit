/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class WasRun extends TestCase{
    boolean wasRun;
    boolean wasSetup;

    public WasRun(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        wasSetup = true;
        wasRun = false;
    }

    public void testMethod(){
        wasRun = true;
    }
}
