/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class WasRun {
    String name;
    boolean wasRun;

    public WasRun(String name) {
        this.name = name;
        wasRun = false;
    }

    public void testMethod() {
        wasRun = true;
    }
}
