package Transport.Factory.FineFactoryTests.MinorOffenseTests;

import Transport.Domain.Fines.Fine;
import Transport.Factory.FineFactories.FineFactory;
import Transport.Factory.FineFactories.MinorOffenses.MinorOffenseFactory;
import org.junit.Assert;
import org.junit.Test;

public class MinorOffenseFactoryTest {

    @Test
    public void getMinorOffense() {

        FineFactory fine = new FineFactory();

        String type = "Disobey Signs";
        Fine value = fine.getFine("AR4567","AC12874659", "084813456","MinorOffence", false);


        Assert.assertEquals("Type of Minor offence: Disobey Signs\nVehicles License: AC12874659\nDrivers ID: 084813456\nFine type: MinorOffence\nFine Paid: false",
                MinorOffenseFactory.getMinorOffense(type,value).toString());

    }
}