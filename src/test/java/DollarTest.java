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
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
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
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    static class Money implements Expression {
        protected int amount;
        protected String currency;

        public Money(int amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        @Override
        public boolean equals(Object obj) {
            Money money = (Money) obj;
            return amount == money.amount
                    && currency().equals(money.currency());
        }

        public static Money dollar(int amount) {
            return new Money(amount, "USD");
        }

        public static Money franc(int amount) {
            return new Money(amount, "CHF");
        }

        public Money times(int multiplier) {
            return new Money(amount * multiplier, currency);
        }

        public String currency() {
            return currency;
        }

        public Expression plus(Money addend) {
            return new Sum(this, addend);
        }

        @Override
        public Money reduce(String to) {
            return this;
        }
    }

    private class Bank {
        public Money reduce(Expression source, String to) {
            return source.reduce(to);
        }
    }

    interface Expression {
        Money reduce(String to);
    }

    private static class Sum implements Expression {
        public Money augend;
        public Money addend;

        public Sum(Money augend, Money addend) {
            this.augend = augend;
            this.addend = addend;
        }

        public Money reduce(String to) {
            int amount = augend.amount + addend.amount;
            return new Money(amount, to);
        }
    }
}