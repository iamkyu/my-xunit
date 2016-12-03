/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class WasRun extends TestCase{
    boolean wasRun;

    public WasRun(String name) {
        super(name);
        wasRun = false;
    }

    public void testMethod(){
        wasRun = true;
    }
}
