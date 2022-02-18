import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ankAccountOrderedExecutionTest {

    static BankAccount bankAccount = new BankAccount(0,0);

    @Test
    @Order(2)
    public void testWithDraw(){
        bankAccount.withDraw(300);
        assertEquals(200,bankAccount.getBalance());
    }
    @Test
    @Order(1)
    public void testDeposit(){
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());
    }
}
