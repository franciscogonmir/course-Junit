import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test bankAccount class")
public class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(400, 0);
        //assumeTrue(bankAccount != null);
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
    }
}
