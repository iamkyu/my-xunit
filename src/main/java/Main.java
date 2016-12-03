/**
 * @author Kj Nam
 * @since 2016-12-03
 */
public class Main {
    public static void main(String[] args) {
        WasRun test = new WasRun("testMethod");
        System.out.println(test.wasRun); //false
        test.testMethod();
        System.out.println(test.wasRun); //true
    }
}
