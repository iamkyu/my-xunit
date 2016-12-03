/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class WasRun extends TestCase{
    String log;

    public WasRun(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        log = "setUp";
    }

    public void testMethod(){
        log = log + " testMethod";
    }

    @Override
    public void tearDown() {
        log = log + " tearDown";
    }
}
