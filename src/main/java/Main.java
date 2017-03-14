/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class Main {
    public static void main(String[] args) {
        new TestCaseTest("testTemplateMethod").run().summary();
        new TestCaseTest("testResult").run().summary();
        new TestCaseTest("testFailedResult").run().summary();
        new TestCaseTest("testFailedResultFormatting").run().summary();
    }
}