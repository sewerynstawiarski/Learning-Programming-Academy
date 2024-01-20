package lpa;

import org.junit.Before;

import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount bankAccount;
    private static int count = 0;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count equals: " + count++ );
    }
    @org.junit.Before
    public void setUp() {
        bankAccount = new BankAccount("Tim", "Nowak", 1000.00, BankAccount.CHECKING);
        System.out.println("Running  a test." );
    }

    @org.junit.Test
    public void deposit() {
        double balance  = bankAccount.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() {
        double balance = bankAccount.withdraw(600, true);
        assertEquals(400, balance, 0);
    }
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() {
            bankAccount.withdraw(600, false);
            fail("Should have thrown IllegalArgumentException");
    }
    @org.junit.Test
    public void getBalance_deposit() {
        bankAccount.deposit(200.00, true);
        assertEquals(1200, bankAccount.getBalance(), 0);
    }
    @org.junit.Test
    public void getBalance_withdraw() {
        bankAccount.withdraw(200.00, true);
        assertEquals(800, bankAccount.getBalance(), 0);
    }
    @org.junit.Test
    public void isChecking() {
        assertTrue("The account is not checking account", bankAccount.isChecking());
    }
    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count: " + count++);
    }
    @org.junit.After
    public void tearDown() {
        System.out.println("Count = " + count++);
    }
}