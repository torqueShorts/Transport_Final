package Transport.Factory.FineFactoryTests.MinorOffenseTests;

import Transport.Domain.Fines.Fine;
import Transport.Factory.FineFactories.MinorOffenses.DisobeySignsFactory;
import Transport.Factory.FineFactories.FineFactory;
import org.junit.Assert;
import org.junit.Test;

public class DisobeySignsFactoryTest {

    @Test
    public void getDisobeySign() {

        FineFactory fine = new FineFactory();


        String sign = "Stop";
        int amount = 500;
        Fine value = fine.getFine("AR47574","SW2637485", "0836748579", "MinorOffence", false);

        Assert.assertEquals("Vehicles License: SW2637485\nDrivers ID: 0836748579\nType of offence: MinorOffence\nFine Paid: false\nThe sign disobeyed: Stop\nAmount due: 500",
                DisobeySignsFactory.getDisobeySign(sign, 500, value).toString());


    }
}