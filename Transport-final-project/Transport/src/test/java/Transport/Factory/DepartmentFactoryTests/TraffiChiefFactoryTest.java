package Transport.Factory.DepartmentFactoryTests;

import org.junit.Assert;
import org.junit.Test;

public class TraffiChiefFactoryTest {

    @Test
    public void getTrafficChief() {

            String chiefID = "RD23567";
            String name = "John";
            String surname = "Wick";
            String fineCode = "RED738465";

        Assert.assertEquals("Traffic Chief: \nChief ID = RD23567\nChief name: John\nChief surname: Wick\n" +
                "Traffic Fine: RED738465",
                TraffiChiefFactory.getTrafficChief(chiefID,name, surname, fineCode).toString());


    }
}