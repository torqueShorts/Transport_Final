package Transport.Factory.ExternalFactoryTests;

import Transport.Factory.ExternalFactories.CourtFactory;
import org.junit.Assert;
import org.junit.Test;

public class CourtFactoryTest {

    @Test
    public void getCourt() {

        String name = "White Chapell";
        String jName = "Ericson";
        String fine = "AC210";

        Assert.assertEquals("Court: \n Court name: White Chapell\n Judge name: Ericson\n fine Number: AC210",
                CourtFactory.getCourt(name,fine,jName).toString());


    }
}