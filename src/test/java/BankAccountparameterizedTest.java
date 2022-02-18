import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountparameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    @DisplayName("deposit 400 successfully")
    public void testDeposit(int amount ,BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
        System.out.println("Nr: " + repetitionInfo.getCurrentRepetition());
    }

    @ParameterizedTest
    @EnumSource(value=DayOfWeek.class, names = {"TUESDAY","THURSDAY"})
    public void testDayOfWeek(DayOfWeek day){
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
    @CsvSource({"100 , Mary","200, Rachid","150, Ted"})
    public void depositAndNameTest(double amount,String name,BankAccount bankAccount){
        bankAccount.deposit(amount);
        bankAccount.setHolder(name);
        assertEquals(amount,bankAccount.getBalance());
        assertEquals(name,bankAccount.getHolder());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "details.csv",delimiter = ',')
    public void depositAndNameTestFromCsv(double amount,String name,BankAccount bankAccount){
        bankAccount.deposit(amount);
        bankAccount.setHolder(name);
        assertEquals(amount,bankAccount.getBalance());
        assertEquals(name,bankAccount.getHolder());
    }
}
