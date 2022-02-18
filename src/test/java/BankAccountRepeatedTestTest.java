import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {

    @RepeatedTest(5)
    @DisplayName("deposit 400 successfully")
    public void testDeposit(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
        System.out.println("Nr: "+repetitionInfo.getCurrentRepetition());
    }
}
