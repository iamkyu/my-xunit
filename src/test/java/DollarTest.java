import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kj Nam
 * @since 2017-03-15
 */
public class DollarTest {
    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));

        assertTrue (Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));

        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    private static abstract class Money {
        protected int amount;
        protected String currency;

        Money(int amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        public abstract Money times(int multiplier);

        public String currency() {
            return currency;
        }

        public static Money dollar(int amount) {
            return new Dollar(amount, "USD");
        }

        public static Money franc(int amount) {
            return new Franc(amount, "CHF");
        }

        @Override
        public boolean equals(Object obj) {
            Money money = (Money) obj;
            return amount == money.amount
                    && getClass().equals(money.getClass());
        }

    }

    private static class Dollar extends Money {
        public Dollar(int amount, String currency) {
            super(amount, currency);
        }

        public Money times(int multiplier) {
            return Money.dollar(amount * multiplier);
        }

    }

    private static class Franc extends Money {
        public Franc(int amount, String currency) {
            super(amount, currency);
        }

        public Money times(int multiplier) {
            return Money.franc(amount * multiplier);
        }
    }

}