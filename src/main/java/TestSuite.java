import java.util.ArrayList;
import java.util.List;

/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class TestSuite {
    List<TestCase> tests;

    public TestSuite() {
        tests = new ArrayList<>();
    }

    public void add(TestCase singleTest) {
        tests.add(singleTest);
    }

    public void run(TestResult result) {
        for (TestCase test : tests) {
            test.run(result);
        }
    }
}
