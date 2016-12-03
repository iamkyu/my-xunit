/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class WasRun extends TestCase{
    boolean wasRun;
    String log;

    public WasRun(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        wasRun = false;
        log = "setUp";
    }

    public void testMethod(){
        wasRun = true;
    }
}
