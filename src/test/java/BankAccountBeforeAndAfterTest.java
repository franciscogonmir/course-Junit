import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    @BeforeAll
    public static void prepTest(){
        System.out.println("Hi!");
        bankAccount = new BankAccount(500,0);
    }

    @Test
    public void testWithDraw() {
        bankAccount.withDraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(700, bankAccount.getBalance());
    }

    @AfterAll
    public static void endTest(){
        System.out.println("Bye!");
    }
}
