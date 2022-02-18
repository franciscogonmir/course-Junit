import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@DisplayName("Test bankAccount class")
public class BankAccountAssertionsTest {

    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithDraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withDraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("deposit 400 successfully")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithDrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withDraw(800);
        assertNotEquals(0,bankAccount.getBalance());

    }

    @Test
    @DisplayName("Test set holder")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.setHolder("Fran");
        assertNotNull(bankAccount.getHolder());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    public void testNoWithDrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class,() -> bankAccount.withDraw(2000));
    }

    @Test
    @DisplayName("Test no exception for withdraw and deposit")
    public void testWithDrawAndDepositWithoutExceptoions(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(()-> bankAccount.deposit(200), () -> bankAccount.withDraw(450));
    }

    @Test
    @DisplayName("Test speed deposit")
    public void testDepositTimeout(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
    }
}
