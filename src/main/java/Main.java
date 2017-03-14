/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class Main {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite();
        suite.add(new TestCaseTest("testTemplateMethod"));
        suite.add(new TestCaseTest("testResult"));
        suite.add(new TestCaseTest("testFailedResultFormatting"));
        suite.add(new TestCaseTest("testFailedResult"));
        suite.add(new TestCaseTest("testSuite"));

        TestResult result = new TestResult();

        suite.run(result);
        System.out.println(result.summary());
    }
}