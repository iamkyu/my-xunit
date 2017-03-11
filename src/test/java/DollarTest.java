import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kj Nam
 * @since 2017-03-11
 */
public class DollarTest {
    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    public void testFranceMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
        assertFalse(new Franc(5).equals(Money.dollar(5)));
    }

    static class Dollar extends Money {
        public Dollar(int amount) {
            this.amount = amount;
        }

        public Dollar times(int multiplier) {
            return new Dollar(amount * multiplier);
        }
    }

    static class Franc extends Money {
        public Franc(int amount) {
            this.amount = amount;
        }

        public Franc times(int multiplier) {
            return new Franc(amount * multiplier);
        }
    }

    abstract static class Money {
        protected int amount;

        @Override
        public boolean equals(Object obj) {
            Money money = (Money) obj;
            return amount == money.amount && getClass().equals(money.getClass());
        }

        public static Dollar dollar(int amount) {
            return new Dollar(amount);
        }

        public static Money franc(int amount) {
            return new Franc(amount);
        }

        abstract Money times(int multiplier);

    }
}