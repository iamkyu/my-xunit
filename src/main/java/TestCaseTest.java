/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class TestCaseTest extends TestCase {
    public TestCaseTest(String methodName) {
        super(methodName);
    }

    public void testRunning() {
        WasRun test = new WasRun("testMethod");

        // 자바의 assert를 사용하여 특정 조건(boolean)이 참일 때만 프로그램이 계속되도록 만들 수 있다.
        // 기본적으로 assertion은 무효로 되어 있기 때문에, 실행시 VM옵션에 -ea 를 추가해줘야 한다.
        // http://docs.oracle.com/javase/7/docs/technotes/guides/language/assert.html

        assert test.wasRun == false : "test.wasRun 이미 실행됨"; System.out.println(test.wasRun);
        test.run();
        assert test.wasRun == true : "test.wasRun 실행되지 않았음"; System.out.println(test.wasRun);
    }
}