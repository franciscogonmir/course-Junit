import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BankAccountNestedTest {


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

    @Nested
    class whenBalanceEqualsZero{
        @Test
        public void testWithDrawMinimumBalanceIs0(){
            BankAccount bankAccount = new BankAccount(0,0);
            assertThrows(RuntimeException.class,() -> bankAccount.withDraw(500));
        }
        @Test
        public void testWithDrawMinimunBalanceNegative1000(){
            BankAccount bankAccount = new BankAccount(0,-1000);
            bankAccount.withDraw(500);
            assertEquals(-500,bankAccount.getBalance());
        }
    }
}
