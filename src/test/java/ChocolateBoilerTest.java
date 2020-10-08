import cs.lab.RegistrApp;
import org.testng.annotations.Test;

@Test
public class ChocolateBoilerTest {
    @Test
    public void testFill() throws Exception{
        ChocolateBoiler chocolateBoiler = new ChocolateBoiler();
        chocolateBoiler.fill();
        if(chocolateBoiler.isEmpty()){
            throw new Exception("Error");
        }
    }

    @Test
    public void testBoil() throws Exception{
        ChocolateBoiler chocolateBoiler = new ChocolateBoiler();
        chocolateBoiler.fill();
        chocolateBoiler.boil();
        if(chocolateBoiler.isEmpty() && !chocolateBoiler.isBoiled()){
            throw new Exception("Error");
        }
    }

    @Test
    public void testDrain() throws Exception{
        ChocolateBoiler chocolateBoiler = new ChocolateBoiler();
        chocolateBoiler.fill();
        chocolateBoiler.boil();
        chocolateBoiler.drain();
        if(!chocolateBoiler.isEmpty() && chocolateBoiler.isBoiled()){
            throw new Exception("Error");
        }
    }
}
