import java.util.ArrayList;
import java.util.List;

/**
 * @author Kj Nam
 * @since 2017-03-14
 */
public class TestSuite {
    List<TestCase> tests;
    public TestSuite() {
        tests = new ArrayList<>();
    }

    public void add(TestCase test) {
        tests.add(test);
    }

    public void run(TestResult result) {
        for (TestCase test : tests) {
            test.run(result);
        }
    }
}
