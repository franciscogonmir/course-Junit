import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Test bankAccount class")
public class BankAccountTest {

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
    @DisplayName("Test activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTrue(bankAccount.isActive());
    }
}
