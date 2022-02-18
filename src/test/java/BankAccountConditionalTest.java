import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class BankAccountConditionalTest {

    @Test
    @EnabledOnOs({OS.MAC})
    public void TestMac(){

    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void TestWindow(){

    }

    @Test
    @EnabledOnJre({JRE.JAVA_16})
    public void TestJRE(){

    }

    @Test
    @DisabledOnJre({JRE.JAVA_16})
    public void TestnoJRE16(){

    }
}
