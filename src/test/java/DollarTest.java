import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kj Nam
 * @since 2017-03-11
 */
public class DollarTest {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);
    }

    class Dollar {
        int amount;

        public Dollar(int amount) {
            this.amount = amount;
        }

        public Dollar times(int multiplier) {
            return new Dollar(amount * multiplier);
        }
    }

}