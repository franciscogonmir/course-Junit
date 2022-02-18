import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(BankAccountParameterResolver.class)
@Execution(ExecutionMode.CONCURRENT)
public class BankAcountParallelExecutionTest {

    @ParameterizedTest
    @ValueSource(doubles = {400})
    @DisplayName("deposit 400 successfully")
    public void testDeposit(double amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(doubles = {2})
    @DisplayName("deposit 2 successfully")
    public void testDeposit2(double amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {500})
    @DisplayName("deposit 500 successfully")
    public void testDeposit500(int amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

}
